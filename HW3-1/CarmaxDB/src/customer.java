import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class customer {
    
    customer() {
    	
    	//consturctor
    }
    //**********************************************************************************

    int findUser(String id, String pass) throws SQLException {
        String sqlstr;
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.192.32.238:3306/?user=root", "root","Njjmfetc12");
        PreparedStatement pstmt;
        Statement st = conn.createStatement();
        ResultSet rs;
        
        sqlstr = "select * from Customers.customer_table where id='" + id
                + "' and password='" + pass +"'";
        rs = st.executeQuery(sqlstr);
        
        if (rs.next()) {
            if (id.equals("admin")) {
                conn.close();
                return 1;
            }
            else {
                conn.close();
                return 2;
            }
        }
        else {
            conn.close();
            return 0;
        }
    }
    //**********************************************************************************

    void signUp() throws SQLException {
        String sqlstr;
        String id;
        String pass;
        String f_name;
        String l_name;
        String email;
        Scanner in = new Scanner(System.in);
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root","password");
        PreparedStatement pstmt;
        Statement st;
        ResultSet rs;
        
        System.out.print("\nPlease input user id: ");
        id = in.next();
        System.out.print("Please input password: ");
        pass = in.next();
        System.out.print("Please input password again: ");
        pass = in.next();
        System.out.print("Please input your first name: ");
        f_name = in.next();
        System.out.print("Please input your last name: ");
        l_name = in.next();
        System.out.print("Please input your email: ");
        email = in.next();
        System.out.println("Thank you for signing up!\n");
        
        sqlstr = "insert into Customers.customer_table(id,password,f_name,l_name,email) VALUES(?,?,?,?,?)";
        pstmt = conn.prepareStatement(sqlstr);
        pstmt.setString(1, id);
        pstmt.setString(2, pass);
        pstmt.setString(3, f_name);
        pstmt.setString(4, l_name);
        pstmt.setString(5, email);
        pstmt.executeUpdate();
        
        conn.close();
    }
    //**********************************************************************************

    void displayCustomers() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root","password");
        Statement st = conn.createStatement();
        String sqlstr = "select * from Customers.customer_table";
        ResultSet rs = st.executeQuery(sqlstr);
        ResultSetMetaData rsmd = rs.getMetaData();
        int colNum = rsmd.getColumnCount();
        
        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Id", "Password", "FirstName", "LastName", "Email");
        
        while (rs.next()) {
            for (int i = 1; i <= colNum; ++i) {
                System.out.printf("%-15s ", rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
        
        conn.close();
    }
    //**********************************************************************************

    void addUser() throws SQLException {
        String sqlstr;
        String id;
        String pass;
        String f_name;
        String l_name;
        String email;
        Scanner in = new Scanner(System.in);
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root","password");
        PreparedStatement pstmt;
        Statement st;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int colNum;
        
        System.out.print("Please input user id: ");
        id = in.next();
        System.out.print("Please input password: ");
        pass = in.next();
        System.out.print("Please input password again: ");
        pass = in.next();
        System.out.print("Please input your first name: ");
        f_name = in.next();
        System.out.print("Please input your last name: ");
        l_name = in.next();
        System.out.print("Please input your email: ");
        email = in.next();
        sqlstr = "insert into Customers.customer_table(id,password,f_name,l_name,email) VALUES(?,?,?,?,?)";
        pstmt = conn.prepareStatement(sqlstr);
        pstmt.setString(1, id);
        pstmt.setString(2, pass);
        pstmt.setString(3, f_name);
        pstmt.setString(4, l_name);
        pstmt.setString(5, email);
        pstmt.executeUpdate();
        
        sqlstr = "select * from Customers.customer_table";
        st = conn.createStatement();
        rs = st.executeQuery(sqlstr);
        rsmd = rs.getMetaData();
        colNum = rsmd.getColumnCount();
        
        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Id", "Password", "FirstName", "LastName", "Email");
        
        while (rs.next()) {
            for (int i = 1; i <= colNum; ++i) {
                System.out.printf("%-15s ", rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
        
        conn.close();
    }
    //**********************************************************************************

    void deleteUser() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root","password");
        PreparedStatement pstmt;
        Statement st = conn.createStatement();
        ResultSet rs;
        ResultSetMetaData rsmd;
        int colNum;
        Scanner in = new Scanner(System.in);
        String sqlstr;
        String id;
        System.out.print("Please input ID: ");
        id = in.next();
        
        sqlstr = "delete from Customers.customer_table where id = ?";
        pstmt = conn.prepareStatement(sqlstr);
        
        pstmt.setString(1, id);
        pstmt.executeUpdate();
        
        System.out.println();
        
        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Id", "Password", "Model", "FirstName", "LastName", "Email");
        
        sqlstr = "select * from Customers.customer_table";
        
        rs = st.executeQuery(sqlstr);
        rsmd = rs.getMetaData();
        colNum = rsmd.getColumnCount();
        
        while (rs.next()) {
            for (int i = 1; i <= colNum; ++i) {
                System.out.printf("%-15s ", rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
        
        conn.close();
    }
    //**********************************************************************************

    void updateUser() throws SQLException {
        menu m = new menu();
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root","password");
        PreparedStatement pstmt;
        Statement st = conn.createStatement();
        ResultSet rs;
        ResultSetMetaData rsmd;
        int colNum;
        Scanner in = new Scanner(System.in);
        String sqlstr;
        String id;
        int choice;
        
        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Id", "Password", "Model", "FirstName", "LastName", "Email");
        
        sqlstr = "select * from Customers.customer_table";
        
        rs = st.executeQuery(sqlstr);
        rsmd = rs.getMetaData();
        colNum = rsmd.getColumnCount();
        
        while (rs.next()) {
            for (int i = 1; i <= colNum; ++i) {
                System.out.printf("%-15s ", rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.print("Please input ID: ");
        id = in.next();
        
        System.out.println();
        
        m.adminSub8();
        
        System.out.println();
        
        System.out.print("Please select option: ");
        choice = in.nextInt();
        
        System.out.println();
        
        if (choice == 1) {
            String pass;
            sqlstr = "update Customers.customer_table set password = ? "
                    + "where id = ?";
            System.out.print("Please input new password: ");
            pass = in.next();
            pstmt = conn.prepareStatement(sqlstr);
            pstmt.setString(1, pass);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
        }
        else if (choice == 2) {
            String fname;
            sqlstr = "update Customers.customer_table set f_name = ? "
                    + "where id = ?";
            System.out.print("Please input new first name: ");
            fname = in.next();
            pstmt = conn.prepareStatement(sqlstr);
            pstmt.setString(1, fname);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
        }
        else if (choice == 3) {
            String lname;
            sqlstr = "update Customers.customer_table set l_name = ? "
                    + "where id = ?";
            System.out.print("Please input new last name: ");
            lname = in.next();
            pstmt = conn.prepareStatement(sqlstr);
            pstmt.setString(1, lname);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
        }
        else if (choice == 4) {
            String email;
            sqlstr = "update Customers.customer_table set email = ? "
                    + "where vin = ?";
            System.out.print("Please input new email: ");
            email = in.next();
            pstmt = conn.prepareStatement(sqlstr);
            pstmt.setString(1, email);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
        }
        else {
            System.out.println("Invalid option.\n");
            return;
        }
        System.out.println();
        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Id", "Password", "Model", "FirstName", "LastName", "Email");
        
        sqlstr = "select * from Customers.customer_table";
        
        rs = st.executeQuery(sqlstr);
        rsmd = rs.getMetaData();
        colNum = rsmd.getColumnCount();
        
        while (rs.next()) {
            for (int i = 1; i <= colNum; ++i) {
                System.out.printf("%-15s ", rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
        
        conn.close();
    }
    //**********************************************************************************

    void usrName(String id) throws SQLException {
        String sqlstr;
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root","password");
        PreparedStatement pstmt;
        Statement st = conn.createStatement();
        ResultSet rs;
        
        sqlstr = "select * from Customers.customer_table where id='" + id
                + "'";
        rs = st.executeQuery(sqlstr);
        
        rs.next();
        System.out.println("Welcome back " + rs.getString(3) + " " + rs.getString(4) + "!\n");
        
        conn.close();
    }
}