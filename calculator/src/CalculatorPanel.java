
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CalculatorPanel extends JFrame {

    private JButton jbtNum1,jbtNum2,jbtNum3,jbtNum4,jbtNum5,
            jbtNum6,jbtNum7,jbtNum8,jbtNum9,jbtNum0,
            jbtAdd,jbtSubtract,jbtMultiply,jbtDivide,jbtBack,
            jbtSolve,jbtClear,jbtLPara, jbtRPara, jbtPeriod;

    private String temp;
    private JTextField jtfResult;

    public CalculatorPanel() {
        //JPanel for buttons
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 4));
        p1.add(jbtBack = new JButton("<="));
        
        p1.add(jbtLPara = new JButton("("));
        p1.add(jbtRPara = new JButton(")"));
        p1.add(jbtMultiply = new JButton("*"));
        
        p1.add(jbtNum1 = new JButton("1"));
        p1.add(jbtNum2 = new JButton("2"));
        p1.add(jbtNum3 = new JButton("3"));
        p1.add(jbtDivide = new JButton("/"));
        
        p1.add(jbtNum4 = new JButton("4"));
        p1.add(jbtNum5 = new JButton("5"));
        p1.add(jbtNum6 = new JButton("6"));
        p1.add(jbtAdd = new JButton("+"));
        
        p1.add(jbtNum7 = new JButton("7"));
        p1.add(jbtNum8 = new JButton("8"));
        p1.add(jbtNum9 = new JButton("9"));
        p1.add(jbtSubtract = new JButton("-"));
        
        p1.add(jbtPeriod = new JButton("."));
        p1.add(jbtNum0 = new JButton("0"));
        p1.add(jbtClear = new JButton("C"));
        p1.add(jbtSolve = new JButton("="));
        


        //panel for JTextField jtfResult
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(jtfResult = new JTextField(26));
        jtfResult.setHorizontalAlignment(JTextField.RIGHT);
        jtfResult.setEditable(false);

        //Overall JPanel p1 and p2 are added to this one
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(p2, BorderLayout.NORTH);
        p.add(p1, BorderLayout.SOUTH);

        add(p);
        //numbers
        jbtNum1.addActionListener(new ListenToOne());
        jbtNum2.addActionListener(new ListenToTwo());
        jbtNum3.addActionListener(new ListenToThree());
        jbtNum4.addActionListener(new ListenToFour());
        jbtNum5.addActionListener(new ListenToFive());
        jbtNum6.addActionListener(new ListenToSix());
        jbtNum7.addActionListener(new ListenToSeven());
        jbtNum8.addActionListener(new ListenToEight());
        jbtNum9.addActionListener(new ListenToNine());
        jbtNum0.addActionListener(new ListenToZero());
        //operators and misc.
        
        jbtAdd.addActionListener(new ListenToAdd());
        jbtSubtract.addActionListener(new ListenToSubtract());
        jbtMultiply.addActionListener(new ListenToMultiply());
        jbtDivide.addActionListener(new ListenToDivide());
        jbtSolve.addActionListener(new ListenToSolve());
        jbtClear.addActionListener(new ListenToClear());
        jbtPeriod.addActionListener(new ListenToPeriod());
        jbtLPara.addActionListener(new ListenToLPara());
        jbtRPara.addActionListener(new ListenToRPara());
        jbtBack.addActionListener(new ListenToBack());

    } 
    //actionListeners for buttons 

    class ListenToClear implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            jtfResult.setText("");
            temp = "";
        }
    }

    class ListenToOne implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = jtfResult.getText();
            jtfResult.setText(temp + "1");
            temp = (jtfResult.getText());
        }
    }

    class ListenToTwo implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = jtfResult.getText();
            jtfResult.setText(temp + "2");
            temp = (jtfResult.getText());
        }
    }

    class ListenToThree implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = jtfResult.getText();
            jtfResult.setText(temp + "3");
            temp = (jtfResult.getText());
        }
    }

    class ListenToFour implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = jtfResult.getText();
            jtfResult.setText(temp + "4");
            temp = (jtfResult.getText());
        }
    }

    class ListenToFive implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = jtfResult.getText();
            jtfResult.setText(temp + "5");
            temp = (jtfResult.getText());
        }
    }

    class ListenToSix implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = jtfResult.getText();
            jtfResult.setText(temp + "6");
            temp = (jtfResult.getText());
        }
    }

    class ListenToSeven implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = jtfResult.getText();
            jtfResult.setText(temp + "7");
            temp = (jtfResult.getText());
        }
    }

    class ListenToEight implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = jtfResult.getText();
            jtfResult.setText(temp + "8");
            temp = (jtfResult.getText());
        }
    }

    class ListenToNine implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = jtfResult.getText();
            jtfResult.setText(temp + "9");
            temp = (jtfResult.getText());
        }
    }

    class ListenToZero implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = jtfResult.getText();
            jtfResult.setText(temp + "0");
            temp = (jtfResult.getText());
        }
    }

    class ListenToAdd implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = (jtfResult.getText());
            jtfResult.setText(temp + "+");
            temp = (jtfResult.getText());

        }
    }

    class ListenToPeriod implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = (jtfResult.getText());
            jtfResult.setText(temp + ".");
            temp = (jtfResult.getText());

        }
    }

    class ListenToSubtract implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = (jtfResult.getText());
            jtfResult.setText(temp + "-");
            temp = (jtfResult.getText());
        }
    }

    class ListenToMultiply implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = (jtfResult.getText());
            jtfResult.setText(temp + "*");
            temp = (jtfResult.getText());

        }
    }

    class ListenToDivide implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = (jtfResult.getText());
            jtfResult.setText(temp + "/");
            temp = (jtfResult.getText());
        }
    }

    class ListenToLPara implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = (jtfResult.getText());
            jtfResult.setText(temp + "(");
            temp = (jtfResult.getText());
        }
    }

    class ListenToRPara implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            temp = (jtfResult.getText());
            jtfResult.setText(temp + ")");
            temp = (jtfResult.getText());
        }
    }
    
     class ListenToBack implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (temp == null || temp == "" || temp.length() == 0)
            {
                temp = temp;
            }
            else{
            temp = (jtfResult.getText());
            temp = temp.substring(0, temp.length() - 1);
            jtfResult.setText(temp);
            }
        }
    }
    class ListenToSolve implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            InfixToPostfixParens converter = new InfixToPostfixParens();
            TestInfixEval eval = new TestInfixEval();
            try {
                String postfix = converter.convert(temp);
                double answer = eval.evaluatePostfix(postfix);
                jtfResult.setText(temp + " = " + answer);
//                System.out.println("equals: " + answer);
            } catch (Exception ex) {
                jtfResult.setText("Bad Input");
                temp = "";
            }
        }
    }

    public static void main(String[] args) {
        // runs the program
        CalculatorPanel calc = new CalculatorPanel();
        calc.pack();
        calc.setLocationRelativeTo(null);
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }
} // CalculatorPanel

