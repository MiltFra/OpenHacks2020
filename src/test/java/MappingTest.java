import static org.junit.Assert.fail;

import org.junit.Test;

public class MappingTest {
  @Test
  public void testInvalidLength() {
    var arr = new Letter[1];
    try {
      new Mapping(arr);
    } catch (IllegalArgumentException e) {
      return;
    }
    fail();
  }

  @Test
  public void testConstructorNullPointerArray() {
    try {
      new Mapping(null);
    } catch (NullPointerException e) {
      return;
    }
    fail();
  }

  @Test
  public void testConstructorNullPointerElement() {
    var arr = new Letter[Mapping.SIZE];
    try {
      new Mapping(arr);
    } catch (NullPointerException e) {
      return;
    }
    fail();
  }

  @Test
  public void testConstructorInvalidSwap() {
    try {
      Mapping.fromString("CABDEFGHIJKLMNOPQRSTUVWXYZ");
    } catch (IllegalArgumentException e) {
      return;
    }
    fail();
  }
}
