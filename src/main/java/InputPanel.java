import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class InputPanel extends JPanel {
    private final JTextField input;

    private JLabel unencryptedLetter;
    private String text;
    private boolean start = false;

    public InputPanel() {
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
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                text = input.getText();
                start = true;
                System.out.println("Input " + text);
            }
        });

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

    public boolean isStart() {
        return start;
    }

    public String getInputText() {
        Objects.requireNonNull(text, "ERROR: inputText must not be null before start of encryption");
        return text;
    }

    public void setUnencryptedLetter(String l) {
        this.unencryptedLetter.setText(l);
    }
}
