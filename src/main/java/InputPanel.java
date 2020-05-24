import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    private final JTextField input;

    private JLabel unencryptedLetter;

    InputPanel() {
        new JPanel();
        setLayout(new FlowLayout(FlowLayout.LEFT, Utils.padding, Utils.padding));
        setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
        Utils.setFixSize(this, Utils.width, 40);
        setBackground(Color.gray);

        JLabel message = new JLabel("MESSAGE");
        Utils.setFixSize(message, 65, 20);


        input = new JTextField("");
        Utils.setFixSize(input, 200, 20);
        input.setBackground(Color.gray);


        JButton startButton = new JButton("START");
        Utils.setFixSize(startButton, 100, 20);

        JLabel letterText = new JLabel("UNENCRYPTED LETTER");
        unencryptedLetter = new JLabel("");
        unencryptedLetter.setBackground(Color.white);
        Utils.setFixSize(letterText, 200, Utils.textHeight);
        Utils.setFixSize(unencryptedLetter, 50, Utils.textHeight);


        add(message);
        add(input);
        add(startButton);
        add(letterText);
        add(unencryptedLetter);

    }


    public String getInputText() {
        return input.getText();
    }
}
