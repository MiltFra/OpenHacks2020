import javax.swing.*;
import java.awt.*;

public class RotorPanel extends JLabel {

    //private static String letter;

    public RotorPanel(Letter letter) {

        new JLabel();
        Utils.setFixSize(this, Utils.rotorDim, Utils.rotorDim);
        setBorder(BorderFactory.createLineBorder(Color.black, 5));
        setText(letter.toString());

        //this.letter = this.getText();
    }

    /*public void setLetter(Letter letter) {
        //RotorPanel.letter = letter.toString();
        this.setText(letter.toString());

    }*/

}
