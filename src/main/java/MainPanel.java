import jdk.jshell.execution.Util;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MainPanel extends JPanel {

    private RotorPanel[] rotorPanels;

    public MainPanel(Letter[] letters) {
        Objects.requireNonNull(letters, "ERROR: letters must not be null in MainPanel");
        for (int i = 0; i < letters.length; i++) {
            Objects.requireNonNull(letters[i], "ERROR: all of the letters must not be null in MainPanel");
        }

        new JPanel();
        setBackground(Color.DARK_GRAY);
        setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
        JPanel panel = new JPanel();
        setLayout(new FlowLayout(FlowLayout.CENTER, Utils.padding, Utils.padding));

        /** Creating and adding the RotorPanels to the MainPanel */
        rotorPanels = new RotorPanel[letters.length];
        for (int i = 0; i < letters.length; i++) {
            rotorPanels[i] = new RotorPanel(letters[i]);
            System.out.println(letters[i].toString());
            panel.add(rotorPanels[i]);
        }

        add(panel);
    }


    public RotorPanel[] getRotorPanels() {
        return rotorPanels;
    }

    public void setRotorPanels(Letter[] letters) {
        if (letters.length != rotorPanels.length) {
            throw new IllegalArgumentException("ERROR: Number of rotors must equal number of letters in MainPanel setRotorPanels");
        }
        for (int i = 0; i < rotorPanels.length; i++) {
            rotorPanels[i].setText(letters[i].toString());
        }
    }
}
