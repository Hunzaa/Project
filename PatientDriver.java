import javax.swing.*;
import java.awt.Font;

public class PatientDriver extends JFrame{

    public static void main(String[] args) {

        //creating an object of arrays
        Patient [] patients = new Patient[20];

        //1. testing no-argument constructor...
        patients[0] = new Patient();
        // Patient p1 = new Patient();
        System.out.println("\nTesting no-argument constructor (p1) \n" + patients[0].toString() );

        //2. testing argument constructor...
        patients[1] = new Patient("Aria","NY","1",'F');
        // System.out.println("\nTesting argument constructor (p2) : \n" + patients[1].toString());


        patients[2] = new Patient("Aria","NY","0",'F');
        patients[3] = new Patient("Hannah","NY","1",'F');
       // patients[4] = new Patient("Spencer","NY",1,'F');



        JOptionPane.showMessageDialog(null,displayPatients(patients),"Patients",JOptionPane.INFORMATION_MESSAGE);
    }

    //textArea method
    public static JTextArea displayPatients(Patient[] patients)
    {
        JTextArea jta = new JTextArea();
        Font font = new Font("monospaced",Font.PLAIN,13);

        jta.setFont(font);
        jta.setText("--- Information ---\n");

        for(int x=0; x<patients.length; x++)
        {
            {
                if(patients[x] == null)
                    break;
            }
            jta.append("\nID: " + patients[x].getId() + "\n" );
            jta.append("Name: " + patients[x].getName() + "\n" );
            jta.append("Address: " + patients[x].getAddress() + "\n" );
            jta.append("Phone: " + patients[x].getPhone() + "\n" );
            jta.append("Gender: " + patients[x].getGender() + "\n" );
        }
        return jta;
    }
}
