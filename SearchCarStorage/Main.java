//Raul Muniz
//Lab14
//4-4-18
package lab14;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.SQLException;
public class Main extends JFrame 
{
	private JLabel label1, label2, label3, label4, label5, label6, label7;
	private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	private JButton b1, b2, b3, b4;
	
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
		
		add(b2);
		
		b3 = new JButton("Update");
		b3.setSize(100,30);
		b3.setLocation(350, 350);
		
		add(b3);
		
		b4 = new JButton("Add");
		b4.setSize(100,30);
		b4.setLocation(500, 350);
		
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
		
		setVisible(true);
	}
	
	private class Button1Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if (tf2.getText().equals(""))
			{
				try {
					dm.setDataVector(ci.getTable0(), columnNames);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}

			}
			else
			{
				try {
					dm.setDataVector(ci.getTable1(tf2.getText()), columnNames);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
			}
			dm.fireTableDataChanged();
		}
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		new Main();
	}

}
