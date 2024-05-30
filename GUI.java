import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {

    JLabel label;
    JTextField textField;
    JFrame frame;
    JPanel panel;
    JButton buttonEquals;

    double firstNumber, secondNumber;
    String operator;

    public GUI() {

        frame = new JFrame();
        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton buttonMult = new JButton("x");
        JButton buttonDiv = new JButton("/");
        JButton buttonAdd = new JButton("+");
        JButton buttonSub = new JButton("-");
        buttonEquals = new JButton("=");

        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonMult.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonSub.addActionListener(this);
        buttonEquals.addActionListener(this);

        label = new JLabel("Enter your calculation");
        textField = new JTextField();
        textField.setEditable(false);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 10, 30));
        panel.setLayout(new GridLayout(0, 4));
        panel.add(label);
        panel.add(textField);
        panel.add(button0);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonMult);
        panel.add(buttonDiv);
        panel.add(buttonSub);
        panel.add(buttonAdd);
        panel.add(buttonEquals);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (Character.isDigit(command.charAt(0))) {
            textField.setText(textField.getText() + command);
        } else if (command.equals("=")) {
            secondNumber = Double.parseDouble(textField.getText());
            calculateResult();
        } else {
            operator = command;
            firstNumber = Double.parseDouble(textField.getText());
            textField.setText("");
        }
    }

    private void calculateResult() {
        double result = 0;
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    textField.setText("Error: Division by zero");
                    return;
                }
                break;
        }
        textField.setText(String.valueOf(result));
    }
}


    
