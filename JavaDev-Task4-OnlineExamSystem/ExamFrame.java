import javax.swing.*;
import java.awt.event.*;

public class ExamFrame extends JFrame {

    JLabel questionLabel, timerLabel;

    JRadioButton op1, op2, op3, op4;
    ButtonGroup group;

    JButton nextButton, previousButton, submitButton;

    int current = 0;
    int score = 0;

    int[] answers = {0,1,1,0,2};

    int timeLeft = 1800;

    Timer timer;

    String[] questions = {
            "1. Java is a?",
            "2. Which keyword is used to inherit a class?",
            "3. Which package is used for Swing?",
            "4. JVM stands for?",
            "5. Which method starts a Java program?"
    };

    String[][] options = {
            {"Programming Language","Database","Operating System","Browser"},
            {"this","extends","implements","super"},
            {"java.awt","javax.swing","java.io","java.net"},
            {"Java Virtual Machine","Java Variable Method","Joint Virtual Machine","None"},
            {"run()","execute()","main()","start()"}
    };

    public ExamFrame() {

        setTitle("Online Examination");
        setSize(700,500);
        setLayout(null);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                int choice = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to quit?",
                        "Exit",
                        JOptionPane.YES_NO_OPTION);

                if(choice==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        timerLabel = new JLabel();
        timerLabel.setBounds(520,20,150,30);
        add(timerLabel);

        questionLabel = new JLabel();
        questionLabel.setBounds(50,70,600,30);
        add(questionLabel);

        op1 = new JRadioButton();
        op2 = new JRadioButton();
        op3 = new JRadioButton();
        op4 = new JRadioButton();

        op1.setBounds(70,120,500,30);
        op2.setBounds(70,160,500,30);
        op3.setBounds(70,200,500,30);
        op4.setBounds(70,240,500,30);

        add(op1);
        add(op2);
        add(op3);
        add(op4);

        group = new ButtonGroup();

        group.add(op1);
        group.add(op2);
        group.add(op3);
        group.add(op4);

        previousButton = new JButton("Previous");
        previousButton.setBounds(120,350,100,35);
        add(previousButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(280,350,100,35);
        add(nextButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(440,350,100,35);
        add(submitButton);

        loadQuestion();

        previousButton.addActionListener(e->{

            if(current>0){

                current--;
                loadQuestion();
            }

        });

        nextButton.addActionListener(e->{

            checkAnswer();

            if(current<questions.length-1){

                current++;
                loadQuestion();
            }

        });

        submitButton.addActionListener(e->{

            int ch = JOptionPane.showConfirmDialog(
                    null,
                    "Submit Exam?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION);

            if(ch==JOptionPane.YES_OPTION){

                checkAnswer();

                timer.stop();

                new ResultFrame(score,questions.length,1800-timeLeft);

                dispose();
            }

        });

        timer = new Timer(1000,new ActionListener(){

            public void actionPerformed(ActionEvent e){

                timeLeft--;

                int min = timeLeft/60;

                int sec = timeLeft%60;

                timerLabel.setText(String.format("Time Left : %02d:%02d",min,sec));

                if(timeLeft==0){

                    timer.stop();

                    checkAnswer();

                    JOptionPane.showMessageDialog(null,"Time Up!");

                    new ResultFrame(score,questions.length,1800);

                    dispose();

                }

            }

        });

        timer.start();

        setVisible(true);

    }

    void loadQuestion(){

        questionLabel.setText(questions[current]);

        op1.setText(options[current][0]);
        op2.setText(options[current][1]);
        op3.setText(options[current][2]);
        op4.setText(options[current][3]);

        group.clearSelection();

    }

    void checkAnswer(){

        int selected=-1;

        if(op1.isSelected()) selected=0;
        if(op2.isSelected()) selected=1;
        if(op3.isSelected()) selected=2;
        if(op4.isSelected()) selected=3;

        if(selected==answers[current]){

            score++;

        }

    }

}
