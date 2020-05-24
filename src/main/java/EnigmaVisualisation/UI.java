package EnigmaVisualisation;

import org.w3c.dom.xpath.XPathResult;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private static final int width = 800;
    private static final int height = 500;

    private static boolean finished = true;
    private static int[] lettersUP = {1, 2, 3};
    private static final int rotorNum = 3;
    private static final int rotorDim = 100;
    private static final int rotorPadding = 50;
    private static final int asdf = 0;

    private static JFrame frame;
    private static JTextArea input;
    private static JPanel panel;
    private static JLabel output;
    private static JButton startButton;

    public static void setUP() {
        /** Frame containing the GUI */
        frame = new JFrame();
        frame.setTitle("ENIGMA");

        JPanel inputPanel = new JPanel();



        /** Input text field */
        input = new JTextArea();
        input.setBounds(50, 50, 200, 20);
        inputPanel.add(input);

        /** Button for starting the encrypting */
        startButton = new JButton("Start");
        startButton.setBounds(260, 50, 100, 20);
        inputPanel.add(startButton);
        //startButton.addActionListener(e -> output.setText(input.getText()));

        /** Panel visualising the encryption process */
        panel = new JPanel();
        panel.setBounds(50, 70, 500, 300);

        /** Output text for the encrypted message */
        output = new JLabel("Output");
        output.setBounds(50, 100, 200, 20);

        /** Panel containing the letters facing upwards on each rotor */
        JPanel rotorsPanel = new JPanel();
        JLabel[] rotors = new JLabel[rotorNum];
        for (int i = 0; i < rotorNum; i++) {
            rotors[i] = new JLabel();
            rotors[i].setText(lettersUP[i] + "");
            rotors[i].setBounds(50 + i * (rotorPadding + rotorDim), 300, rotorDim, rotorDim);
            rotorsPanel.add(rotors[i]);
        }


        //panel.add(input);
        //panel.add(startButton);
        panel.add(output);
        panel.add(rotorsPanel);

        frame.add(inputPanel);
        frame.add(panel);
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void update() {

    }

    public static void main(String[] args) {
        setUP();

        while (!finished) {
            update();
        }
    }
}
