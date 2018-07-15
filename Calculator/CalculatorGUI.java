/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author RaulMuniz & Rodrigo Sandoval
 * CMPE 3341-01
 * Dr. Poveda
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI implements ActionListener, KeyListener {
  
  String disText = "";
  boolean first = true;
  boolean dec = false;
  boolean addBool, subBool, divBool, multBool;
  String[] operArr = new String[2];
  
  JTextField display = new JTextField(16);
  JButton[] buttons = new JButton[10];
  JButton per = new JButton(".");
  JButton equ = new JButton("=");
  JButton add = new JButton("+");
  JButton sub = new JButton("-");
  JButton mult = new JButton("X");
  JButton div = new JButton("/");
  JButton c = new JButton("Clear");
  
  public CalculatorGUI() {
    
    JFrame frame = new JFrame();
    JPanel button = new JPanel();
    JPanel text = new JPanel();
    JPanel oper = new JPanel();
    JPanel calc = new JPanel();
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Calculator");
    frame.setSize(350,230);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    
    button.setLayout(new GridLayout(4,3));
    
    for(int i = 1; i < 10; i++) {
     
      buttons[i] = new JButton();
      buttons[i].setText(Integer.toString(i));
      buttons[i].addActionListener(this);
      buttons[i].addKeyListener(this);
      button.add(buttons[i]);
      buttons[i].requestFocusInWindow();
      
    }
    
    buttons[0] = new JButton("0");
    buttons[0].addActionListener(this);
    buttons[0].addKeyListener(this);
    button.add(buttons[0]);
    button.add(per);
    per.addActionListener(this);
    c.addActionListener(this);
    button.add(c);
    per.addKeyListener(this);
    
    text.setLayout(new FlowLayout());
    display.setHorizontalAlignment(JTextField.RIGHT);
    display.setEditable(false);
    display.setPreferredSize(new Dimension(20, 32));
    display.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
    text.add(display);
    
    JButton[] operations = {add, sub, mult, div, equ};
    oper.setLayout(new GridLayout(5,1));
    
    for(int i = 0; i < 5; i++) {
      operations[i].addActionListener(this);
      oper.add(operations[i]); 
    }
    
    calc.setLayout(new FlowLayout());
    calc.add(text,BorderLayout.NORTH);
    calc.add(button, BorderLayout.WEST);
    calc.add(oper, BorderLayout.EAST);
    frame.add(calc);
    
    frame.setVisible(true);
  }
  
  public static void main(String args[]) {
   
    new CalculatorGUI();
    
  }
  
  public void actionPerformed(ActionEvent e) {
    StringBuilder stringBuilder = new StringBuilder();
    
    if (e.getSource() instanceof JButton) {
      String temp = ((JButton)e.getSource()).getText();
      
      if (((JButton)e.getSource()).getText().equals("Clear")){
        first = true;
        dec = false;
        disText = "";
        display.setText("");
        addBool = false;
        subBool= false;
        multBool = false;
        divBool = false;
     
        for(int i = 0; i < 2; i++)
          operArr[i] = "";
        
        for(int i = 0; i < 10; i++)
          buttons[i].setEnabled(true);
        per.setEnabled(true);
        equ.setEnabled(true);
        add.setEnabled(true);
        sub.setEnabled(true);
        mult.setEnabled(true);
        div.setEnabled(true);
      }
      else if (((JButton)e.getSource()).getText().equals("+")){
        addBool = true;
        first = true;
        dec = false;
        operArr[0] = disText;
        disText = "";
        display.setText("");
        
        for(int i = 0; i < 10; i++)
          buttons[i].setEnabled(true);
        per.setEnabled(true);
        equ.setEnabled(true);
        add.setEnabled(false);
        sub.setEnabled(false);
        mult.setEnabled(false);
        div.setEnabled(false);
      }
      else if (((JButton)e.getSource()).getText().equals("-")){
        subBool = true;
        first = true;
        dec = false;
        operArr[0] = disText;
        disText = "";
        display.setText("");
        
        for(int i = 0; i < 10; i++)
          buttons[i].setEnabled(true);
        per.setEnabled(true);
        equ.setEnabled(true);
        add.setEnabled(false);
        sub.setEnabled(false);
        mult.setEnabled(false);
        div.setEnabled(false);
      }
      else if (((JButton)e.getSource()).getText().equals("X")){
        multBool = true;
        first = true;
        dec = false;
        operArr[0] = disText;
        disText = "";
        display.setText("");
        
        for(int i = 0; i < 10; i++)
          buttons[i].setEnabled(true);
        per.setEnabled(true);
        equ.setEnabled(true);
        add.setEnabled(false);
        sub.setEnabled(false);
        mult.setEnabled(false);
        div.setEnabled(false);
      }
      else if (((JButton)e.getSource()).getText().equals("/")){
        divBool = true;
        first = true;
        dec = false;
        operArr[0] = disText;
        disText = "";
        display.setText("");
        
        for(int i = 0; i < 10; i++)
          buttons[i].setEnabled(true);
        per.setEnabled(true);
        equ.setEnabled(true);
        add.setEnabled(false);
        sub.setEnabled(false);
        mult.setEnabled(false);
        div.setEnabled(false);
      }
      else if (((JButton)e.getSource()).getText().equals("=")){
        double sum = 0;
        operArr[1] = display.getText();
        
        if (addBool)
          sum = Double.parseDouble(operArr[0]) + Double.parseDouble(operArr[1]);
        else if (subBool)
          sum = Double.parseDouble(operArr[0]) - Double.parseDouble(operArr[1]);
        else if (multBool)
          sum = Double.parseDouble(operArr[0]) * Double.parseDouble(operArr[1]);
        else if (divBool)
          sum = Double.parseDouble(operArr[0]) / Double.parseDouble(operArr[1]);
        
        disText = String.valueOf(sum);
        display.setText(disText);
        
        operArr[0] = disText;
        operArr[1] = "";
        
        addBool = false;
        subBool= false;
        multBool = false;
        divBool = false;
        dec = false;
        
        for(int i = 0; i < 10; i++)
          buttons[i].setEnabled(false);
        per.setEnabled(false);
        equ.setEnabled(false);
        add.setEnabled(true);
        sub.setEnabled(true);
        mult.setEnabled(true);
        div.setEnabled(true);
      }
      else if (((JButton)e.getSource()).getText().equals(".")){
        if(!dec) {
          stringBuilder.append(disText);
          
          if (first)
            stringBuilder.append("0.");
          else
            stringBuilder.append(".");
          
          disText = stringBuilder.toString();
          display.setText(disText);
          first = false;
        }
        dec = true;
      }
      else if (((JButton)e.getSource()).getText().equals("0")){
        if (!first) {
          stringBuilder.append(disText);
        
          int num = Integer.parseInt(temp);
        
          stringBuilder.append(Integer.toString(num));
          disText = stringBuilder.toString();
          display.setText(disText);
        }
      }
      else {
        stringBuilder.append(disText);
        
        int num = Integer.parseInt(temp);
        
        stringBuilder.append(Integer.toString(num));
        disText = stringBuilder.toString();
        display.setText(disText);
        first = false;
      }
    }
    
  }
  
  public void keyReleased(KeyEvent e){

  }

 

  public void keyTyped(KeyEvent e){

 }

  public void keyPressed (KeyEvent e){

   int keyID = (int) e.getKeyChar();

   switch (keyID) {
     
     case 10:
       equ.doClick();
       break;
     case 46:
       per.doClick();
       break;
     case 48:
       buttons[0].doClick();
       break;
     case 49:
       buttons[1].doClick();
       break;
     case 50:
       buttons[2].doClick();
       break;
     case 51:
       buttons[3].doClick();
       break;
     case 52:
       buttons[4].doClick();
       break;
     case 53:
       buttons[5].doClick();
       break;
     case 54:
       buttons[6].doClick();
       break;
     case 55:
       buttons[7].doClick();
       break;
     case 56:
       buttons[8].doClick();
       break;
     case 57:
       buttons[9].doClick();
       break;
     case 67:
     case 99:
       c.doClick();
       break;
       
   }

 }
  
}