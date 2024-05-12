import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[5];
    JButton[] Arithmetic_Operations_Buttons = new JButton[4];
    JButton[] AdditionalFunctionButtons = new JButton[4];
    JButton addButton, subButton, mulButton, divButton;
    JButton decimalButton, equalButton, deleteButton, clrButton, negativeButton, sqrtButton, logarithmButton, factorialButton, powButton;
    JPanel panel;
    Font myFont = new Font("Arial", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(500, 700);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 500, 50);
        textfield.setFont(myFont);
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.white);
        textfield.setBorder(null);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negativeButton = new JButton("(-)");
        sqrtButton = new JButton("√");
        logarithmButton = new JButton("Log");
        factorialButton = new JButton("!");
        powButton = new JButton("Pow");

        Arithmetic_Operations_Buttons[0] = addButton;
        Arithmetic_Operations_Buttons[1] = subButton;
        Arithmetic_Operations_Buttons[2] = mulButton;
        Arithmetic_Operations_Buttons[3] = divButton;

        functionButtons[0] = decimalButton;
        functionButtons[1] = equalButton;
        functionButtons[2] = deleteButton;
        functionButtons[3] = clrButton;
        functionButtons[4] = negativeButton;

        AdditionalFunctionButtons[0] = sqrtButton;
        AdditionalFunctionButtons[1] = logarithmButton;
        AdditionalFunctionButtons[2] = factorialButton;
        AdditionalFunctionButtons[3] = powButton;

        for (int i = 0; i < 4; i++) {
            Arithmetic_Operations_Buttons[i].addActionListener(this);
            Arithmetic_Operations_Buttons[i].setBackground(new Color(145, 72, 22));
            Arithmetic_Operations_Buttons[i].setForeground(Color.WHITE);
            Arithmetic_Operations_Buttons[i].setFont(myFont);
            Arithmetic_Operations_Buttons[i].setBorder(BorderFactory.createLineBorder(new Color(115, 57, 18)));
            Arithmetic_Operations_Buttons[i].setFocusable(false);
        }

        for (int i = 0; i < 5; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setBackground(new Color(204, 102, 31));
            functionButtons[i].setForeground(Color.WHITE);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setBorder(BorderFactory.createLineBorder(new Color(115, 57, 18)));
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 4; i++) {
            AdditionalFunctionButtons[i].addActionListener(this);
            AdditionalFunctionButtons[i].setBackground(Color.GRAY);
            AdditionalFunctionButtons[i].setForeground(Color.WHITE);
            AdditionalFunctionButtons[i].setFont(myFont);
            AdditionalFunctionButtons[i].setBorder(BorderFactory.createLineBorder(new Color(82, 82, 82)));
            AdditionalFunctionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(new Color(64, 64, 64));
            numberButtons[i].setForeground(Color.white);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            numberButtons[i].setFocusable(false);

        }

        negativeButton.setBounds(50, 550, 100, 50);
        deleteButton.setBounds(156, 550, 100, 50);
        clrButton.setBounds(262, 550, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 400, 400);
        panel.setLayout(new GridLayout(5, 5, 6, 6));
        panel.setBackground(Color.black);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        panel.add(sqrtButton);
        panel.add(powButton);
        panel.add(factorialButton);
        panel.add(logarithmButton);

        frame.add(panel);

        frame.add(negativeButton);
        frame.add(deleteButton);
        frame.add(clrButton);
        frame.add(textfield);

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '×';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '÷';
            textfield.setText("");
        }
        if (e.getSource() == powButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '^';
            textfield.setText("");
        }
        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(textfield.getText());
            textfield.setText(String.valueOf(Math.sqrt(num1)));
        }
        if (e.getSource() == logarithmButton) {
            num1 = Double.parseDouble(textfield.getText());
            textfield.setText(String.valueOf(Math.log10(num1)));
        }
        if (e.getSource() == factorialButton) {
            num1 = Double.parseDouble(textfield.getText());
            textfield.setText(String.valueOf(fact((int) num1)));
        }
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '×':
                    result = num1 * num2;
                    break;
                case '÷':
                    result = num1 / num2;
                    break;
                case '^':
                    result = Math.pow(num1, num2);
                    break;

            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        if (e.getSource() == deleteButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negativeButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }

    public static long fact(int n) {
        Long k = 1L;
        for (int i = 1; i <= n; i++) {
            k *= i;
        }
        return k;
    }
}