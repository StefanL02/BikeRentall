package Pro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

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

        setIconImage(new ImageIcon(getClass().getResource("rentlogo.jpg")).getImage());
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

        final String[] bikeList = {"Road", "Mountain", "Hybrid", "Electric", "Folding", "Gravel Road", "Touring", "BMX"};
        final String[] manufacturerList = {"Giant", "Trek", "GT", "KTM", "Fuji", "Oreba"};
        String category;
        String bikeManufacturer;
        String description;
        double price;
        int j;
        boolean valid;

        category = (String) JOptionPane.showInputDialog(null, "Select Bike Type: ", "New Bike", JOptionPane.QUESTION_MESSAGE, null, bikeList, bikeList[0]);

        bikeManufacturer = (String) JOptionPane.showInputDialog(null, "Select Bike Manufacturer: ", "New Bike", JOptionPane.QUESTION_MESSAGE, null, manufacturerList, manufacturerList[0]);

        description = JOptionPane.showInputDialog("Please Enter Bike's details (* to exit) ");

        while (!description.equals("*")) {
            valid = false;

            while (!valid) {
                if (description.length() >= 1 && description.length() <= 30) {
                    if (!description.equals("")) {
                        for (j = 0; j < description.length(); j++)
                            if (description.charAt(j) == '<' || description.charAt(j) == '>' || description.charAt(j) == '?')
                                break;
                        if (j == description.length()) {
                            price = Double.parseDouble(JOptionPane.showInputDialog("Please enter the price of bike"));
                            if (price <= 10000 && price !=0){


                                bike = new Bike(category, bikeManufacturer, description, price);
                               bikes.add(bike);

                                JOptionPane.showMessageDialog(null, "Bike: " + bike + "\n is added to the list", "Succesful", JOptionPane.INFORMATION_MESSAGE);
                                valid = true;
                                return;


                            }


                        } else
                            description = JOptionPane.showInputDialog("Invalid! Name cannot contain < > or ? characters ");
                    } else
                        description = JOptionPane.showInputDialog("Invalid! Name cannot be empty");

                } else
                    description = JOptionPane.showInputDialog("Invalid! Name must have between 1 and 30 characters inclusive");

            }



        }
    }

    public void deleteBike(){

        JComboBox <String> bikeList = new JComboBox<>();

        for(Bike b: bikes){
            bikeList.addItem(b.getBikeManufacturer());

        }

        JOptionPane.showMessageDialog(null,"Select Bike to be removed","Remove bike",JOptionPane.INFORMATION_MESSAGE );

        JOptionPane.showMessageDialog(null,bikeList,"Remove bike",JOptionPane.INFORMATION_MESSAGE);

        int selected = bikeList.getSelectedIndex();

        bikes.remove(selected);
        JOptionPane.showMessageDialog(null,"Bike removed","Succesfully removed",JOptionPane.INFORMATION_MESSAGE);

    }


    public void listBike(){
        JComboBox <String> bikeCombo = new JComboBox<>();
        JTextArea output = new JTextArea();

        output.setText("\nDetails:\n ");

        if(bikes.size() <1){
            JOptionPane.showMessageDialog(null,"You need to add bikes to be able to see them","Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            Iterator<Bike> iterator = bikes.iterator();

            while(iterator.hasNext()){
                bikeCombo.addItem(iterator.next().getBikeManufacturer());
            }

            JOptionPane.showMessageDialog(null,bikeCombo,"Select Bike for details",JOptionPane.PLAIN_MESSAGE);

            int selected = bikeCombo.getSelectedIndex();
            output.append(bikes.get(selected).toString());
            JOptionPane.showMessageDialog(null,output,"Bike details",JOptionPane.PLAIN_MESSAGE);

        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String menuOption = e.getActionCommand();


        // if(menuOption.equals ("Add Bike") || e.getSource().equals()
        if(menuOption.equals( "Add Bike")) {
            addBike();
        }

       else if (menuOption.equals("Remove Bike")){
         deleteBike();
        }

        else if (menuOption.equals("List Bikes")){
          listBike();
        }


}
    public void saveFiles() throws IOException {

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("bikes.dat"));
        os.writeObject(bikes);
        os.close();


    }



}


