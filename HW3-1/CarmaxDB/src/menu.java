public class menu {
    //
    public void welcome() {
        System.out.println("Welcome to Carmax!\n");
        System.out.println("1.Log in");
        System.out.println("2.Sign up");
        System.out.println("3.Exit\n");
    }
    
    public void wBackUser() {
        System.out.println("1.Display inventory");
        System.out.println("2.Sort cars");
        System.out.println("3.Log out\n");
    }
    
    public void wBackAdmin() {
        System.out.println("1.Display inventory");
        System.out.println("2.Add Car");
        System.out.println("3.Delete Car");
        System.out.println("4.Update Car");
        System.out.println("5.Display Users");
        System.out.println("6.Add User");
        System.out.println("7.Delete User");
        System.out.println("8.Update User");
        System.out.println("9.Log out\n");
    }
    
    public void userSub1() {
        System.out.println("1.New");
        System.out.println("2.Used");
    }
    
    public void userSub2() {
        System.out.println("1.Sort by VIN");
        System.out.println("2.Sort by Brand");
        System.out.println("3.Sort by Model");
        System.out.println("4.Sort by Year");
        System.out.println("5.Sort by Mileage");
        System.out.println("6.Sort by Price");
        System.out.println("7.Sort by Color");
    }
    
    public void adminSub4() {
        System.out.println("1.Update brand");
        System.out.println("2.Update model");
        System.out.println("3.Update year");
        System.out.println("4.Update mileage");
        System.out.println("5.Update price");
        System.out.println("6.Update color");
    }
    
    public void adminSub8() {
        System.out.println("1.Update password");
        System.out.println("2.Update first name");
        System.out.println("3.Update last name");
        System.out.println("4.Update email");
    }
}