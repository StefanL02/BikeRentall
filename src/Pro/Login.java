package Pro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private JTextField usernameText;
    private JPanel loginScreen;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JFrame frame;

    private String password;
    private String username;


    public Login() {

        frame = new JFrame("Login");
        frame.setPreferredSize(new Dimension(250, 250));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);


        frame.add(loginScreen);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginButton || e.getSource()==usernameText || e.getSource()==passwordText){
            username = usernameText.getText();
            password = String.valueOf(passwordText.getPassword());
             if(username.equals("admin") && (password.equals("admin"))) {


                 RentalSystem r = new RentalSystem();
                 r.setVisible(true);
                 dispose();
             }

           else{
               JOptionPane.showMessageDialog(null,"Incorrect password or username!","Error",JOptionPane.ERROR_MESSAGE);
             }
        }



    }



}



