
import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {

    private JLabel encryptedMessage;
    private JLabel encryptedLetter;


    private final int messageLength = 100;
    private final int padding = 20;

    public OutputPanel() {
        new JPanel();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        Utils.setFixSize(this, Utils.width, 50);
        setBackground(Color.gray);

        JLabel message = new JLabel("ENCRYPTED");
        encryptedMessage = new JLabel("");
        encryptedMessage.setBackground(Color.white);
        Utils.setFixSize(message, messageLength, Utils.textHeight);
        Utils.setFixSize(encryptedMessage, 300, Utils.textHeight);

        add(message);
        add(encryptedMessage);

        JLabel letterText = new JLabel("ENCRYPTED LETTER");
        encryptedLetter = new JLabel("");
        encryptedLetter.setBackground(Color.white);
        Utils.setFixSize(letterText, 200, Utils.textHeight);
        Utils.setFixSize(encryptedLetter, 50, Utils.textHeight);

        add(letterText);
        add(encryptedLetter);
    }

    public String getEncryptedMessage() {
        return encryptedMessage.getText();
    }

    public void setEncryptedLetter(String l) {
        encryptedMessage.setText(this.getEncryptedMessage() + l);
        encryptedLetter.setText(l);
    }
}
