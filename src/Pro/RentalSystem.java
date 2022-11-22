package Pro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RentalSystem extends JFrame implements ActionListener {

  private   JMenu staffMenu;
   private JMenu bikeMenu;
   private JMenu salesMenu;
   private JPanel welcomePanel;
   private JLabel welcomeLabel;
   private JLabel imageLabel;

   ArrayList<Bike> bikes = new ArrayList<>();
   private Bike bike;






    public  RentalSystem(){

        setTitle("Bike Rental");
        setSize(380,350);
        setResizable(false);
        setLocationRelativeTo(null);



        Container bpane = getContentPane();
        bpane.setBackground(new Color(167, 92, 102));
        setLayout(new FlowLayout());

        createMessageOptions();
        createStaffMenu();
        createBikeMenu();
        createSalesMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.GRAY);

        menuBar.add(staffMenu);
        menuBar.add(bikeMenu);
        menuBar.add(salesMenu);

        setIconImage(new ImageIcon(getClass().getResource("rentlogo.jpg")).getImage()); // Image source data:image/png;base64,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

        welcomePanel = new JPanel();
        welcomePanel.add(Box.createVerticalStrut(90));
        welcomePanel.setLayout((new BoxLayout(welcomePanel, BoxLayout.Y_AXIS)));

        welcomeLabel = new JLabel("Rent a bike");
        welcomeLabel.setFont(new Font("serif", 2, 24));
        welcomeLabel.setForeground(Color.BLUE);

        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(Box.createVerticalStrut(80));
        welcomePanel.add(Box.createHorizontalStrut(200));

        try{
            imageLabel = new JLabel();
            imageLabel.setIcon(new ImageIcon(getClass().getResource("background.jpg")));

            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            welcomePanel.add(imageLabel);

        }

        catch(Exception ex) {

            JOptionPane.showMessageDialog(null,"Invalid Image File in Main Screen");
        }

        welcomePanel.add(Box.createVerticalStrut(30));


        add(welcomePanel);
        setVisible(true);
    }



    private void createStaffMenu() {

        JMenuItem item;

        staffMenu = new JMenu("Staff");
        staffMenu.setMnemonic(KeyEvent.VK_S);

        item = new JMenuItem("Add Staff");
        item.addActionListener(this);
        staffMenu.add(item);

        item = new JMenuItem("Remove Staff");
        item.addActionListener(this);
        staffMenu.add(item);

        item = new JMenuItem("List Staff");
        item.addActionListener(this);
        staffMenu.add(item);


    }

    private void createBikeMenu(){

        JMenuItem item;

        bikeMenu = new JMenu("Bicycle");
        bikeMenu.setMnemonic(KeyEvent.VK_B);

        item = new JMenuItem("Add Bike");
        item.addActionListener(this);
        bikeMenu.add(item);

        item = new JMenuItem("Remove Bike");
        item.addActionListener(this);
        bikeMenu.add(item);

        item = new JMenuItem("List Bikes");
        item.addActionListener(this);
        bikeMenu.add(item);


    }

    private void createSalesMenu(){

        JMenuItem item;

        salesMenu = new JMenu("Sales");
        salesMenu.setMnemonic(KeyEvent.VK_D);

        item = new JMenuItem("Register Customer");
        item.addActionListener(this);
        salesMenu.add(item);

        item = new JMenuItem("Delete Customer");
        item.addActionListener(this);
        salesMenu.add(item);

        item = new JMenuItem("List Customers");
        item.addActionListener(this);
        salesMenu.add(item);

    }

    public static void main(String[] args) {
         new RentalSystem();
    }

    private void createMessageOptions() {

        addWindowListener(new WindowAdapter()  {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confirmation",JOptionPane.YES_NO_OPTION);

                if(option == JOptionPane.YES_OPTION) {
                  JOptionPane.showMessageDialog(null,"Good Bye, thank you for using our system!","Message",JOptionPane.INFORMATION_MESSAGE);

                    System.exit(0);
                }
            }

            public void windowOpened(WindowEvent e){

                JOptionPane.showMessageDialog(null,"Welcome to our shop", "Message",JOptionPane.INFORMATION_MESSAGE);
            }
        });


    }

    public void addBike() {

        final String[] bikeList = {"Road", "Mountain", "Hybrid", "Electric", "Folding", "Gravel Road", "Touring","BMX"};
        final String[] manufacturerList = {"Giant","Trek","GT","KTM","Fuji","Oreba"};
        String category;
        String bikeManufacturer;
        String description;
        double price;

        category = (String) JOptionPane.showInputDialog(null, "Select Bike Type: ", "New Bike", JOptionPane.QUESTION_MESSAGE, null, bikeList, bikeList[0]);

        bikeManufacturer = (String) JOptionPane.showInputDialog(null,"Select Bike Manufacturer: ", "New Bike", JOptionPane.QUESTION_MESSAGE,null, manufacturerList,manufacturerList[0]);
        description = JOptionPane.showInputDialog("Please Enter Bike's details");
        if ( description.equals(""))
            description = JOptionPane.showInputDialog("Error. Please Enter Bike's details");

        price = Double.parseDouble(JOptionPane.showInputDialog("Please enter the price of bike"));
        if (price > 10000)
            price = Double.parseDouble(JOptionPane.showInputDialog("Error. Please enter the price of bike"));


        bike = new Bike(category,bikeManufacturer,description,price);
        bikes.add(bike);

        JOptionPane.showMessageDialog(null,"Bike: " + bike + "\n is added to the list","Succesful",JOptionPane.INFORMATION_MESSAGE);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String menuOption = e.getActionCommand();


        // if(menuOption.equals ("Add Bike") || e.getSource().equals()
        if(menuOption.equals( "Add Bike")){
        addBike();

    }
}}


