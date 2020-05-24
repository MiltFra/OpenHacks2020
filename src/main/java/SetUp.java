import javax.swing.*;
import java.awt.*;


public class SetUp extends JFrame {



    SetUp() {
        new JFrame();
        //setBackground(Color.black);

        add(new InputPanel(), BorderLayout.NORTH);
        add(new MainPanel(), BorderLayout.CENTER);
        add(new OutputPanel(), BorderLayout.SOUTH);


        setLayout (new BoxLayout (getContentPane(), BoxLayout.Y_AXIS));
        setSize(Utils.width, Utils.height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
