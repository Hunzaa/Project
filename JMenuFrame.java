import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;
/**
 *   JMenuFrame: includes one JMenuBar,2 JMenus and 8 JMenuItem objects. 
 *   When a menu item is selected, a string
 *   showing which menu choice is selected will appear in a label on the frame.
 */
public class JMenuFrame extends JFrame implements ActionListener {
    JMenu fileMenu;
    JMenu appointmentMenu;
    JMenu patientMenu;
    JLabel response; // to hold a result from the menus

    // Patient [] patients;
    int count;

    static ArrayList<Patient> patients;
    static ArrayList<Appointment> appointments;

    //------------------------------------------------------------------------------------------------------------------
    public void newSystem()
    {
       patients= new ArrayList<Patient>();
    }
    public void newSystem2()
    {
        appointments= new ArrayList<Appointment>();
    }

    //------------------------------------------------------------------------------------------------------------------
    public JMenuFrame() throws IOException
    {
        newSystem();
        Container cPane;

        //1. setting the frame properties
        setTitle     ("MEDIDOC");
        setSize      (800,600);
        setResizable (false);
        setLocation  (300,300);

        //2. shut down the program when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowEventHandler());

        cPane = getContentPane();

        //3. image
        //create a BufferedImage from a jpg file
        BufferedImage image = ImageIO.read(new File("E:\\1. Object Oriented Programming\\3. Problem Sets\\Project\\src\\docBg.jpg"));
        JLabel mainLabel = new JLabel(new ImageIcon(image));
        setContentPane(mainLabel);
        JPanel jpanel=new JPanel();
        jpanel.setSize(50,50);
        //image end...

        //4. creating menu items
        createFileMenu();
        createAppintmentMenu();
        createPatientMenu();

        //5. adding menu items to the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.orange);
        menuBar.add(fileMenu);
        menuBar.add(appointmentMenu);
        menuBar.add(patientMenu);

        //6. creating and positioning title/response label
        response = new JLabel("Welcome to MEDIDOC\n\n\n" );
        response.setBounds(395,10,500,50);
        response.setFont(new Font("Bold", Font.BOLD, 17));
        mainLabel.add(response);

        //7. creating buttons
        JButton button1;
        JButton button2;
        JButton button3;
        JButton button4;
        JButton button5;


        //8. construct button 1                                                              // button1 (Make Appointment)
        button1 = new JButton("Make Appointment");
        button1.setBounds(380,70,200,50);
        //mainLabel.setLocation(150, 371);
        mainLabel.add(button1);
        button1.addActionListener(e -> {
            MakeAppointment appointments = new MakeAppointment();
            appointments.setVisible(true);
        });


        //9. construct button 2                                                              // button2 (View Appointment)
        button2 = new JButton("View Apppointments");
        button2.setBounds(380,140,200,50);
        //jpanel.setLocation(50, 371);
        mainLabel.add(button2);
        button2.addActionListener(e -> {
            ViewAppointments appointmentDetails = new ViewAppointments();
            appointmentDetails.setVisible(true);

            //displayAppoinetment(appointments);
            JTextArea jta = new JTextArea();
            Font font = new Font("monospaced",Font.PLAIN,13);

            jta.setFont(font);
            jta.setText("--- Information ---\n");

            for(Appointment a:appointments)
            {
                if (a == null)
                    break;

                else {
                    jta.append(a.toString());
                }
            }
            JOptionPane.showMessageDialog(null,jta);
        });




        //10. construct button 3
        button3 = new JButton("Add Patient");                                          // button3 (Add Patient)
        button3.setBounds(380,210,200,50);
        mainLabel.add(button3);
        button3.addActionListener(e -> {
            AddPatient patientDetails = new AddPatient();
            patientDetails.setVisible(true);
           // patients.add(patientDetails.getPatient());
        });


        //11. construct button 4
        button4 = new JButton("View Patients");                                       // button4 (View Patient)
        button4.setBounds(380,280,200,50);
        mainLabel.add(button4);
        button4.addActionListener(e -> {
            ViewPatients patientDetails = new ViewPatients();
            patientDetails.setVisible(true);

            //displayPatients(patients);
            JTextArea jta = new JTextArea();
            Font font = new Font("monospaced",Font.PLAIN,13);

            jta.setFont(font);
            jta.setText("--- Information ---\n");

            for(Patient p:patients)
            {
                if (p == null)
                    break;

                else {
                    jta.append(p.toString());
                     }
            }
            JOptionPane.showMessageDialog(null,jta);
        });


        //12. construct button 5
        button5 = new JButton("Doctor Profile");
        button5.setBounds(380,400,200,50);
        mainLabel.add(button5);
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "Dr. Matt Smith \n- General Practitioner \n- 11 years experience" +
                        "\n\n\nClinic Hours\n- Sat-Sun:   9:00am - 12:00pm " +
                        "                   \n- Mon-Thus:  9:00am - 3:00pm " +
                        "                   \n- Friday:    Closed \n","Doctor Information",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cPane.add(jpanel);

    }// end constructor


