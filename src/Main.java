import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner actInput = new Scanner(System.in);
        byte action;
        User test = new User("jack", "test");

        do {
            System.out.println("Type 1 to log in or 2 to sign up:");
            action = actInput.nextByte();
            switch (action) {
                case 1:
                    boolean validated = logIn(test.getUserName(), test.getPassword());
                    if (validated) {
                        menuSelection(test);
                    } else System.out.println("Username and password not recognised");
                    break;
                case 2:
                    signUp(test);
                    break;
                default:
                    System.out.println("Not a valid input, try again");
            }
        } while (action != 1 || action != 2);
    }

    public static boolean logIn(String user, String pass) {
        Scanner logInput = new Scanner(System.in);
        System.out.println("Enter Username:");
        String username = logInput.next();
        System.out.println("Enter Password:");
        String password = logInput.next();
        if (user.equals(username) && pass.equals(password)) {
            return true;
        } else {
            System.out.println("Invalid credentials");
            return false;
        }
    }

    public static void signUp(User newUser) {
        Scanner signInput = new Scanner(System.in);
        System.out.println("Enter Username:");
        String username = signInput.next().toLowerCase();
        System.out.println("Enter Password:");
        String password = signInput.next();
        newUser = new User(username,password);
        System.out.printf("User %s Created\n", newUser.getUserName());
    }

    public static void menuSelection(User test){
        byte selection;
        Scanner menuInput = new Scanner(System.in);
        do {
            System.out.print("""
                Main Menu
                1. Print user
                2. Edit user
                3. Remove user
                9. Exit Menu
                Choose one of the options:""");
            try {
                selection = menuInput.nextByte();
                switch (selection){
                    case 1:
                        System.out.println("Current user: " + test.getUserName());
                        break;
                    case 2:
                        changeDetails(test);
                        break;
                    case 3:
                            System.out.println("Cannot remove user if not admin");
                        break;
                    case 9:
                        System.out.println("Exiting Menu");
                        break;
                    default:
                        System.out.println("Not a valid input, try again");
                }
            } catch (Exception e) {
                menuInput.nextLine();
                selection = -1;
            }
        } while (selection != 9);
    }
    public static void changeDetails(User test){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to change? type u for username and p for password");
        String change = input.next().toLowerCase();
        switch (change){
            case "u":
                System.out.println("Enter new username:");
                test.setUserName(input.next());
                System.out.println("Username change to: " + test.getUserName());
                break;
            case "p":
                System.out.println("Enter new password:");
                test.setPassword(input.next());
                input.nextLine();
                System.out.println("Password changed");
                break;
            default:
                System.out.println("Not a valid input, try again.");
        }
    }
}
