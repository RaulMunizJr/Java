//Raul Muniz
//Lab13
//4-2-18
import javax.swing.*;
import java.awt.event.*;
public class Main extends JFrame
{
            private JLabel messageLabel1;
            private JTextField textField1;
            private JButton button1;
            public Main()
            {
	            	super("Kilo to Mile");
	            	setSize(330,220);
	            	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            	setLayout(null);
	            
	            	messageLabel1 = new JLabel("Enter a value");
	            	messageLabel1.setSize(100, 30);
	            	messageLabel1.setLocation(50, 50);
	            	add(messageLabel1);
	            	
	            	textField1 = new JTextField(10);
	            	textField1.setSize(100, 30);
	            	textField1.setLocation(150, 50);
	            	add(textField1);
	            	
	            	button1 = new JButton("Calculate");
	            	button1.setSize(100, 30);
	            	button1.setLocation(100, 100);
	            	button1.addActionListener(new Button1Clicked());
	            	add(button1);
	            	
	            	setVisible(true);
            	}
            
            private class Button1Clicked implements ActionListener
            {
                        public void actionPerformed(ActionEvent e)
                        {
                        		JOptionPane.showMessageDialog(null, Double.parseDouble(textField1.getText())*0.6214+" miles"); 
                        	}
            }
            public static void main(String args[])
            {
            		new Main();
            }
}