    //------------------------------------------------------------------------------------------------------------------
    //13. creating action listeners
    public void actionPerformed(ActionEvent event) {

        if (event.getActionCommand() .equals ("Quit")){
            showMessage("Shutting down the system");
            System.exit(0);
        }

        else if (event.getActionCommand() .equals ("Display")){
            display();
        }
        else if (event.getActionCommand() .equals ("New File")){
            newSystem();
        }
        else if (event.getActionCommand() .equals ("Save")){
            // NEW BLOCK OF ERROR-HANDLING HERE: MUST BE INCLUDED
            try{
                save();
                showMessage("Data saved successfully");
            } // try
            catch (IOException f){
                showMessage("Not able to save the file:\n"+
                        "Check the console printout for clues to why. ");
                f.printStackTrace();
            }// catch
        }// else if

        else if (event.getActionCommand() .equals ("Open")){
            open();
            display();
        }
        else
            showMessage("I have no idea what you clicked");
        // end else
    } // end actionPerformend

    /** Quits the program when quit is clicked in menu items
     * or
     * Displays text telling what menu item is selected */


    //------------------------------------------------------------------------------------------------------------------
    //14. creating Appointment menu items
    private void createAppintmentMenu( )
    {

        JMenuItem item1;
        JMenuItem item2;
        JMenuItem item3;
        
	    // creating the menu
        appointmentMenu = new JMenu("Appointments");

        // create item 1
        item1 = new JMenuItem("Make Appointment");                                   //Make Appointments

        item1.addActionListener( this );

        appointmentMenu.add( item1 );
        item1.addActionListener(e -> {
            MakeAppointment appointments = new MakeAppointment();
            appointments.setVisible(true);
        });


        // create item 2
        item2 = new JMenuItem("View Appointments");                                   //View Appointments...
        item2.addActionListener( this );
        appointmentMenu.add( item2 );
        item2.addActionListener(e -> {
            ViewAppointments appointments = new ViewAppointments();
            appointments.setVisible(true);
        });

    } // end createAppointmentMenu


    //------------------------------------------------------------------------------------------------------------------
    //15. creating Patient Menu items
    private void createPatientMenu( )
    {
        JMenuItem item1;
        JMenuItem item2;

        patientMenu = new JMenu("Patients");


        // create item 1
        item1 = new JMenuItem("Add Patient");                                             //Add Patient - Menu item
        item1.addActionListener( this );
        patientMenu.add( item1 );
        item1.addActionListener(e -> {
            AddPatient patientDetails = new AddPatient();
            patientDetails.setVisible(true);
        });


        // create item 2
        item2 = new JMenuItem("View Patients");                                           //View Patients
        item2.addActionListener( this );
        patientMenu.add( item2 );

        item2.addActionListener(e -> {
            PatientDriver patientDetails = new PatientDriver();
            patientDetails.setVisible(true);
        });


    } // end createPatientMenu

