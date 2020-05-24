/**
 * Handles the encryption using its current internal state.
 */
public class Enigma {
  /** The rotating encryption components of the enigma. May be empty. */
  private final Rotor[] rotors;

  /**
   * The non rotating encryption component at the end of the enigma. May not be
   * null.
   */
  private final Mapping reflector;
  /**
   * The non rotating encryption component at the beginning of the enigma. May
   * not be null.
   */
  private final Mapping translator;

  /**
   * To create an Enigma you need
   *
   * - a translator (which letter does each input key correspond to)
   * - an array of rotors
   * - a reflector (in between the forward and backward pass through the rotors)
   * @param rotors rotors used in the enigma
   * @param translator a simple mapping
   * @param reflector a simple mapping
   */
  public Enigma(final Rotor[] rotors, final Mapping translator,
                final Mapping reflector) {
    this.rotors = rotors;
    this.reflector = reflector;
    this.translator = translator;
  }
  /**
   * Given a letter, this changes the internal state accordingly and returns the
   * encrypted letter.
   * @param in A single letter.
   * @return A single letter.
   */
  public Letter process(Letter in) {
    in = this.translator.process(in);
    for (int i = 0; i < this.rotors.length; i++) {
      in = this.rotors[i].forward(in);
    }
    in = this.reflector.process(in);
    for (int i = this.rotors.length; i > 1; i--) {
      in = this.rotors[i - 1].backward(in);
    }
    in = this.translator.process(in);
    return in;
  }

  /**
   * Returns an array of letters corresponding to the internal rotors that show
   * which letter is at the top for each one.
   * @return Letters that are at the top.
   */
  public Letter[] getTopPositions() {
    final var positions = new Letter[this.rotors.length];
    for (int i = 0; i < positions.length; i++) {
      positions[i] = this.rotors[i].getPosition();
    }
    return positions;
  }

  /**
   * Processes an entire String to make encryption more convenient. Don't use
   * this if you want to track the internal state.
   * @param in
   * @return
   */
  public String processString(final String in) {
    final var letters = Letter.arrayFromString(in);
    for (int i = 0; i < letters.length; i++) {
      letters[i] = this.process(letters[i]);
    }
    return Letter.arrayToString(letters);
  }

  /**
   * Returns the mappings of all the components of the enigma. The first element
   * is the translator (plug board), then there are all the rotors and finally
   * you get the reflectors configuration.
   * @return An array of all the Mappings.
   */
  public Mapping[] getMappings() {
    final var mappings = new Mapping[2 + this.rotors.length];
    mappings[0] = this.translator;
    for (int i = 0; i < this.rotors.length; i++) {
      mappings[i + 1] = this.rotors[i].getMapping();
    }
    mappings[mappings.length - 1] = this.reflector;
    return mappings;
  }

  public int getRotorCount() { return this.rotors.length; }
}