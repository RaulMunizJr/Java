import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class inventory {
    
    inventory() {
    	
        //constructor
    	
    }
    //**********************************************************************************
    void displayCars() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root","password");
        Statement st = conn.createStatement();
        String sqlstr = "select * from Inventory.inventory_table";
        ResultSet rs = st.executeQuery(sqlstr);
        ResultSetMetaData rsmd = rs.getMetaData();
        int colNum = rsmd.getColumnCount();
        
        System.out.printf("%-17s %-17s %-17s %-17s %-17s %-17s %-17s %-17s\n", "VIN", "Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
        
        while (rs.next()) {
            for (int i = 1; i <= colNum; ++i) {
                System.out.printf("%-17s ", rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
        
        conn.close();
    }
    //**********************************************************************************

    void sortCars(int choice) throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root","password");
        Statement st = conn.createStatement();
        String sqlstr;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int colNum;
        
        System.out.printf("\n%-17s %-17s %-17s %-17s %-17s %-17s %-17s %-17s\n", "VIN", "Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
        
        if (choice == 1) {
            sqlstr = "select * from Inventory.inventory_table ORDER BY vin";
            rs = st.executeQuery(sqlstr);
            rsmd = rs.getMetaData();
            colNum = rsmd.getColumnCount();
            
            while (rs.next()) {
                for (int i = 1; i <= colNum; ++i) {
                    System.out.printf("%-17s ", rs.getString(i));
                }
                System.out.println();
            }
            
        }
        else if (choice == 2) {
            sqlstr = "select * from Inventory.inventory_table ORDER BY brand";
            rs = st.executeQuery(sqlstr);
            rsmd = rs.getMetaData();
            colNum = rsmd.getColumnCount();
            
            while (rs.next()) {
                for (int i = 1; i <= colNum; ++i) {
                    System.out.printf("%-17s ", rs.getString(i));
                }
                System.out.println();
            }
        }
        else if (choice == 3) {
            sqlstr = "select * from Inventory.inventory_table ORDER BY model";
            rs = st.executeQuery(sqlstr);
            rsmd = rs.getMetaData();
            colNum = rsmd.getColumnCount();
            
            while (rs.next()) {
                for (int i = 1; i <= colNum; ++i) {
                    System.out.printf("%-17s ", rs.getString(i));
                }
                System.out.println();
            }
        }
        else if (choice == 4) {
            sqlstr = "select * from Inventory.inventory_table ORDER BY year";
            rs = st.executeQuery(sqlstr);
            rsmd = rs.getMetaData();
            colNum = rsmd.getColumnCount();
            
            while (rs.next()) {
                for (int i = 1; i <= colNum; ++i) {
                    System.out.printf("%-17s ", rs.getString(i));
                }
                System.out.println();
            }
        }
        else if (choice == 5) {
            sqlstr = "select * from Inventory.inventory_table ORDER BY mileage";
            rs = st.executeQuery(sqlstr);
            rsmd = rs.getMetaData();
            colNum = rsmd.getColumnCount();
            
            while (rs.next()) {
                for (int i = 1; i <= colNum; ++i) {
                    System.out.printf("%-17s ", rs.getString(i));
                }
                System.out.println();
            }
        }
        else if (choice == 6) {
            sqlstr = "select * from Inventory.inventory_table ORDER BY price";
            rs = st.executeQuery(sqlstr);
            rsmd = rs.getMetaData();
            colNum = rsmd.getColumnCount();
            
            while (rs.next()) {
                for (int i = 1; i <= colNum; ++i) {
                    System.out.printf("%-17s ", rs.getString(i));
                }
                System.out.println();
            }
        }
        else if (choice == 7) {
            sqlstr = "select * from Inventory.inventory_table ORDER BY color";
            rs = st.executeQuery(sqlstr);
            rsmd = rs.getMetaData();
            colNum = rsmd.getColumnCount();
            
            while (rs.next()) {
                for (int i = 1; i <= colNum; ++i) {
                    System.out.printf("%-17s ", rs.getString(i));
                }
                System.out.println();
            }
        }
        System.out.println();
        conn.close();
    }
    //**********************************************************************************

    void usrDisplayCars(int choice) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root","password");
        Statement st = conn.createStatement();
        String sqlstr;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int colNum;
        
        System.out.printf("\n%-17s %-17s %-17s %-17s %-17s %-17s %-17s %-17s\n", "VIN", "Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
        
        if (choice == 1) {
            sqlstr = "select * from Inventory.inventory_table where brandnew = 'Y'";
            rs = st.executeQuery(sqlstr);
            rsmd = rs.getMetaData();
            colNum = rsmd.getColumnCount();
            
            while (rs.next()) {
                for (int i = 1; i <= colNum; ++i) {
                    System.out.printf("%-17s ", rs.getString(i));
                }
                System.out.println();
            }           
        }
        else if (choice == 2) {
            sqlstr = "select * from Inventory.inventory_table where brandnew = 'N'";
            rs = st.executeQuery(sqlstr);
            rsmd = rs.getMetaData();
            colNum = rsmd.getColumnCount();
            
            while (rs.next()) {
                for (int i = 1; i <= colNum; ++i) {
                    System.out.printf("%-17s ", rs.getString(i));
                }
                System.out.println();
            }                       
        }
        System.out.println();
        
        conn.close();
    }
    //**********************************************************************************

    void addCar() throws SQLException {
        String sqlstr;
        String vin;
        String brand;
        String model;
        int year;
        int mileage;
        double price;
        char color;
        char brandnew;
        
        Scanner in = new Scanner(System.in);
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root","password");
        PreparedStatement pstmt;
        Statement st;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int colNum;
        
        System.out.print("VIN: ");
        vin = in.next();
        System.out.print("Brand: ");
        brand = in.next();
        System.out.print("Model: ");
        model = in.next();
        System.out.print("Year: ");
        year = in.nextInt();
        System.out.print("Mileage: ");
        mileage = in.nextInt();
        System.out.print("Price: ");
        price = in.nextInt();
        System.out.print("Color: ");
        color = in.next().charAt(0);
        System.out.print("New: ");
        brandnew = in.next().charAt(0);
        sqlstr = "insert into Inventory.inventory_table(vin,brand,model,year,mileage,price,color,brandnew) VALUES(?,?,?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(sqlstr);
        pstmt.setString(1, vin);
        pstmt.setString(2, brand);
        pstmt.setString(3, model);
        pstmt.setInt(4, year);
        pstmt.setInt(5, mileage);
        pstmt.setDouble(6, price);
        pstmt.setString(7, String.valueOf(color));
        pstmt.setString(8, String.valueOf(brandnew));
        pstmt.executeUpdate();
        
        sqlstr = "select * from Inventory.inventory_table";
        st = conn.createStatement();
        rs = st.executeQuery(sqlstr);
        rsmd = rs.getMetaData();
        colNum = rsmd.getColumnCount();
        
        System.out.printf("\n%-17s %-17s %-17s %-17s %-17s %-17s %-17s %-17s\n", "VIN", "Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
        
        while (rs.next()) {
            for (int i = 1; i <= colNum; ++i) {
                System.out.printf("%-17s ", rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
        
        conn.close();
    }
    //**********************************************************************************

    void deleteCar() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root","password");
        PreparedStatement pstmt;
        Statement st = conn.createStatement();
        ResultSet rs;
        ResultSetMetaData rsmd;
        int colNum;
        Scanner in = new Scanner(System.in);
        String sqlstr;
        String vin;
        System.out.print("Please input VIN: ");
        vin = in.next();
        
        sqlstr = "delete from Inventory.inventory_table where vin = ?";
        pstmt = conn.prepareStatement(sqlstr);
        
        pstmt.setString(1, vin);
        pstmt.executeUpdate();
        
        System.out.println();
        
        System.out.printf("%-17s %-17s %-17s %-17s %-17s %-17s %-17s %-17s\n", "VIN", "Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
        
        sqlstr = "select * from Inventory.inventory_table";
        
        rs = st.executeQuery(sqlstr);
        rsmd = rs.getMetaData();
        colNum = rsmd.getColumnCount();
        
        while (rs.next()) {
            for (int i = 1; i <= colNum; ++i) {
                System.out.printf("%-17s ", rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
        
        // Closing connection
        conn.close();
    }
    //**********************************************************************************

    void updateCar() throws SQLException {
        menu m = new menu();
        Connection conn = DriverManager.getConnection("jdbc:mysql://35.184.176.204:3306/carmax", "root","password");
        PreparedStatement pstmt;
        Statement st = conn.createStatement();
        ResultSet rs;
        ResultSetMetaData rsmd;
        int colNum;
        Scanner in = new Scanner(System.in);
        String sqlstr;
        String vin;
        int choice;
        
        System.out.printf("%-17s %-17s %-17s %-17s %-17s %-17s %-17s %-17s\n", "VIN", "Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
        
        sqlstr = "select * from Inventory.inventory_table";
        
        rs = st.executeQuery(sqlstr);
        rsmd = rs.getMetaData();
        colNum = rsmd.getColumnCount();
        
        while (rs.next()) {
            for (int i = 1; i <= colNum; ++i) {
                System.out.printf("%-17s ", rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.print("Please input VIN: ");
        vin = in.next();
        
        System.out.println();
        
        m.adminSub4();
        
        System.out.println();
        
        System.out.print("Please select option: ");
        choice = in.nextInt();
        
        System.out.println();
        
        if (choice == 1) {
            String brand;
            sqlstr = "update Inventory.inventory_table set brand = ? "
                    + "where vin = ?";
            System.out.print("Please input brand: ");
            brand = in.next();
            pstmt = conn.prepareStatement(sqlstr);
            pstmt.setString(1, brand);
            pstmt.setString(2, vin);
            pstmt.executeUpdate();
        }
        else if (choice == 2) {
            String model;
            sqlstr = "update Inventory.inventory_table set model = ? "
                    + "where vin = ?";
            System.out.print("Please input model: ");
            model = in.next();
            pstmt = conn.prepareStatement(sqlstr);
            pstmt.setString(1, model);
            pstmt.setString(2, vin);
            pstmt.executeUpdate();
        }
        else if (choice == 3) {
            int year;
            sqlstr = "update Inventory.inventory_table set year = ? "
                    + "where vin = ?";
            System.out.print("Please input year: ");
            year = in.nextInt();
            pstmt = conn.prepareStatement(sqlstr);
            pstmt.setInt(1, year);
            pstmt.setString(2, vin);
            pstmt.executeUpdate();
        }
        else if (choice == 4) {
            int mileage;
            sqlstr = "update Inventory.inventory_table set mileage = ? "
                    + "where vin = ?";
            System.out.print("Please input mileage: ");
            mileage = in.nextInt();
            pstmt = conn.prepareStatement(sqlstr);
            pstmt.setInt(1, mileage);
            pstmt.setString(2, vin);
            pstmt.executeUpdate();
        }
        else if (choice == 5) {
            double price;
            sqlstr = "update Inventory.inventory_table set price = ? "
                    + "where vin = ?";
            System.out.print("Please input price: ");
            price = in.nextDouble();
            pstmt = conn.prepareStatement(sqlstr);
            pstmt.setDouble(1, price);
            pstmt.setString(2, vin);
            pstmt.executeUpdate();
        }
        else if (choice == 6) {
            char color;
            sqlstr = "update Inventory.inventory_table set color = ? "
                    + "where vin = ?";
            System.out.print("Please input color: ");
            color = in.next().charAt(0);
            pstmt = conn.prepareStatement(sqlstr);
            pstmt.setString(1, String.valueOf(color));
            pstmt.setString(2, vin);
            pstmt.executeUpdate();
        }
        else {
            System.out.println("Invalid option.\n");
            return;
        }
        System.out.println("It's updated. Thank you.");
        System.out.printf("%-17s %-17s %-17s %-17s %-17s %-17s %-17s %-17s\n", "VIN", "Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
        
        sqlstr = "select * from Inventory.inventory_table";
        
        rs = st.executeQuery(sqlstr);
        rsmd = rs.getMetaData();
        colNum = rsmd.getColumnCount();
        
        while (rs.next()) {
            for (int i = 1; i <= colNum; ++i) {
                System.out.printf("%-17s ", rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
        
        conn.close();
    }
}