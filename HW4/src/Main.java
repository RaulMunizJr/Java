
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;
import java.awt.event.*;
import java.sql.SQLException;
public class Main extends JFrame 
{
	private JLabel label1, label2, label3, label4, label5, label6, label7;
	private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	private JButton b1, b2, b3, b4;
	private JRadioButton b5, b6;
	private boolean nu = true;
	
	private String[] columnNames = {"VIN","Brand","Model","Year","Mileage","Price","Color", "Brand New"};
	private Object[][] data={{"","","","","","","",""}};
	private JTable table;
	private DefaultTableModel dm;
	private JScrollPane scroll;
	
	CarInventory ci = new CarInventory();
	
	public Main() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{	
		super("Carmax");
		setSize(800,610);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		table = new JTable();
		dm = new DefaultTableModel(ci.getTable0(), columnNames);
		table.setModel(dm);
		scroll = new JScrollPane(table);
		scroll.setSize(700,270);
		scroll.setLocation(50,50);
		add(scroll);
		
		b1 = new JButton("Search");
		b1.setSize(100,30);
		b1.setLocation(50, 350);
		b1.addActionListener(new Button1Clicked());
		add(b1);
		
		b2 = new JButton("Delete");
		b2.setSize(100,30);
		b2.setLocation(200, 350);
		b2.addActionListener(new Button2Clicked());
		add(b2);
		
		b3 = new JButton("Update");
		b3.setSize(100,30);
		b3.setLocation(350, 350);
		b3.addActionListener(new Button3Clicked());
		add(b3);
		
		b4 = new JButton("Add");
		b4.setSize(100,30);
		b4.setLocation(500, 350);
		b4.addActionListener(new Button4Clicked());
		add(b4);
		
		
		
		label1 = new JLabel("VIN");
		label1.setSize(100,30);
		label1.setLocation(50,400);
		add(label1);
		tf1 = new JTextField();
		tf1.setSize(100,30);
		tf1.setLocation(100,400);
		add(tf1);
		
		label2 = new JLabel("Brand");			
		label2.setSize(100,30);					
		label2.setLocation(50,450);				
		add(label2);								
		tf2 = new JTextField();					
		tf2.setSize(100,30);						
		tf2.setLocation(100,450);				
		add(tf2);								
		
		label3 = new JLabel("Model");
		label3.setSize(100,30);
		label3.setLocation(250,450);
		add(label3);
		tf3 = new JTextField();
		tf3.setSize(100,30);
		tf3.setLocation(300,450);
		add(tf3);
		
		label4 = new JLabel("Year");
		label4.setSize(100,30);
		label4.setLocation(450,450);
		add(label4);
		tf4 = new JTextField();
		tf4.setSize(100,30);
		tf4.setLocation(500,450);
		add(tf4);
		
		label5 = new JLabel("Mileage");
		label5.setSize(100,30);
		label5.setLocation(50,500);
		add(label5);
		tf5 = new JTextField();
		tf5.setSize(100,30);
		tf5.setLocation(100,500);
		add(tf5);
		
		label6 = new JLabel("Price");
		label6.setSize(100,30);
		label6.setLocation(250,500);
		add(label6);
		tf6 = new JTextField();
		tf6.setSize(100,30);
		tf6.setLocation(300,500);
		add(tf6);
		
		label7 = new JLabel("Color");
		label7.setSize(100,30);
		label7.setLocation(450,500);
		add(label7);
		tf7 = new JTextField();
		tf7.setSize(100,30);
		tf7.setLocation(500,500);
		add(tf7);
		
		
		b5 = new JRadioButton("New");
        b5.setMnemonic(KeyEvent.VK_N);
        b5.setSize(100,30);
        b5.setLocation(300,400);
//		b5.addActionListener((ActionListener) this);
		add(b5);
		
		b6 = new JRadioButton("Used");
        b6.setMnemonic(KeyEvent.VK_U);
        b6.setSize(100,30);
        b6.setLocation(400,400);
//		b6.addActionListener((ActionListener) this);
		add(b6);
     
		ButtonGroup bg = new ButtonGroup();    
		bg.add(b5);
		bg.add(b6);    
		
		
        
		setVisible(true);
	}
//SEARCH	
	private class Button1Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			String str = tf1.getText() + tf2.getText()  + tf3.getText() + tf4.getText() + tf5.getText() + tf6.getText() + tf7.getText();
			int New = JRadioButton(null);
			if(str.equals(""))
			{
				try 
				{
					dm.setDataVector(ci.getTable0(), columnNames);
				} 
				catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
				dm.fireTableDataChanged();
			}
			else
			{
				try 
				{
					dm.setDataVector(ci.getTable1(str), columnNames);
				} 
				catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
				dm.fireTableDataChanged();
			}
			
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf7.setText("");
		}
	}
//DELETE	
	private class Button2Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			String str = tf1.getText();
			if(str.equals(""))
			{
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
					    "No VIN input!",
					    "Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try 
				{
					dm.setDataVector(ci.getTable2(str), columnNames);
				} 
				catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dm.fireTableDataChanged();
			}
			
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf7.setText("");
			try 
			{
				dm.setDataVector(ci.getTable0(), columnNames);
				dm.fireTableDataChanged();
			} 
			catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
//UPDATE	
	private class Button3Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if(tf1.getText().equals(""))
			{
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
					    "No VIN input!",
					    "Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try 
				{
					String str = tf1.getText();
					String str2 = tf2.getText();
					String str3 = tf3.getText();
					String str4 = tf4.getText();
					String str5 = tf5.getText();
					String str6 = tf6.getText();
					String str7 = tf7.getText();
					int New = JRadioButton(null);
					dm.addRow(ci.getTable4(str,str2,str3,str4,str5,str6,str7, New));
					dm.fireTableDataChanged();
				} 
				catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
			}
			
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf7.setText("");
			try 
			{
				dm.setDataVector(ci.getTable0(), columnNames);
				dm.fireTableDataChanged();
			} 
			catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
//ADD	
	private class Button4Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if(tf1.equals("") && tf2.equals("") && tf3.equals("") && tf4.equals("") && tf4.equals("") && tf5.equals("") && tf6.equals("") && tf7.equals(""))
			{
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
					    "Not enought Input!",
					    "Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try 
				{
					String str = tf1.getText();
					String str2 = tf2.getText();
					String str3 = tf3.getText();
					String str4 = tf4.getText();
					String str5 = tf5.getText();
					String str6 = tf6.getText();
					String  str7 = tf7.getText();
					int New = JRadioButton(null);
					dm.addRow(ci.getTable3(str,str2,str3,str4,str5,str6,str7, New));
					dm.fireTableDataChanged();
				} 
				catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
			}
//HERE
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf7.setText("");
			try 
			{
				dm.setDataVector(ci.getTable0(), columnNames);
				dm.fireTableDataChanged();
			} 
			catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
//New/Used Button	
	public int JRadioButton(Action a)
	{
		int New = 0;
		int nu = 0;
		//New
		if(b5.isSelected() == true)
		{
			//nu = true;
			nu = 0;
			New = 0;
		}		
		//Used
		else if(b6.isSelected() == true) 
		{
			nu = 1;
			New = 1;
		}
		else if(b5.isSelected() == false || b6.isSelected() == false)
		{
			New = 2;
		}
		return New;
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		new Main();
	}

}
