/**
 * A simple immutable class wrapping around an integer to maintain the invariant
 * of letters (being within [0, 25]).
 */
public class Letter {

  /**
   * The minimum value of the Letter. Please don't change this, it might break
   * something somewhere...
   */
  public static final int MIN_VALUE = 0;

  /**
   * The maximum value of the Letter. Please don't change this, it might break
   * something somewhere...
   */
  public static final int MAX_VALUE = 25;

  /** The actual value of the Letter. */
  public final int value;

  /** The zero letter, i.e. A. */
  public static final Letter zero = new Letter(MIN_VALUE);

  /**
   * Given a character that corresponds to a letter, this creates a new Letter
   * object.
   * @param value An upper or lower case character to be represented.
   * @throws IllegalArgumentException If a non-letter character is passed.
   */
  public Letter(final char value) throws IllegalArgumentException {
    this((int)Character.toUpperCase(value) - 'A');
  }

  /**
   * Given an integer value that corresponds to a letter in the alphabet, this
   * creates a new Letter object.
   * @param value An integer within [0,25].
   * @throws IllegalArgumentException If an integer out of the given interval is
   *     passed.
   */
  public Letter(final int value) throws IllegalArgumentException {
    if (value < MIN_VALUE) {
      throw new IllegalArgumentException("Given value is less than minimum.");
    }
    if (value > MAX_VALUE) {
      throw new IllegalArgumentException("Given value exceeds maximum.");
    }
    this.value = value;
  }

  /**
   * Returns the Letter that is in the current Letter spot on a Rotor in the
   * given position.
   * @param position The intial letter.
   * @return The letter in its spot.
   */
  public Letter shift(final Letter position) {
    return new Letter((position.value + this.value) % (MAX_VALUE + 1));
  }

  /**
   * Reverts shift.
   * @param position The shifted letter.
   * @return The original letter.
   */
  public Letter unshift(final Letter position) {
    return new Letter((this.value - position.value + MAX_VALUE + 1) %
                      (MAX_VALUE + 1));
  }

  /**
   * The Letter after a single step of the rotor.
   * @return The new letter.
   */
  public Letter next() {
    if (this.value == 0) {
      return new Letter(MAX_VALUE);
    }
    return new Letter(this.value - 1);
  }

  @Override
  public String toString() {
    return Character.toString(this.toChar());
  }

  /**
   * Converts the letter to a printable character.
   * @return A printable letter.
   */
  public char toChar() { return (char)(this.value + 'A'); }

  /**
   * Converts a given String to an array of letters.
   * @param in A String to convert.
   * @return The corresponding Letter array.
   */
  public static Letter[] arrayFromString(final String in) {
    final Letter[] letters = new Letter[in.length()];
    for (int j = 0; j < in.length(); j++) {
      letters[j] = new Letter(in.charAt(j));
    }
    return letters;
  }

  /**
   * Converts an array of Letter to a String.
   * @param in A Letter array to convert.
   * @return A String built from the letter array.
   */
  public static String arrayToString(final Letter[] in) {
    final var chars = new char[in.length];
    for (int i = 0; i < in.length; i++) {
      chars[i] = in[i].toChar();
    }
    return new String(chars);
  }
}