/**
 * A mapper with internal state. Depending on the configuration, each input
 * might cause rotation and therefore a change in behaviour.
 */
public class Rotor {

  /**
   * The current position of the rotor, i.e. the letter 'A' gets interpreted
   * as.
   */
  private Letter position;

  /** The wiring of the rotor and the resulting mapping of characters. */
  private Mapping mapping;

  /**
   * Whether or not a rotation occurs if the current letter is at the top of
   * the rotor.
   */
  private boolean[] step_on;

  /** How many steps have been done so far. (i.e. forward passes) */
  private Letter step_count;

  /**
   * Given a mapping and a valid step_on array, this constructs a Rotor.
   * @param mapping A valid mapping.
   * @param step_on Array of Letters steps are supposed to occur on.
   */
  public Rotor(Mapping mapping, Letter[] step_on) {
    this.mapping = mapping;
    this.position = Letter.zero;
    this.step_on = new boolean[Mapping.SIZE];
    for (Letter l : step_on) {
      this.step_on[l.value] = true;
    }
    this.step_count = Letter.zero;
  }

  /**
   * Turns the rotor by a single step.
   */
  public void step() { this.position = this.position.next(); }

  /**
   * Passes a Letter from the front through the rotor, thus triggering rotating
   * mechanisms.
   * @param in The letter to be processed.
   * @return The resulting letter.
   */
  public Letter forward(Letter in) {
    this.step_count = this.step_count.next();
    if (this.step_on[this.step_count.value]) {
      this.step();
    }
    return this.mapping.processPos(this.position, in);
  }

  /**
   * Passes a Letter from the back through the rotor, thus not triggering any
   * rotating mechanisms.
   * @param in The letter to be processed.
   * @return The resulting letter.
   */
  public Letter backward(Letter in) {
    return this.mapping.processPos(this.position, in);
  }

  /**
   * The current rotor position.
   * @return The position as a Letter.
   */
  public Letter getPosition() { return this.position; }

  /**
   * The mapping of this rotor.
   * @return The mapping.
   */
  public Mapping getMapping() { return this.mapping; }
}