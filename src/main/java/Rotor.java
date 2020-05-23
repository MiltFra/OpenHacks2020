
public class Rotor implements Encryptor {
    public static int MAP_LENGTH = 26;
    private Letter position;
    private Mapping mapping;
    private boolean[] step_on;
    private Letter step_count;

    public Rotor(Mapping mapping, Letter[] step_on) throws IllegalArgumentException {
        this.mapping = mapping;
        this.position = new Letter(0);
        this.step_on = new boolean[MAP_LENGTH];
        for (Letter l : step_on) {
            this.step_on[l.value] = true;
        }
        this.step_count = new Letter(0);
    }

    public void step() {
        this.position = this.position.shift(new Letter(1));
    }

    public Letter forward(Letter in) {
        this.step_count = this.step_count.next();
        if (this.step_on[this.step_count.value]) {
            this.step();
        }
        return this.mapping.forward(this.position, in);
    }

    public Letter backward(Letter in) {
        return this.mapping.backward(this.position, in);
    }
}