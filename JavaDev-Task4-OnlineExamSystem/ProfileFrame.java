import javax.swing.*;

public class ProfileFrame extends JFrame {

    JLabel title;
    JLabel nameLabel;
    JLabel passLabel;

    JTextField displayName;
    JPasswordField newPassword;

    JButton saveButton;
    JButton startButton;

    public ProfileFrame() {

        setTitle("Profile Update");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        title = new JLabel("PROFILE UPDATE");
        title.setBounds(170,20,200,30);
        add(title);

        nameLabel = new JLabel("Display Name");
        nameLabel.setBounds(60,90,120,30);
        add(nameLabel);

        displayName = new JTextField();
        displayName.setBounds(180,90,200,30);
        add(displayName);

        passLabel = new JLabel("New Password");
        passLabel.setBounds(60,150,120,30);
        add(passLabel);

        newPassword = new JPasswordField();
        newPassword.setBounds(180,150,200,30);
        add(newPassword);

        saveButton = new JButton("Save");
        saveButton.setBounds(120,250,100,35);
        add(saveButton);

        startButton = new JButton("Start Exam");
        startButton.setBounds(250,250,120,35);
        add(startButton);

        startButton.addActionListener(e -> {
    new ExamFrame();
    dispose();
});

        setVisible(true);
    }
}
