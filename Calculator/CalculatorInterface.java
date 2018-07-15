/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorinterface;

/**
 *
 * @author Rodrigo Sandoval & Raul Muniz
 * Prototype (Homework 6.2)
 * CMPE 3341-01
 * Dr. Poveda
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorInterface extends JFrame {
    /***Numbers***/
    private final JButton jbtNum1;
    private final JButton jbtNum2;
    private final JButton jbtNum3;
    private final JButton jbtNum4;
    private final JButton jbtNum5;
    private final JButton jbtNum6;
    private final JButton jbtNum7;
    private final JButton jbtNum8;
    private final JButton jbtNum9;
    private final JButton jbtNum0;
    private final JButton javaProj;
    
    /***Operators***/
    private final JButton jbtAdd;
    private final JButton jbtSubtract;
    private final JButton jbtMultiply;
    private final JButton jbtDivide;
    
    /***Commands***/

    private final JButton jbtSolve;
    private final JButton jbtClear;
    
    private double FIRST;
    private double SECOND;
    private double SOLUTION;
    private final JTextField jtfResult;

    Boolean addBool = false ;
    Boolean subBool = false ;
    Boolean divBool = false ;
    Boolean mulBool = false ;

    String display = "";

    public CalculatorInterface() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 3));
        p1.add(jbtNum1 = new JButton("1"));
        p1.add(jbtNum2 = new JButton("2"));
        p1.add(jbtNum3 = new JButton("3"));
        p1.add(jbtNum4 = new JButton("4"));
        p1.add(jbtNum5 = new JButton("5"));
        p1.add(jbtNum6 = new JButton("6"));
        p1.add(jbtNum7 = new JButton("7"));
        p1.add(jbtNum8 = new JButton("8"));
        p1.add(jbtNum9 = new JButton("9"));
        p1.add(jbtNum0 = new JButton("0"));
        p1.add(jbtClear = new JButton("Clear"));
        p1.add(javaProj = new JButton("CMPE 3341"));


        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(jtfResult = new JTextField(20));
        jtfResult.setHorizontalAlignment(JTextField.RIGHT);
        jtfResult.setEditable(false);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(5, 1));
        p3.add(jbtAdd = new JButton("+"));
        p3.add(jbtSubtract = new JButton("-"));
        p3.add(jbtMultiply = new JButton("*"));
        p3.add(jbtDivide = new JButton("/"));
        p3.add(jbtSolve = new JButton("="));

        JPanel p = new JPanel();
        p.setLayout(new GridLayout());
        p.add(p2, BorderLayout.NORTH);
        p.add(p1, BorderLayout.SOUTH);
        p.add(p3, BorderLayout.EAST);


        add(p);

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

        jbtAdd.addActionListener(new ListenToAdd());
        jbtSubtract.addActionListener(new ListenToSubtract());
        jbtMultiply.addActionListener(new ListenToMultiply());
        jbtDivide.addActionListener(new ListenToDivide());
        jbtSolve.addActionListener(new ListenToSolve());
        jbtClear.addActionListener(new ListenToClear());



    } //CaluclatorInterface()

    class ListenToClear implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            jtfResult.setText("");
            addBool = false ;
            subBool = false ;
            mulBool = false ;
            divBool = false ;

            FIRST = 0;
            SECOND =0 ;
        }
    }

    class ListenToOne implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display = jtfResult.getText();
            jtfResult.setText(display + "1");
        }
    }
    class ListenToTwo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display = jtfResult.getText();
            jtfResult.setText(display + "2");
        }
    }
    class ListenToThree implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display = jtfResult.getText();
            jtfResult.setText(display + "3");
        }
    }
    class ListenToFour implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {
            display = jtfResult.getText();
            jtfResult.setText(display + "4");
        }
    }
    class ListenToFive implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display = jtfResult.getText();
            jtfResult.setText(display + "5");
        }
    }
    class ListenToSix implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display = jtfResult.getText();
            jtfResult.setText(display + "6");
        }
    }
    class ListenToSeven implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display = jtfResult.getText();
            jtfResult.setText(display + "7");
        }
    }
    class ListenToEight implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display = jtfResult.getText();
            jtfResult.setText(display + "8");
        }
    }
    class ListenToNine implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display = jtfResult.getText();
            jtfResult.setText(display + "9");
        }
    }
    class ListenToZero implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display = jtfResult.getText();
            jtfResult.setText(display + "0");
        }
    }

    class ListenToAdd implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FIRST = Double.parseDouble(jtfResult.getText());
                        jtfResult.setText("");
                        addBool = true ;

        }
    }
    class ListenToSubtract implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FIRST = Double.parseDouble(jtfResult.getText());
            jtfResult.setText("");
            subBool =true;
        }
    }
    class ListenToMultiply implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FIRST = Double.parseDouble(jtfResult.getText());
            jtfResult.setText("");
            mulBool =true;

        }
    }
    class ListenToDivide implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FIRST = Double.parseDouble(jtfResult.getText());
            jtfResult.setText("");
            divBool =true;
        }
    }
    class ListenToSolve implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SECOND = Double.parseDouble(  jtfResult.getText() );
            
            if ( addBool == true  )
                SOLUTION = SECOND + FIRST;
            else if ( subBool == true  )
                SOLUTION = FIRST - SECOND;
            else if ( mulBool == true  )
                SOLUTION = SECOND * FIRST;
            else if ( divBool == true  )
                SOLUTION = FIRST / SECOND;
            
            jtfResult.setText(Double.toString(SOLUTION));
            
            addBool = false ;
            subBool = false ;
            mulBool = false ;
            divBool = false ;
        }
    }

    public static void main(String[] args) {
        CalculatorInterface calc = new CalculatorInterface();
        calc.pack();
        calc.setLocationRelativeTo(null);
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }

}