    //------------------------------------------------------------------------------------------------------------------
    //16. creating event handler to close the window

    private class WindowEventHandler extends WindowAdapter
    {
        //private class WindowEventHandler implements WindowListener {
        public void windowClosing(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Closing the window");
            System.exit(0);
        } // end method
    }

    //------------------------------------------------------------------------------------------------------------------
    //17. creating an array list for patients
    //    creating text area to display patients
    //    displaying patients

    public void displayPatients(ArrayList<Patient> patients)
    {
        JTextArea jta = new JTextArea();
        Font font = new Font("monospaced",Font.PLAIN,13);

        jta.setFont(font);
        jta.setText("--- Information ---\n");
        //patients = new <Patient>("Spencer Hastings","Princess Street","098654368",'F');

        for(Patient p:patients) {
            if (p == null)
                break;

            else {
                jta.append(p.toString());
            }
        }

        //return jta;
        JOptionPane.showMessageDialog(null,jta);
    }


        public void displayAppointments(ArrayList<Appointment> appointments)
        {
            JTextArea jta = new JTextArea();
            Font font = new Font("monospaced",Font.PLAIN,13);

            jta.setFont(font);
            jta.setText("--- Information ---\n");

            for(Appointment a:appointments) {
                if (a == null)
                    break;

                else {
                    jta.append(a.toString());
                }
            }

            //return jta;
            JOptionPane.showMessageDialog(null,jta);
        }

    //------------------------------------------------------------------------------------------------------------------
    //17. creating JMenuFrame
    public static void main(String[] args) throws IOException
    {
        JMenuFrame frame = new JMenuFrame();
        frame.setVisible(true);
        // frame.newSystem();
    }


    //------------------------------------------------------------------------------------------------------------------
    // save method
    public void save() throws IOException {
        //	public void save(){// throws IOException {
        ObjectOutputStream os;
        os = new ObjectOutputStream(new FileOutputStream ("patients.dat"));
        os.writeObject(patients);
        os.close();
    }

    //------------------------------------------------------------------------------------------------------------------
    // open method
    public void open() {
        count = 0;
        try{
            ObjectInputStream is;
            is = new ObjectInputStream(new FileInputStream ("patients.dat"));
            patients  = (ArrayList<Patient>) is.readObject();
            is.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Open didn't work");
            e.printStackTrace();
        }

        // how many valid patient records?
        while (patients.size() != 0)
            count++;
    } // end open()


    //------------------------------------------------------------------------------------------------------------------
    // display method
    public void display(){
        JTextArea area = new JTextArea();
        if (count>0) {
            area.setText("Patient List: needs better output formatting\n\n");
            for (int i = 0; i<count; i++) // loop over existing patients, rather than array size
                area.append("Patient Id: " + i + " " +patients.get(i).toString()+"\n");
            showMessage(area);
        }
        else
            showMessage("No patients in the system");
    } // end display

    //------------------------------------------------------------------------------------------------------------------
    // creating file menu
    private void createFileMenu(){
        // create the menu
        fileMenu = new JMenu("File");
        // declare a menu item (re-usable)
        JMenuItem item;
        item = new JMenuItem("Save");
        item.addActionListener(this);
        fileMenu.add(item);
        item = new JMenuItem("Open");
        item.addActionListener(this);
        fileMenu.add(item);
        item = new JMenuItem("New File");
        item.addActionListener(this);
        fileMenu.add(item);
        // create the 'quit' option
        fileMenu.addSeparator();
        item = new JMenuItem("Quit");
        item.addActionListener(this);
        fileMenu.add(item);
    }

    //------------------------------------------------------------------------------------------------------------------
    //
    /** utility methods to make the code simpler */
    public void showMessage (String s){
        JOptionPane.showMessageDialog(null,s);
    }

    public void showMessage (JTextArea s){
        JOptionPane.showMessageDialog(null,s);
    }
}


 // end class
