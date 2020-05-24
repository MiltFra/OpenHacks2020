import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    MainPanel() {
        new JPanel();
        setBackground(Color.DARK_GRAY);
        setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));

        add(new RotorPanel());
        /*OutputPanel output = new OutputPanel();
        //make encryption here and pass the encryptedLetter
        String encryptedLetter = "L";
        output.setEncryptedLetter(encryptedLetter);

        add(output);*/
    }


}
