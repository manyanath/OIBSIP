import javax.swing.*;
import java.awt.event.*;

public class ResultFrame extends JFrame {

    JLabel scoreLabel;
    JLabel timeLabel;
    JLabel resultLabel;

    JButton logoutButton;

    public ResultFrame(int score, int total, int secondsTaken) {

        setTitle("Exam Result");
        setSize(500,400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("EXAM RESULT");
        heading.setBounds(180,30,200,30);
        add(heading);

        scoreLabel = new JLabel("Score : " + score + " / " + total);
        scoreLabel.setBounds(150,90,250,30);
        add(scoreLabel);
        JLabel correctLabel = new JLabel("Correct Answers : " + score);
        correctLabel.setBounds(150, 120, 250, 30);
        add(correctLabel);

        JLabel wrongLabel = new JLabel("Wrong Answers : " + (total - score));
        wrongLabel.setBounds(150, 150, 250, 30);
        add(wrongLabel);

        int min = secondsTaken / 60;
        int sec = secondsTaken % 60;

        timeLabel = new JLabel(String.format("Time Taken : %02d:%02d", min, sec));
        timeLabel.setBounds(150,190,250,30);
        add(timeLabel);

        if(score >= (total / 2)){
            resultLabel = new JLabel("Result : PASS");
        }else{
            resultLabel = new JLabel("Result : FAIL");
        }

        resultLabel.setBounds(150,240,250,30);
        add(resultLabel);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(180,300,120,35);
        add(logoutButton);

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new LoginFrame();
                dispose();

            }
        });

        setVisible(true);
    }

}
