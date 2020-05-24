import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Utils {

    protected static final int width = 800;
    protected static final int height = 500;

    protected static final int padding = 10;
    protected static final int textHeight = 20;

    protected static final int rotorDim = 100;

    protected static final int headerTextLength = 150;

    public static void setFixSize(Component comp, int width, int height) {
        Objects.requireNonNull(comp, "ERROR: Component in setFixSize must not be null");

        comp.setMinimumSize(new Dimension(width, height));
        comp.setPreferredSize(new Dimension(width, height));
        comp.setMaximumSize(new Dimension(width, height));
    }
}
