package EnigmaVisualisation;

public class Mapping {
    public static int SIZE = 26;
    private final Letter[] fw_map = new Letter[SIZE];
    private final Letter[] bw_map = new Letter[SIZE];

    public Mapping(Letter[] values) {
        if (values.length != SIZE) {
            throw new IllegalArgumentException("Given letter array has invalid size.");
        }
        boolean[] targetSet = new boolean[SIZE];
        for (Letter v : values) {
            targetSet[v.value] = true;
            if (values[values[v.value].value].value != v.value) { // Nice code... TODO: fix this
                throw new IllegalArgumentException("Mappings can only occur in pairs.");
            }
        }
        for (boolean b : targetSet) {
            if (!b) {
                throw new IllegalArgumentException("Given letter array does not map to every letter.");
            }
        }
        System.arraycopy(values, 0, this.fw_map, 0, SIZE);
        for (int i = 0; i < values.length; i++) {
            this.bw_map[values[i].value] = new Letter(i);
        }
    }

    public Letter forward(Letter position, Letter in) {
        return this.fw_map[in.shift(position).value].unshift(position);
    }

    public Letter backward(Letter position, Letter in) {
        return this.bw_map[in.shift(position).value].unshift(position);
    }
}