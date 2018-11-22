import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Image {
    public static void main(String args[]) {

        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("C:\\Users\\t00203592\\Pictures\\doctorSymbol.png");
        JLabel label = new JLabel("Hello");
        frame.add(label);
        frame.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
