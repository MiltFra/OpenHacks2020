public class Letter {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 25;
    public final int value;

    public static final Letter zero = new Letter(MIN_VALUE);

    public Letter(char value) throws IllegalArgumentException {
        this((int) Character.toUpperCase(value) - 'A');
    }

    public Letter(int value) throws IllegalArgumentException {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("Given value is less than minimum.");
        }
        if (value > MAX_VALUE) {
            throw new IllegalArgumentException("Given value exceeds maximum.");
        }
        this.value = value;
    }

    public Letter shift(Letter position) {
        return new Letter((position.value + this.value) % (MAX_VALUE + 1));
    }

    public Letter unshift(Letter position) {
        return new Letter((this.value - position.value + MAX_VALUE + 1) % (MAX_VALUE + 1));
    }

    public Letter next() {
        if (this.value == MAX_VALUE) {
            return new Letter(MIN_VALUE);
        }
        return new Letter(this.value + 1);
    }
}