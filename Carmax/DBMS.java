//Raul Muniz
//3-26-18
//Lab12
import java.sql.*;
public class DBMS {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmax", "root", "RMJ10muniz1");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from cars");
//35.184.176.204
		while(rs.next())
		{
//			System.out.println(rs.getString(1));
//		    System.out.println(rs.getString(2));
//		    System.out.println(rs.getString(3));
//		    System.out.println(rs.getString(4));
//		    System.out.println(rs.getString(5));
//		    System.out.println(rs.getString(6));
//		    System.out.println(rs.getString(7));
//		    System.out.println(rs.getString(8));
			
			System.out.println(rs.getString("vin") + " "
					+ rs.getString("brand") + " "
					+ rs.getString("model") + " "
					+ rs.getInt("year") + " "
					+ rs.getInt("mileage") + " "
					+ rs.getInt("price") + " "
					+ rs.getString("color") + " "
					+ rs.getInt("blandNew"));
//			System.out.println();
			
		}
		connection.close();

	}

}