package Pro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class RentalSystem extends JFrame implements ActionListener {

    private JMenu staffMenu;
    private JMenu bikeMenu;
    private JMenu salesMenu;
    private JPanel welcomePanel;
    private JLabel welcomeLabel;
    private JLabel imageLabel;

    ArrayList<Bike> bikes = new ArrayList<>();
    private Bike bike;

    ArrayList<Staff> staffs = new ArrayList<>();
    private Staff staff;

    ArrayList<Sale> sales = new ArrayList<>();
    private Sale sale;



    public RentalSystem() {

        setTitle("Bike Rental");
        setSize(480, 550);
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

        try {
            imageLabel = new JLabel();
            imageLabel.setIcon(new ImageIcon(getClass().getResource("background.png")));

            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            welcomePanel.add(imageLabel);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Invalid Image File in Main Screen");
        }

        welcomePanel.add(Box.createVerticalStrut(30));


        add(welcomePanel);
        setVisible(true);
        openFiles();
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

    private void createBikeMenu() {

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

    private void createSalesMenu() {

        JMenuItem item;

        salesMenu = new JMenu("Sales");
        salesMenu.setMnemonic(KeyEvent.VK_D);

        item = new JMenuItem("Add Sale");
        item.addActionListener(this);
        salesMenu.add(item);


        item = new JMenuItem("View Sale");
        item.addActionListener(this);
        salesMenu.add(item);

    }

    public static void main(String[] args) {
        new RentalSystem();
    }

    private void createMessageOptions() {

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    try {
                        saveFiles();
                        JOptionPane.showMessageDialog(null, "Data saved successfully", "Saved", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "Not able to save the file");
                        e1.printStackTrace();
                    }

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
                            if (price <= 10000 && price != 0) {


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

    public void deleteBike() {

        JComboBox<String> bikeList = new JComboBox<>();

        for (Bike b : bikes) {
            bikeList.addItem(b.getBikeManufacturer());

        }

        JOptionPane.showMessageDialog(null, "Select Bike to be removed", "Remove bike", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, bikeList, "Remove bike", JOptionPane.INFORMATION_MESSAGE);

        int selected = bikeList.getSelectedIndex();

        bikes.remove(selected);
        JOptionPane.showMessageDialog(null, "Bike removed", "Succesfully removed", JOptionPane.INFORMATION_MESSAGE);

    }


    public void listBike() {
        JComboBox<String> bikeCombo = new JComboBox<>();
        JTextArea output = new JTextArea();

        output.setText("\nDetails:\n ");

        if (bikes.size() < 1) {
            JOptionPane.showMessageDialog(null, "You need to add bikes to be able to see them", "Error Detected", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Iterator<Bike> iterator = bikes.iterator();

            while (iterator.hasNext()) {
                bikeCombo.addItem(iterator.next().getBikeManufacturer());
            }

            JOptionPane.showMessageDialog(null, bikeCombo, "Select Bike for details", JOptionPane.PLAIN_MESSAGE);

            int selected = bikeCombo.getSelectedIndex();
            output.append(bikes.get(selected).toString());
            JOptionPane.showMessageDialog(null, output, "Bike details", JOptionPane.PLAIN_MESSAGE);

        }
    }

    public void addStaff() {
        String PPS;
        String staffName;
        String staffSurname;
        String phone;
        String gender;
        String jobType;
        String[] genderList = {"Male", "Female", "Transgender", "Gender Neutral", "Prefer Not To Say"};
        String[] jobTypeList = {"Full-Time", "Part-Time", "Summer-Associate", "Christmas-Associate"};

        boolean valid;
        int i;

        PPS = JOptionPane.showInputDialog("Please enter staff PPS Number");
        valid = false;
        while (!valid) {
            if (PPS.length() == 9) {
                for (i = 0; i < 7 && Character.isDigit(PPS.charAt(i)); i++)

                    if ((PPS.length() == 9 && Character.isUpperCase(PPS.charAt(7)) &&
                            Character.isUpperCase(PPS.charAt(8)))) {
                        staffName = JOptionPane.showInputDialog("Please enter name:");
                        for (i = 0; i < staffName.length() && (Character.isDigit(staffName.charAt(i))) && (!Character.isLetter(staffName.charAt(i))); i++)
                            ;
                        if (i < staffName.length()) {
                            staffSurname = JOptionPane.showInputDialog("Please enter surname");
                            for (i = 0; i < staffSurname.length() && (Character.isDigit(staffSurname.charAt(i))) && (!Character.isLetter(staffSurname.charAt(i))); i++)
                                ;
                            if (i < staffSurname.length()) {
                                phone = JOptionPane.showInputDialog("Please enter phone number");
                                for (i = 0; i < phone.length() && (!Character.isDigit(phone.charAt(i))) && (Character.isLetter(phone.charAt(i))); i++)
                                    ;
                                if (i < phone.length()) {

                                    gender = (String) JOptionPane.showInputDialog(null, "Choose gender from followings: ", "Gender", JOptionPane.QUESTION_MESSAGE, null, genderList, genderList[0]);
                                    jobType = (String) JOptionPane.showInputDialog(null, "Choose job type from followings: ", "Job Type", JOptionPane.QUESTION_MESSAGE, null, jobTypeList, jobTypeList[0]);

                                    staff = new Staff(PPS, staffName, staffSurname, phone, gender, jobType);
                                    staffs.add(staff);


                                    JOptionPane.showMessageDialog(null, "Staff member" + staff + "\n is added to the list", "Succesful", JOptionPane.INFORMATION_MESSAGE);
                                    valid = true;
                                    return;

                                } else phone = JOptionPane.showInputDialog("Phone number must contain only numbers!");


                            } else
                                staffSurname = JOptionPane.showInputDialog("Invalid Surname! Surname must contain only letters");


                        } else staffName = JOptionPane.showInputDialog("Invalid Name! Name must contain only letters");
                        continue;


                    } else PPS = JOptionPane.showInputDialog("Invalid PPS Number. Please Try again");

            } else PPS = JOptionPane.showInputDialog("Invalid!Please enter staff PPS Number");
        }


    }


    public void removeStaff() {

        JComboBox<String> staffList = new JComboBox<>();

        for (Staff s : staffs) {
            staffList.addItem(s.getStaffSurname());

        }

        JOptionPane.showMessageDialog(null, "Select Staff to be removed", "Remove Staff", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, staffList, "Remove Staff", JOptionPane.INFORMATION_MESSAGE);

        int selected = staffList.getSelectedIndex();

        staffs.remove(selected);
        JOptionPane.showMessageDialog(null, "Staff Removed", "Successfully removed", JOptionPane.INFORMATION_MESSAGE);


    }

    public void listStaff() {

        JComboBox<String> staffCombo = new JComboBox<>();
        JTextArea output = new JTextArea();

        output.setText("\nDetails:\n ");

        if (staffs.size() < 1) {
            JOptionPane.showMessageDialog(null, "No staff available, add new staff to list them", "Error Detected", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Iterator<Staff> iterator = staffs.iterator();

            while (iterator.hasNext()) {
                staffCombo.addItem(iterator.next().getStaffSurname());
            }

            JOptionPane.showMessageDialog(null, staffCombo, "Select Bike for details", JOptionPane.PLAIN_MESSAGE);

            int selected = staffCombo.getSelectedIndex();
            output.append(staffs.get(selected).toString());
            JOptionPane.showMessageDialog(null, output, "Bike details", JOptionPane.PLAIN_MESSAGE);


        }
    }

    public void addSale() {
        Date currentDate = new Date();
        double price;
        String priceAsString;
        boolean valid;

        valid = false;

        while (!valid) {

            priceAsString = JOptionPane.showInputDialog("Enter new sale on today's date: " + currentDate + " in EUR");

            price = Double.parseDouble(priceAsString);
            sale = new Sale(price);

            JOptionPane.showMessageDialog(null, "New sale on: " + currentDate + " is " + price + " EUR");
            sales.add(sale);
            valid = true;


        }


    }

    public void viewSale() {

        double totalSales = 0;
        JTextArea output = new JTextArea();

        if (sales.size() < 1) {
            JOptionPane.showMessageDialog(null, "You made no sales today", "Error encountered", JOptionPane.ERROR_MESSAGE);
        } else {
            Iterator<Sale> iterator = sales.iterator();
            while (iterator.hasNext()) {
                this.sale = iterator.next();
                totalSales += this.sale.getPrice();

            }
            output.append("Today sales: " + (Double.valueOf(totalSales)));
        }

        JOptionPane.showMessageDialog(null, output, "Sales", JOptionPane.INFORMATION_MESSAGE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String menuOption = e.getActionCommand();


        // if(menuOption.equals ("Add Bike") || e.getSource().equals()
        if (menuOption.equals("Add Bike")) {
            addBike();
        } else if (menuOption.equals("Remove Bike")) {
            deleteBike();
        } else if (menuOption.equals("List Bikes")) {
            listBike();
        } else if (menuOption.equals("Add Staff")) {
            addStaff();
        } else if (menuOption.equals("Remove Staff")) {
            removeStaff();
        } else if (menuOption.equals("List Staff")) {
            listStaff();
        } else if (menuOption.equals("Add Sale")) {
            addSale();
        } else if (menuOption.equals("View Sale")) {
            viewSale();
        }

    }


    public void saveFiles() throws IOException {

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("bikes.dat"));
        os.writeObject(bikes);
        os.close();

        ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("staffs.dat"));
        oss.writeObject(staffs);
        oss.close();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sales.dat"));
        oos.writeObject(sales);
        oos.close();

    }


    public void openFiles() {
        try {


            File fileBikes = new File("bikes.dat");
            File fileStaffs = new File("staffs.dat");
            File fileSales = new File("sales.dat");

            if (fileBikes.exists()) {

                ObjectInputStream os = new ObjectInputStream(new FileInputStream(fileBikes));

                bikes = (ArrayList<Bike>) os.readObject();
                os.close();

            } else {
                fileBikes.createNewFile();
                JOptionPane.showMessageDialog(null, "File just created!!", "Created " + fileBikes.getName() + " file", JOptionPane.INFORMATION_MESSAGE);
            }

            if (fileStaffs.exists()) {

                ObjectInputStream oss = new ObjectInputStream(new FileInputStream(fileStaffs));

                staffs = (ArrayList<Staff>) oss.readObject();
                oss.close();

            } else {
                fileBikes.createNewFile();
                JOptionPane.showMessageDialog(null, "File just created!!", "Created " + fileStaffs.getName() + " file", JOptionPane.INFORMATION_MESSAGE);
            }


            if (fileSales.exists()) {

                ObjectInputStream oos = new ObjectInputStream(new FileInputStream(fileSales));

                sales = (ArrayList<Sale>) oos.readObject();
                oos.close();

            } else {
                fileBikes.createNewFile();
                JOptionPane.showMessageDialog(null, "File just created!!", "Created " + fileSales.getName() + " file", JOptionPane.INFORMATION_MESSAGE);
            }




        } //these individual catch clauses added by JB, replacing a single "Exception" catch clause
        catch (ClassNotFoundException cce) {
            JOptionPane.showMessageDialog(null, "Class of object deserialised not a match for anything used in this application", "Error", JOptionPane.ERROR_MESSAGE);
            cce.printStackTrace();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Problem reading from the file", "Error", JOptionPane.ERROR_MESSAGE);
            ioe.printStackTrace();
        }
    }
}





