
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

public class CarInventory {
	
	public Object[][] getTable0()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
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
//SEARCH	
	public Object[][] getTable1(String brandKey)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root", "password");
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT * from cars WHERE Concat(vin, '', brand, '', model, '', year, '', mileage, '', price, '', color, '') like '%" 
				+ brandKey + "%'");
		
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
//DELETE	
	public Object[][] getTable2(String brandKey)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root", "password");
		Statement statement = connection.createStatement();
		
		String str = "delete from cars where vin = '" + brandKey +"'";
		statement.executeUpdate(str);
		
		//ResultSet rs = statement.executeQuery("select * from cars where vin = '" + brandKey + "'");
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
//ADD	
	public Object[][] getTable3(String vin, String brand, String model, String year, String mileage, String price, String color, int nu)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root", "password");
		Statement statement = connection.createStatement();
		
//		INSERT INTO cars VALUES ('684YT', 'Toyota','Camry', 2008, 40000,8000,'Black', 0);

		String str = "INSERT INTO cars (vin, brand, model, year, mileage, price, color, blandNew)" + "VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(str);
		ps.setString(1, vin);
		ps.setString(2, brand);
		ps.setString(3, model);
		ps.setString(4, year);
		ps.setString(5, mileage);
		ps.setString(6, price);
		ps.setString(7, color);
		ps.setInt(8, nu);
		ps.executeUpdate();
		
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
//UPDATE
	public Object[][] getTable4(String vin, String brand, String model, String year, String mileage, String price, String color, int nu)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root", "password");
		Statement statement = connection.createStatement();
		
//		INSERT INTO cars VALUES ('684YT', 'Toyota','Camry', 2008, 40000,8000,'Black', 0);
		String updateSQL = "";	
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(updateSQL);

		if(!brand.equals(""))
		{
			updateSQL = "UPDATE cars SET brand = ? where vin = ?";	
			ps = (PreparedStatement) connection.prepareStatement(updateSQL);
			ps.setString(1, brand);
			ps.setString(2, vin);
			ps.executeUpdate();
		}
		if(!model.equals(""))
		{
			updateSQL = "UPDATE cars SET model = ? where vin = ?";	
			ps = (PreparedStatement) connection.prepareStatement(updateSQL);
			ps.setString(1, model);
			ps.setString(2, vin);
			ps.executeUpdate();
		}
		if(!year.equals(""))
		{
			updateSQL = "UPDATE cars SET year = ? where vin = ?";	
			ps = (PreparedStatement) connection.prepareStatement(updateSQL);
			ps.setString(1, year);
			ps.setString(2, vin);
			ps.executeUpdate();
		}
		if(!mileage.equals(""))
		{
			updateSQL = "UPDATE cars SET mileage = ? where vin = ?";	
			ps = (PreparedStatement) connection.prepareStatement(updateSQL);
			ps.setString(1, mileage);
			ps.setString(2, vin);
			ps.executeUpdate();
		}
		if(!price.equals(""))
		{
			updateSQL = "UPDATE cars SET price = ? where vin = ?";	
			ps = (PreparedStatement) connection.prepareStatement(updateSQL);
			ps.setString(1, price);
			ps.setString(2, vin);
			ps.executeUpdate();
		}
		if(!color.equals(""))
		{
			updateSQL = "UPDATE cars SET color = ? where vin = ?";	
			ps = (PreparedStatement) connection.prepareStatement(updateSQL);
			ps.setString(1, color);
			ps.setString(2, vin);
			ps.executeUpdate();
		}
		
		if(nu == 0)
		{
			updateSQL = "UPDATE cars SET blandNew = ? where vin = ?";	
			ps = (PreparedStatement) connection.prepareStatement(updateSQL);
			ps.setInt(1, nu);
			ps.setString(2, vin);
			ps.executeUpdate();
		}
		else if(nu == 1)
		{
			updateSQL = "UPDATE cars SET blandNew = ? where vin = ?";	
			ps = (PreparedStatement) connection.prepareStatement(updateSQL);
			ps.setInt(1, nu);
			ps.setString(2, vin);
			ps.executeUpdate();
		}
		else
		{
			//Nothing!
		}
		
		Object[][] data = getTable0();

		connection.close();
		return data;
	}

}
