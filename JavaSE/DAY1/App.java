package DAY1;
import javax.swing.*;
public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First GUI");
        frame.setSize(520,538);
        frame.setTitle("2048");
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
