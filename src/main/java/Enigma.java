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
        for (int i = this.rotors.length; i > 1; i--) {
            in = this.rotors[i-1].backward(in);
        }
        in = this.translator.forward(in);
        return in;
    }

    public Letter[] getTopPositions() {
        var positions = new Letter[this.rotors.length];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = this.rotors[i].getPosition();
        }
        return positions;
    }

    public String processString(String in) {
        var letters = Letter.arrayFromString(in);
        for (int i = 0; i < letters.length; i++) {
            letters[i] = this.process(letters[i]);
        }
        return Letter.arrayToString(letters);
    }
}