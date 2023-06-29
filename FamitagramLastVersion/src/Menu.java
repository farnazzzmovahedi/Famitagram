import java.util.Scanner;

abstract class Menu
{
    static User loggedUser = null ;


    public static void mainMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("           ***           WELCOME TO FAMITAGRAM!           ***           ");
        System.out.println("                         1 --> LOG INTO EXISTING ACCOUNT");
        System.out.println("                         2 --> CREATE NEW ACCOUNT");
        System.out.println("                         3 --> EXIT");
        int request = sc.nextInt();
        switch (request)
        {
            case 1:
                loginMenu();
                break;
            case 2:
                createAccountMenu();
                break;
            case 3:
                return;
            default:
                System.out.println("                         please enter the number correctly");
                mainMenu();
        }
    }
    public static void loginMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("           ***           WELCOME TO LOG IN MENU           ***           ");

        System.out.println("                         Please enter your ID");
        String ID = sc.next();
        System.out.println("                         Please enter your password");
        String password = sc.next();
        boolean found = false;
        for (User temp : Lists.getUsers())
            if (temp.getID().equals(ID) && temp.getPassword().equals(password))
            {
                found = true;
                loggedUser = temp;
                System.out.println("                         Logged in successfully.");
                UserCommands.userCommandsMenu();
            }
        if (found)
        {
            System.out.println("                         The ID or the password is not correct!");
            loginMenu();
        }
    }
    public static void createAccountMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("           ***           WELCOME TO SIGN UP PANEL           ***           ");
        System.out.println("                         Please enter your name");
        String  firstName = sc.next();
        System.out.println("                         Please enter your lastname");
        String lastName = sc.next();
        System.out.println("                         Please enter your birthdate");
        String birthDate = sc.next();
        System.out.println("                         Please enter your phone number");
        String phoneNumber = sc.next();
        System.out.println("                         Please enter your password");
        String password = sc.next();
        System.out.println("                         Please enter your ID");
        String ID = sc.next();
        boolean sameID = true;
        for (int i = 0; i < Lists.getUsers().size(); i++)
            if (!(Lists.getUsers().get(i).getID().equals(ID)))
            {
                sameID = false;
                System.out.println("                         Please enter your bio");
                String bio = sc.next();
                System.out.println("                         Press 1 if you would rather your account be public " +
                        "\n                         or press 2 if you would rather it be private");
                int accType = sc.nextInt();
                boolean isPrivate = true;
                switch (accType)
                {
                    case 1:
                        isPrivate = false ;
                        break;
                    case 2:
                        isPrivate = true ;
                        break;
                    default:
                        System.out.println("                         please enter the number correctly");
                        createAccountMenu();
                }

                User newUser = new User(firstName, lastName, birthDate, phoneNumber, password, ID, bio, isPrivate);
                Lists.getUsers().add(newUser);
                System.out.println("                         New account was created successfully.");
                Menu.loginMenu();
            }
        if (sameID)
        {
            System.out.println("                         Your chosen ID is not unique! Please try again ");
            createAccountMenu();
        }

    }
}
