package TConverter;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TConverter extends JFrame {
     private JTextField c= new JTextField();
     private JTextField f= new JTextField();
     private JButton button = new JButton("Convert");
     
public TConverter() {
    JPanel p1 = new JPanel(new GridLayout(2, 2));  //set rows and columns
    p1.add(new JLabel("Celsius"));
    p1.add(c);
    p1.add(new JLabel("Fahrenheit"));
    p1.add(f);
    p1.setBorder(new TitledBorder("Convert C2F or F2C"));
    
    
    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); //center button
    p3.add(button);

    // Add the panels to the frame
    add(new JPanel(), BorderLayout.NORTH);
    add(p1, BorderLayout.CENTER);
    add(p3, BorderLayout.SOUTH);
    
    
    button.addActionListener(new ButtonListener());
	
}

   private class ButtonListener implements ActionListener{
       
      public void actionPerformed(ActionEvent e){
          
      try
      {
         double c_input=Double.parseDouble(c.getText());
         T t=new T(c_input,0);
         f.setText(String.format("%.1f",t.getFarenheits()));      
          
      }
      catch(Exception ex ){}
          
      }   
   }
    
  
    public static void main(String[] args) {
    TConverter frame = new TConverter();
    frame.setTitle("TConvert");  
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close when click on x
    frame.setVisible(true);
    frame.setSize(200,150);
    frame.setResizable(false);
    }
}
