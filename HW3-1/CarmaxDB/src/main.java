import java.sql.SQLException;
import java.util.Scanner;
public class main {
    public static void main(String[] args) throws SQLException {
      //  
        menu m = new menu();
        customer cu = new customer();
        inventory iv = new inventory();
        
        Scanner in = new Scanner(System.in);
        int choice = 0;
        
        while (true) {
            
            m.welcome();
            System.out.print("Please input: ");
            choice = in.nextInt();
            
            if (choice == 1) {
                String id;
                String pass;
                int found;
                System.out.print("\nPlease input your user id: ");
                id = in.next();
                System.out.print("Please input your password: ");
                pass = in.next();
                System.out.println();
                found = cu.findUser(id, pass);
                
                if (found == 1) {
                    cu.usrName(id);
                    do {
                        m.wBackAdmin();
                        System.out.print("Please input: ");
                        choice = in.nextInt();
                        
                        System.out.println();
                        
                        if (choice == 1)
                            iv.displayCars();
                        else if (choice == 2)
                            iv.addCar();
                        else if (choice == 3)
                            iv.deleteCar();
                        else if (choice == 4)
                            iv.updateCar();
                        else if (choice == 5)
                            cu.displayCustomers();
                        else if (choice == 6)
                            cu.addUser();
                        else if (choice == 7)
                            cu.deleteUser();
                        else if (choice == 8)
                            cu.updateUser();
                        else if (choice == 9)
                            break;
                        else
                            System.out.println("Not a valid option.");
                            
                    } while (choice != 9);
                }
                else if (found == 2) {
                    cu.usrName(id);
                    do {
                        m.wBackUser();
                        System.out.print("Please input: ");
                        choice = in.nextInt();
                        System.out.println();
                        if (choice == 1) {
                            int usrC;
                            m.userSub1();
                            System.out.print("\nPlease input: ");
                            usrC = in.nextInt();
                            
                            if (usrC == 1 || usrC == 2)
                                iv.usrDisplayCars(usrC);
                            else
                                System.out.println("Incorrect choice");
                        }
                        
                        else if (choice == 2) {
                            m.userSub2();
                            System.out.print("\nPlease input: ");
                            choice = in.nextInt();
                            if (choice >= 1 && choice <= 7)
                                iv.sortCars(choice);
                            else
                                System.out.println("Incorrect choice.");
                        }
                        
                        else if (choice == 3)
                            break;
                        else
                            System.out.println("Not a valid option.");
                    } while (choice != 3);
                }
                else if (found == 0) {
                    System.out.println("Invalid ID and Password combination.\n");
                }   
            }
            else if (choice == 2) {
                cu.signUp();
            }
            else if (choice == 3) {
                break;
            }
            else
                System.out.println("\nInvalid option.\n");
        }
    }
}