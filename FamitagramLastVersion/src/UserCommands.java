import java.util.Scanner;

public class UserCommands
{
    static Scanner sc = new Scanner(System.in);

    public static void userCommandsMenu()
    {
        System.out.println("           ***           WELCOME TO USER COMMAND MENU           ***           ");
        System.out.println("                         Where menu do you want to go now?");
        System.out.println("                         1 -- > YOUR PAGE");
        System.out.println("                         2 -- > ACTIVITY");
        System.out.println("                         3 -- > EXPLORE");
        System.out.println("                         4 -- > HOME");
        System.out.println("                         5 -- > BACK TO MAIN MENU");
        int request = sc.nextInt();
        switch (request)
        {
            case 1:
                YourPageMenu.yourPageMenu();
                break;
            case 2:
                ActivityMenu.activityMenu();
                break;
            case 3:
                ExploreMenu.exploreMenu();
                break;
            case 4:
                HomeMenu.homeMenu();
                break;
            case 5:
                Menu.mainMenu();
                break;
            default:
                System.out.println("                         Please enter the correct number!");
        }
    }

}