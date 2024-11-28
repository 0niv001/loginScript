import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userName;
        String action;
        String password;
        byte menuSelection;
        User newUser = new User();
        User oldUser = new User();

        //Testing
        User adminUser = new Admin("niv", "root");


        //ArrayList<Object> listUsers = new ArrayList<>();
        //listUsers.add(adminUser);
        //listUsers.add(oldUser);

        //TODO:
        //Create method that takes the credentials - less repeated code
        //

        do {
            System.out.println("Type 1 to log in or 2 to sign up:");
            action = input.next();
            switch (action) {
                case "1":
                    System.out.println("Enter Username:");
                    userName = input.next().toLowerCase();
                    System.out.println("Enter Password:");
                    password = input.next();

                    // If there is a user with this name and password in the Array list do the following.
                    // Get username and password using Hashmap??
                    // change code so checks on who the users are fixed.
                    if(oldUser.getUserName().equals(userName) && oldUser.getPassword().equals(password)) {
                        do {
                            System.out.print("""
                                    Main Menu
                                    1. Print user
                                    2. Edit user
                                    3. Remove user
                                    9. Exit program
                                    Choose one of the options:""");
                            try {
                                menuSelection = input.nextByte();
                            } catch (Exception e) {
                                input.nextLine();
                                menuSelection = -1;
                            }
                            switch (menuSelection) {
                                case 1:
                                    if (newUser.getUserName() == null) {
                                        System.out.println("There is no current user");
                                    } else {
                                        System.out.printf("Current user: %s\n", oldUser.getUserName());
                                    }
                                    break;
                                case 2:
                                    System.out.println("What would you like to change? type u for username or p for password");
                                    String toChange = input.next().toLowerCase();
                                    if (toChange.equals("u")) {
                                        System.out.println("Enter new username");
                                        newUser.setUserName(input.next());
                                        System.out.println("Username changed to: " + oldUser.getUserName());
                                    } else if (toChange.equals("p")) {
                                        System.out.println("Enter new password");
                                        oldUser.setPassword(input.next());
                                        input.nextLine();
                                        System.out.println("Password changed");
                                    } else {
                                        System.out.println("Not a valid input");
                                    }
                                    break;
                                case 4:
                                    // Allow only admins to remove users - check for admin attribute in subclass?
                                    break;
                                case 9:
                                    System.out.println("Exiting program");
                                    break;
                                default:
                                    System.out.println("Not a valid input, try again");
                            }
                        } while (menuSelection != 9);
                    }
                    else {
                        System.out.println("Not a valid username and password");
                    }
                    break;
                case "2":
                    System.out.println("Enter Username");
                    userName = input.next();
                    System.out.println("Enter Password");
                    password = input.next();
                    newUser.setUserName(userName);
                    newUser.setPassword(password);
                    System.out.println("User Created");
                    break;
                default:
                    System.out.println("Not a valid input");
            }
        } while (action.isEmpty());
    }
}

