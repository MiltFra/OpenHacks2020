public class Mapping {
  public static int SIZE = 26;
  private final Letter[] map = new Letter[SIZE];

  public Mapping(Letter[] values) {
    if (values.length != SIZE) {
      throw new IllegalArgumentException(
          "Given letter array has invalid size.");
    }
    boolean[] targetSet = new boolean[SIZE];
    for (Letter v : values) {
      targetSet[v.value] = true;
      if (values[values[v.value].value].value !=
          v.value) { // Nice code... TODO: fix this
        throw new IllegalArgumentException("Mappings can only occur in pairs.");
      }
    }
    for (boolean b : targetSet) {
      if (!b) {
        throw new IllegalArgumentException(
            "Given letter array does not map to every letter.");
      }
    }
    System.arraycopy(values, 0, this.map, 0, SIZE);
  }

  public Letter processPos(Letter position, Letter in) {
    return this.map[in.shift(position).value].unshift(position);
  }

  public Letter process(Letter in) { return this.map[in.value]; }

  public Letter[] toLetterArray() {
    var arr = new Letter[SIZE];
    for (int i = 0; i < SIZE; i++) {
      arr[i] = this.map[i];
    }
    return arr;
  }

  public static Mapping fromString(String str) {
    if (str.length() != SIZE) {
      throw new IllegalArgumentException();
    }
    return new Mapping(Letter.arrayFromString(str));
  }
}