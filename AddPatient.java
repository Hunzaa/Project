import javafx.scene.control.RadioButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javafx.scene.control.RadioButton;

public class AddPatient extends JFrame{
    JButton button1, button2;
    JTextField jTAId, jTAName;

    private Patient patient;

    public AddPatient() {
        Container cPane;

        //set the frame properties
        setTitle("Add Patient");
        setSize(500, 600);
        setResizable(false);
        setLocation(500, 500);
        // shut down the program when the window is closed
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());
        cPane.setBackground(Color.gray);

        JPanel jPanel1 = new JPanel();
        jPanel1.setSize(700, 400);


 /*       //1
        JLabel jLabelId = new JLabel("Id: ");
        JTextField jTAId = new JTextField();
        jPanel1.setLayout(new GridLayout(5, 5));
        jPanel1.add(jLabelId);
        jPanel1.add(jTAId);   */

        //1
        JLabel jLabelName = new JLabel("Name: ");
        JTextField jTAName = new JTextField();
        jPanel1.setLayout(new GridLayout(5, 5));
        jPanel1.add(jLabelName);
        jPanel1.add(jTAName);

        //2
        JLabel jLabelAddress = new JLabel("Address: ");
        JTextField jTAAddress = new JTextField(20);
        jPanel1.setLayout(new GridLayout(5, 5));
        jPanel1.add(jLabelAddress);
        jPanel1.add(jTAAddress);

        //3
        JLabel jLabelPhone = new JLabel("Phone: ");
        JTextField jTAPhone = new JTextField(20);
        jPanel1.setLayout(new GridLayout(5, 5));
        jPanel1.add(jLabelPhone);
        jPanel1.add(jTAPhone);

/*        //4
        JLabel jLabelDob = new JLabel("DOB: ");
        JTextField jTADob = new JTextField(20);
        jPanel1.setLayout(new GridLayout(10, 5));
        jPanel1.add(jLabelDob);
        jPanel1.add(jTADob); */

        //5
        JLabel jLabelGender = new JLabel("Gender: \n\n");
        JTextField jTAGender = new JTextField(20);
        jPanel1.setLayout(new GridLayout(5, 6));
        jPanel1.add(jLabelGender);
        jPanel1.add(jTAGender);

        /*
        JRadioButton r1 = new JRadioButton("\nMale");
        JRadioButton r2 = new JRadioButton("Female");
        JRadioButton r3 = new JRadioButton("Other");

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        jPanel1.add(r1);
        jPanel1.add(r2);
        jPanel1.add(r3);  */


        cPane.add(jPanel1);


        //JButton button1;
        //JButton button2;


        // construct two buttons
        button1 = new JButton("Save");
        button1.setBounds(300, 600, 80, 50);
        cPane.add(button1);
        //button1.addActionListener(this);

       // patient = new Patient();

        button1.addActionListener(e -> {
            String name = jTAName.getText();
            String address = jTAAddress.getText();
            String phone = jTAPhone.getText();
            char gender = jTAGender.getText().charAt(0);

            patient = new Patient(name,address,phone,gender);
            setVisible(false);

            JMenuFrame.patients.add(patient);

            //JMenuFrame.apatients.add(patientDetails.getPatient());


        });


        // construct two buttons
        button2 = new JButton("Clear");
        button2.setBounds(370, 250, 80, 50);
        cPane.add(button2);
        //button2.addActionListener(this);


     /* code for clear field
        button2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            JTextField.setName("");
            //textfield.setText(null); //or use this
        }
    });
    code end */


    }



    public Patient getPatient(){
        return patient;
    }

  //  public static void main(String[] args) {
  //      new AddPatient();
  //  }

    //code for clear field
    public void actionPerformed(ActionEvent e) {

        while (e.getActionCommand() .equals ("Clear")){
            jTAId.setText(null);
            jTAName.setText(null);
            return;
        }
    }
}

