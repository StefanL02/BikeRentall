package Try;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BikeRental extends JFrame implements ActionListener {

   private JMenuBar menuBar;
   private JMenu aboutMenu;
   private JMenu homeMenu;
   private JMenu blogMenu;
   private JMenu contactMenu;

   private JMenuItem visionItem;
   private JMenuItem missionItem;
   private JMenuItem podcastItem;
   private JMenuItem articleItem;
   private JMenuItem messageItem;
   private JMenuItem donateItem;
    private JTextField usernameText;
    private JPanel loginScreen;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JFrame frame;




    BikeRental (){

        frame = new JFrame("Login");
        frame.setPreferredSize(new Dimension(250, 250));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);


        frame.add(loginScreen);

        frame.pack();
        frame.setVisible(true);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250,350);
        this.setTitle("Bike Rental");
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        JMenuBar menuBar = new JMenuBar();

         homeMenu = new JMenu("Home");
         aboutMenu = new JMenu("About");
         blogMenu = new JMenu("Blog");
         contactMenu = new JMenu("Contact");

        visionItem = new JMenuItem("Vision");
        missionItem = new JMenuItem("Mission");
        podcastItem = new JMenuItem("Podcast");
        articleItem = new JMenuItem("Artice");
        messageItem = new JMenuItem("Message");
        donateItem = new JMenuItem("Donate");


        setJMenuBar(menuBar);
        menuBar.add(homeMenu);
        menuBar.add(aboutMenu);
        menuBar.add(blogMenu);
        menuBar.add(contactMenu);

        aboutMenu.add(visionItem);
        aboutMenu.add(missionItem);
        blogMenu.add(podcastItem);
        blogMenu.add(articleItem);
        contactMenu.add(messageItem);
        contactMenu.add(donateItem);

        homeMenu.addActionListener(this);
        aboutMenu.addActionListener(this);
        blogMenu.addActionListener(this);
        contactMenu.addActionListener(this);

        visionItem.addActionListener(this);
        missionItem.addActionListener(this);
        podcastItem.addActionListener(this);
        articleItem.addActionListener(this);
        messageItem.addActionListener(this);
        donateItem.addActionListener(this);

        this.setVisible(true);

    }


    public static void main(String[] args) {
        new BikeRental();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        }

    }

