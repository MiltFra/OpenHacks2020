/**
 * A simple subsitution cipher that is its own inverse.
 */
public class Mapping {

  /** The number of symbols in the mapping. */
  public static int SIZE = 26;

  /** Which letter each position corresponds to. */
  private final Letter[] map = new Letter[SIZE];

  /**
   * Given a permutation of Letters this constructs a mapping.
   * @param values An array of values that corresponds to a valid mapping.
   */
  public Mapping(final Letter[] values) {
    if (values.length != SIZE) {
      throw new IllegalArgumentException(
          "Given letter array has invalid size.");
    }
    final boolean[] targetSet = new boolean[SIZE];
    for (final Letter v : values) {
      targetSet[v.value] = true;
      if (values[values[v.value].value].value !=
          v.value) { // Nice code... TODO: fix this
        throw new IllegalArgumentException("Mappings can only occur in pairs.");
      }
    }
    for (final boolean b : targetSet) {
      if (!b) {
        throw new IllegalArgumentException(
            "Given letter array does not map to every letter.");
      }
    }
    System.arraycopy(values, 0, this.map, 0, SIZE);
  }

  /**
   * Given a position and an input, this returns the letter the input gets
   * mapped to. The input and output are shifted to and from their actual
   * locations to find the mapping that is appropriate.
   *
   * @param position The Letter that A gets translated to.
   * @param in The Letter to be encrypted.
   * @return The encrypted letter.
   */
  public Letter processPos(final Letter position, final Letter in) {
    return this.map[in.shift(position).value].unshift(position);
  }

  /**
   * Processes a single Letter.
   * @param in The letter to be processed.
   * @return The letter the input got mapped to.
   */
  public Letter process(final Letter in) { return this.map[in.value]; }

  /**
   * Converts the mapping back to an array of letters.
   * @return The permutation representing this mapping.
   */
  public Letter[] toLetterArray() {
    final var arr = new Letter[SIZE];
    for (int i = 0; i < SIZE; i++) {
      arr[i] = this.map[i];
    }
    return arr;
  }

  /**
   * Creates a new mapping from a string.
   * @param str The string representing the mapping.
   * @return A new mapping.
   */
  public static Mapping fromString(final String str) {
    if (str.length() != SIZE) {
      throw new IllegalArgumentException();
    }
    return new Mapping(Letter.arrayFromString(str));
  }
}