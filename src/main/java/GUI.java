import javax.swing.*;

public class GUI{

    private static boolean finished = true;

    private static final int rotorNum = 3;
    private static int[] lettersUP = {1, 2, 3};

    private static final int width = 800;
    private static final int height = 500;

    private static JFrame frame;
    //private static


    public static void update() {
        //update UI after each event
    }

    public static void main(String[] args) {
        new SetUp();
        /*
        while (!finished) {
            update();
        }

         */
    }
}