import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewAppointments extends JFrame {

    public ViewAppointments() {
        Container cPane;

        //set the frame properties
        setTitle("View Appointments");
        setSize(500, 300);
        setResizable(false);
        setLocation(300, 300);
        // shut down the program when the window is closed
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());
        cPane.setBackground(Color.lightGray);

        JPanel jPanel1 = new JPanel();
        jPanel1.setSize(300, 400);

        final JFormattedDateTextField formattedTf = new JFormattedDateTextField();
        formattedTf.setValue(new Date());

        //1
        JLabel jLabelDate = new JLabel("Enter Date: ");
        //JTextField jTADate = new JTextField();
        jPanel1.setLayout(new GridLayout(1, 4));
        jPanel1.add(jLabelDate);
        //jPanel1.add(jTADate);




        cPane.add(jPanel1);
        cPane.add(formattedTf);

        Cal cal= new Cal();



        JButton button1;

        // construct two buttons
        button1 = new JButton("Search");
        button1.setBounds(300,600,80,50);
        cPane.add(button1);

        cPane.add(cal);
        //Cal.main();

    }
}


    /* link for the JFormattedDateTextField

    http://esus.com/creating-a-jformattedtextfield-that-only-accepts-dates/

    dateeee */

    class JFormattedDateTextField extends JFormattedTextField {
        Format format = new SimpleDateFormat("MM/dd/yyyy");

        public JFormattedDateTextField() {
            super();
            MaskFormatter maskFormatter = null;
            try {
                maskFormatter = new MaskFormatter("##/##/####");
            } catch (ParseException e) {
                e.printStackTrace();
            }

            maskFormatter.setPlaceholderCharacter('_');
            setFormatterFactory(new DefaultFormatterFactory(maskFormatter));
            this.addFocusListener(new FocusAdapter() {
                public void focusGained(FocusEvent e) {
                    if (getFocusLostBehavior() == JFormattedTextField.PERSIST)
                        setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
                }

                public void focusLost(FocusEvent e) {
                    try {
                        Date date = (Date) format.parseObject(getText());
                        setValue(format.format(date));
                    } catch (ParseException pe) {
                        setFocusLostBehavior(JFormattedTextField.PERSIST);
                        setText("");
                        setValue(null);
                    }
                }
            });
        }

        public void setValue(Date date) {
            super.setValue(toString(date));
        }

        private String toString(Date date) {
            try {
                return format.format(date);
                }
            catch (Exception e) {
                return "";
            }
        }
}