import javax.swing.*;

public class GUI {

    private static boolean finished = true;
    private SetUp s;

    public GUI(Enigma e) {
        s = new SetUp(e);
        if (s.getInputPanel().isStart()) {
            System.out.println("Start");
            Letter[] input = Letter.arrayFromString(s.getInputPanel().getInputText());
            System.out.println("Input " + s.getInputPanel().getInputText());
            int i = 0;
            while (i < input.length) {
                //System.out.println(input[i].toString());
                update(s, e, input[i]);
            }
        }

    }


    public static void update(SetUp s, Enigma e, Letter l) {
        //update UI after each event
        String encrypted = e.process(l).toString();
        s.getMainPanel().setRotorPanels(e.getTopPositions());
        s.getOutputPanel().setEncryptedLetter(encrypted);
        s.getInputPanel().setUnencryptedLetter(l.toString());
        SwingUtilities.updateComponentTreeUI(s);
        //s = new SetUp(e);

        /*s.invalidate();
        s.validate();
        s.repaint();*/
    }
}
