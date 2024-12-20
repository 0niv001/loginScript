public static void main() {
    Scanner actInput = new Scanner(System.in);
    String action;
    User test = new User("jack", "test");

    do {
        System.out.println("""
        Main Menu
        1. Log in
        2. Sign up
        x. Quit
        
        Choose one of the following:""");
        action = actInput.nextLine().toLowerCase();
        switch (action) {
            case "1":
                if (logIn(test.getUserName(),test.getPassword())) {
                    menuSelection(test);
                } else System.out.println("Username and password not recognised");
                break;
            case "2":
                signUp();
                break;
            case "x":
                System.out.println("Exiting Menu");
                break;
            default:
                System.out.println("Not a valid input, try again");
                action = "";
        }
    } while(action.isEmpty());
}

public static boolean logIn(String user, String pass) {
    String[] id = credentials();
    return user.equals(id[0]) && pass.equals(id[1]);
}

public static void signUp() {
    String[] id = credentials();
    User test = new User(id[0], id[1]);
    System.out.printf("User %s Created\n", test.getUserName());
}


public static void menuSelection(User test) {
    byte selection;
    Scanner menuInput = new Scanner(System.in);
    do {
        System.out.print("""
                User Menu
                1. Print user
                2. Edit user
                3. Remove user
                9. Exit Menu
                Choose one of the options:""");
        try {
            selection = menuInput.nextByte();
            switch (selection) {
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

// Method for changing the details of the current user
public static void changeDetails(User test) {
    Scanner input = new Scanner(System.in);
    System.out.println("What would you like to change?\nType u for username\nType p for password");
    String change = input.next().toLowerCase();
    switch (change) {
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

// Method for getting the username and password of user
public static String[] credentials() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter Username:");
    String username = input.next().toLowerCase();
    System.out.println("Enter Password");
    String password = input.next();
    return new String[]{username, password};
}
