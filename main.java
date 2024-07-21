import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main implements ActionListener{


    JFrame screen;
    JTextField text;
    JButton[] numbers = new JButton[10];
    JButton[] funcButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel grid;


    Font myFont = new Font("Brush Script MT", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;




    Main(){


        screen = new JFrame("Calculator");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setSize(420, 550);
        screen.setLayout(null);


        text = new JTextField();
        text.setBounds(50, 25, 300, 50);
        text.setFont(myFont);
        text.setEditable(false);


        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");


        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = equButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;
        funcButtons[8] = negButton;


        for(int i = 0; i < 9; i++){
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
        }


        for(int i = 0; i < 10; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(myFont);
            numbers[i].setFocusable(false);
        }


        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);


        grid = new JPanel();
        grid.setBounds(50, 100, 300, 300);
        grid.setLayout(new GridLayout(4,4,10,10));


        grid.add(numbers[1]);
        grid.add(numbers[2]);
        grid.add(numbers[3]);
        grid.add(addButton);
        grid.add(numbers[4]);
        grid.add(numbers[5]);
        grid.add(numbers[6]);
        grid.add(subButton);
        grid.add(numbers[7]);
        grid.add(numbers[8]);
        grid.add(numbers[9]);
        grid.add(mulButton);
        grid.add(decButton);
        grid.add(numbers[0]);
        grid.add(equButton);
        grid.add(divButton);


        screen.add(grid);
        screen.add(negButton);
        screen.add(delButton);
        screen.add(clrButton);
        screen.add(text);
        screen.setVisible(true);
    }


    public static void main(String[] args){


        Main calc = new Main();
    }


    @Override
    public void actionPerformed(ActionEvent e){


        for(int i = 0; i < 10; i++){
            if(e.getSource() == numbers[i]){
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton) {
            text.setText(text.getText().concat("."));
        }
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(text.getText());
            operator = '+';
            text.setText("");
        }
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(text.getText());
            operator = '-';
            text.setText("");
        }
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(text.getText());
            operator = 'x';
            text.setText("");
        }
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(text.getText());
            operator = '/';
            text.setText("");
        }
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(text.getText());


            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            text.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton) {
            text.setText("");
        }
        if(e.getSource() == delButton) {
            String string = text.getText();
            text.setText("");
            for(int i = 0; i < string.length() - 1; i++){
                text.setText(text.getText() + string.charAt(i));
            }
        }
        if(e.getSource() == negButton) {
            double temp = Double.parseDouble(text.getText());
            temp *= -1;
            text.setText(String.valueOf(temp));


        }
    }


}

