public class Reflector implements Encryptor {
    public static int MAP_LENGTH = 26;
    private static Letter POS = new Letter(0);

    private Mapping mapping;

    public Reflector(Mapping mapping) {
        this.mapping = mapping;
    }

    public Letter forward(Letter in) {
        return this.mapping.forward(POS, in);
    }

    public Letter backward(Letter in) {
        return this.mapping.backward(POS, in);
    }
}