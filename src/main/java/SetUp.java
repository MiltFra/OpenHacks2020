import javax.swing.*;
import java.awt.*;


public class SetUp extends JFrame {

    private static InputPanel inputPanel;
    private static MainPanel mainPanel;
    private static OutputPanel outputPanel;



    public SetUp(Enigma e) {
        new JFrame();
        Letter[] letters = e.getTopPositions();

        inputPanel = new InputPanel();
        mainPanel = new MainPanel(letters);
        outputPanel = new OutputPanel();

        add(inputPanel, BorderLayout.NORTH);
        System.out.println("inputPanel added");
        add(mainPanel, BorderLayout.CENTER);
        System.out.println("mainPanel added");
        add(outputPanel, BorderLayout.SOUTH);
        System.out.println("outputPanel added");


        setLayout (new BoxLayout (getContentPane(), BoxLayout.Y_AXIS));
        setSize(Utils.width, Utils.height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static InputPanel getInputPanel() {
        return inputPanel;
    }

    public static MainPanel getMainPanel() {
        return mainPanel;
    }

    public static OutputPanel getOutputPanel() {
        return outputPanel;
    }
}
