import java.awt.*;
import java.awt.image.*;

public class Draw {

  private static int HPADDING = 50;
  private static int VPADDING = 50;
  private static int HRPADDING = 20;
  private static int VRPADDING = 0;
  private final Enigma enigma;
  private final int width;
  private final int height;
  private Graphics2D graphics;
  private BufferedImage img;

  public Draw(final Enigma enigma, final int width, final int height) {
    this.width = width;
    this.height = height;
    this.enigma = enigma;
    this.img =
        new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
    this.graphics = img.createGraphics();
    this.graphics.setColor(Color.white);
    this.graphics.fillRect(0, 0, width, height);
    this.draw();
  }

  private void init() {
    this.img =
        new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
    this.graphics = img.createGraphics();
    this.graphics.setColor(Color.white);
    this.graphics.fillRect(0, 0, width, height);
  }

  public RenderedImage process(final Letter in) {
    this.init();
    enigma.process(in);
    this.draw();
    return this.getImage();
  }

  public RenderedImage[] processString(String in) {
    var arr = new RenderedImage[in.length() + 1];
    arr[0] = this.getImage();
    for (int i = 0; i < in.length(); i++) {
      arr[i + 1] = this.process(new Letter(in.charAt(i)));
    }
    return arr;
  }

  public void draw() { this.drawRotors(); }

  private void drawRotors() {
    this.graphics.setColor(Color.gray);
    final var rects = this.getRotorRects();
    final var maps = this.enigma.getMappings();
    final var poss = this.enigma.getTopPositions();
    final int rc = this.enigma.getRotorCount();
    for (int i = 0; i < rc; i++) {
      final var rect = rects[i];
      this.drawMapping(rect[0], rect[1], rect[2], rect[3], maps[i + 1],
                       poss[i]);
    }
  }

  private void drawReflector(final int x, final int y, int width, int height,
                             Mapping m) {
    this.graphics.setColor(Color.gray);
    this.graphics.fillRect(x, y, width, height);
  }

  private void drawMapping(final int x, final int y, final int width,
                           final int height, final Mapping m,
                           final Letter pos) {
    this.graphics.setColor(Color.gray);
    this.graphics.fillRect(x, y, width, height);
    this.drawInputs(x, y, width, height);
    this.drawOutputs(x, y, width, height);
    for (int i = 0; i < 26; i++) {
      final var j = m.processPos(pos, new Letter(i)).value;
      this.graphics.drawLine(x, inputHeight(x, y, width, height, i), x + width,
                             inputHeight(x, y, width, height, j));
    }
  }

  private int inputHeight(final int x, final int y, final int width,
                          final int height, final int i) {
    return y + 10 + (((height - 20) / 26) * (i * 10 + 5)) / 10;
  }

  private void drawInputs(final int x, final int y, final int width,
                          final int height) {
    this.graphics.setColor(Color.black);
    for (int i = 0; i < 26; i++) {
      final int pY = inputHeight(x, y, width, height, i);
      this.graphics.drawLine(x - 10, pY, x, pY);
    }
  }

  private void drawOutputs(int x, final int y, final int width,
                           final int height) {
    this.graphics.setColor(Color.black);
    x += width;
    for (int i = 0; i < 26; i++) {
      final int pY = inputHeight(x, y, width, height, i);
      this.graphics.drawLine(x, pY, x + 10, pY);
    }
    this.graphics.setColor(Color.black);
  }

  public RenderedImage getImage() { return this.img; }

  private int getRotorWidth() {
    return (this.width - HPADDING * 2) / (this.enigma.getRotorCount() + 2);
  }

  private int[][] getRotorRects() {
    final int rotorCount = this.enigma.getRotorCount();
    final int rotorWidth = this.getRotorWidth();
    final var arr = new int[rotorCount][];
    for (int i = 0; i < rotorCount; i++) {
      final var rect = new int[4];
      rect[0] = HPADDING + HRPADDING + (i + 1) * rotorWidth;
      rect[1] = VPADDING + VRPADDING;
      rect[2] = rotorWidth - HRPADDING * 2;
      rect[3] = this.height - (VPADDING + VRPADDING) * 2;

      arr[i] = rect;
    }
    return arr;
  }
}