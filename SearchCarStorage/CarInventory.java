//Raul Muniz
//Lab14
//4-4-18
package lab14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarInventory {
	public Object[][] getTable0() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root", "password");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from cars");
		
		Object[][] data = new Object[100][8];
		int count = 0;
		
		while(rs.next())
		{	
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getString("year");
			data[count][4] = rs.getString("mileage");
			data[count][5] = rs.getString("price");
			data[count][6] = rs.getString("color");
			data[count][7] = rs.getString("blandNew");
			
			count++;
		}
		connection.close();
		
		
		
		return data;
	}
	
	public Object[][] getTable1(String brandKey)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root", "password");
		Statement statement = connection.createStatement();
		
		String sql = "select * from cars where brand = '" + brandKey + "';" ;
		ResultSet rs = statement.executeQuery(sql);
		
		Object[][] data = new Object[100][8];
		int count = 0;
		
		while(rs.next())
		{				
			data[count][0] = rs.getString("vin");
			data[count][1] = rs.getString("brand");
			data[count][2] = rs.getString("model");
			data[count][3] = rs.getString("year");
			data[count][4] = rs.getString("mileage");
			data[count][5] = rs.getString("price");
			data[count][6] = rs.getString("color");
			data[count][7] = rs.getString("blandNew");
			
			count++;
		}
		connection.close();
		return data;
	}

}
