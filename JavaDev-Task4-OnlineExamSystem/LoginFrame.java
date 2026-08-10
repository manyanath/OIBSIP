import javax.swing.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

    JLabel title;
    JLabel userLabel;
    JLabel passLabel;

    JTextField username;
    JPasswordField password;

    JButton loginButton;

    String correctUsername = "admin";
    String correctPassword = "1234";

    public LoginFrame() {

        setTitle("Online Examination System");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        title = new JLabel("ONLINE EXAMINATION SYSTEM");
        title.setBounds(120, 20, 300, 30);
        add(title);

        userLabel = new JLabel("Username");
        userLabel.setBounds(70, 90, 100, 30);
        add(userLabel);

        username = new JTextField();
        username.setBounds(170, 90, 200, 30);
        add(username);

        passLabel = new JLabel("Password");
        passLabel.setBounds(70, 150, 100, 30);
        add(passLabel);

        password = new JPasswordField();
        password.setBounds(170, 150, 200, 30);
        add(password);

        loginButton = new JButton("Login");
        loginButton.setBounds(180, 230, 100, 35);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String user = username.getText();
                String pass = new String(password.getPassword());

                if (user.equals(correctUsername) && pass.equals(correctPassword)) {

                    JOptionPane.showMessageDialog(null, "Login Successful");

dispose();

new ProfileFrame();     
                } else {

                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");

                }
            }
        });

        setVisible(true);
    }
}
