package EnigmaVisualisation;

public class Enigma {
    private Encryptor[] rotors;
    private Encryptor reflector;

    public Enigma(Encryptor[] rotors, Encryptor reflector) {
        this.rotors = rotors;
        this.reflector = reflector;
    }

    public Letter process(Letter in) {
        for (int i = 0; i < this.rotors.length; i++) {
            in = this.rotors[i].forward(in);
        }
        in = this.reflector.forward(in);
        for (int i = this.rotors.length - 1; i >= 0; i--) {
            in = this.rotors[i].backward(in);
        }
        return in;
    }
}