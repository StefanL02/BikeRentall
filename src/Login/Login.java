package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField usernameText;
    private JPanel loginScreen;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JFrame frame;


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

    public static void main(String[] args) {
        new Login();
    }
}



