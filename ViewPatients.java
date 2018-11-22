import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Dimension;

public class ViewPatients extends JFrame {
    public JButton button1 = new JButton("Search");


    static ArrayList<Patient> patients;
    //protected ArrayList<Patient> listPatient = new JList<>();
    //public patients = new ArrayList<Patient>();
    //protected CustomListModel<Patient> listModel;
    //protected java.util.List<Patient> patients = new ArrayList<>();
    //

    public ViewPatients() {
        Container cPane;

        //set the frame properties
        setTitle("View Patients");
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


        //1
        //JLabel jLabelName = new JLabel("Enter Name: ");
        JTextField jTAId = new JTextField();
        jPanel1.setLayout(new GridLayout(1, 4));
        //jPanel1.add(jLabelName);
        jPanel1.add(jTAId);

        cPane.add(jPanel1);

 /*       JButton button1;

        // construct two buttons
        button1 = new JButton("Search");
        button1.setBounds(300, 600, 80, 50);
        cPane.add(button1);

        //Cal.main(); */

        initComponents();
    }

    protected void initComponents() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));

/*        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addPerson();
            }
        });

        buttonSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortPersons();
            }
        }); */

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchPersons();
            }
        });

        //panelButton.add(buttonAdd);
        panelButton.add(button1);
        // panelButton.add(buttonSort);

        add(panelButton);

        //listPatient.setPreferredSize(new Dimension(400, 360));

        //listModel = new CustomListModel<Patient>(patients);
        //listPatient.setModel(listModel);

        //listModel.addElement(new Patient("John Doe"));

        //add(listPatient);
    }

/*    private void addPerson() {
        String personName = JOptionPane.showInputDialog(this, "Enter person name");
        if (personName != null) {
            listModel.addElement(new Person(personName));
        }
    }

    private void sortPersons() {
        Collections.sort(persons);
        listModel.fireDataChanged();
    } */

    private void searchPersons() {
        String patientName = JOptionPane.showInputDialog(this, "Enter person name to search for:");

        if (patientName == null) {
            return;
        }

        Collections.sort(patients);

        int foundIndex = Collections.binarySearch(patients, new Patient());

        //if (foundIndex >= 0) {
            //listPatient.setSelectedIndex(foundIndex);
        //} else {
            //JOptionPane.showMessageDialog(this, "Could not find the person " + personName);
        }
    }


