import javax.swing.*;
import java.awt.*;

public class RotorPanel extends JPanel {
    RotorPanel() {
        new JPanel();
        setLayout(new FlowLayout(FlowLayout.CENTER, Utils.padding, Utils.padding));
        setAlignmentY(JPanel.CENTER_ALIGNMENT);
        setBackground(Color.white);
        //setBounds(50, 50, 300, 100);

        JLabel rotor1 = new JLabel("1");
        Utils.setFixSize(rotor1, Utils.rotorDim, Utils.rotorDim);
        rotor1.setBorder(BorderFactory.createLineBorder(Color.black, 5));

        JLabel rotor2 = new JLabel("2");
        Utils.setFixSize(rotor2, Utils.rotorDim, Utils.rotorDim);
        rotor2.setBorder(BorderFactory.createLineBorder(Color.black, 5));

        JLabel rotor3 = new JLabel("3");
        Utils.setFixSize(rotor3, Utils.rotorDim, Utils.rotorDim);
        rotor3.setBorder(BorderFactory.createLineBorder(Color.black, 5));

        add(rotor1);
        add(rotor2);
        add(rotor3);
    }
}
