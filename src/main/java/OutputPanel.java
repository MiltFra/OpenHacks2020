
import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {

    private JLabel encryptedMessage;
    private JLabel encryptedLetter;

    private int xStart = 50;
    private int yStart = 50;

    private final int messageLength = 100;
    private final int padding = 20;

    OutputPanel() {
        new JPanel();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        Utils.setFixSize(this, Utils.width, 50);
        setBackground(Color.gray);

        JLabel message = new JLabel("ENCRYPTED");
        encryptedMessage = new JLabel("");
       // message.setBounds(xStart, yStart, messageLength, textHeight);
       // encryptedMessage.setBounds((xStart  +=  messageLength + padding), yStart, 300, textHeight);
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
        //letter.setBounds((xStart += 300 + padding), yStart, 100, textHeight);
        //encryptedLetter.setBounds((xStart += 100 + padding), yStart, 50, textHeight);

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
