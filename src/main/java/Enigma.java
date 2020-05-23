public class Enigma {
    private Rotor[] rotors;
    private Mapping reflector;
    private Mapping translator;

    public Enigma(Rotor[] rotors, Mapping translator, Mapping reflector) {
        this.rotors = rotors;
        this.reflector = reflector;
        this.translator = translator;
    }

    public Letter process(Letter in) {
        in = this.translator.forward(in);
        for (int i = 0; i < this.rotors.length; i++) {
            in = this.rotors[i].forward(in);
        }
        in = this.reflector.forward(in);
        for (int i = this.rotors.length - 1; i >= 0; i--) {
            in = this.rotors[i].backward(in);
        }
        in = this.translator.forward(in);
        return in;
    }
}