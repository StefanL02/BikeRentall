package Pro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame  {
    private JTextField usernameText;
    private JPanel panel1;
    private JPasswordField passwordText;
    private JButton loginButton;

    private String password;
    private String username;



    public Login() {

        setTitle("Login");
        setPreferredSize(new Dimension(250, 250));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setVisible(true);
        pack();


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (e.getSource() == loginButton || e.getSource() == usernameText || e.getSource() == passwordText) {
                    username = usernameText.getText();
                    password = String.valueOf(passwordText.getPassword());
                    if (username.equals("admin") && (password.equals("admin"))) {


                        new RentalSystem();
                        setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect password or username!", "Error", JOptionPane.ERROR_MESSAGE);
                    }


                }
            }
    });




}

    public static void main(String[] args) {
        Login gui = new Login();
    }
}


