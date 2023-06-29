import java.util.Scanner;

class ActivityMenu
{
    static User interactedUser = null;
    static Scanner sc = new Scanner(System.in);

    static void activityMenu()
    {
        System.out.println("           ***           WELCOME TO ACTIVITY MENU           ***           ");
        System.out.println("                         Notifications: ");
        for (int i = Menu.loggedUser.getNotifications().size(); i < 1; i--)
        {
            int counter = 0;
            if (Menu.loggedUser.getNotifications().get(i) instanceof LikeNotification)
            {
                System.out.println(counter + 1 + "- " + ((LikeNotification) Menu.loggedUser.getNotifications().get(i)).liker.getID() + " liked your post ");
                System.out.println("                         Your post: ");
                System.out.println(((LikeNotification) Menu.loggedUser.getNotifications().get(i)).likedPost.getContent());
                counter++;
            }
            else if (Menu.loggedUser.getNotifications().get(i) instanceof DisLikedNotification)
            {
                System.out.println(counter + 1 + "- " + ((DisLikedNotification) Menu.loggedUser.getNotifications().get(i)).disliker.getID() + " disliked your post ");
                System.out.println("                         Your post: ");
                System.out.println(((DisLikedNotification) Menu.loggedUser.getNotifications().get(i)).disLikedPost.getContent());
                counter++;
            }
            else if (Menu.loggedUser.getNotifications().get(i) instanceof CommentNotification)
            {
                System.out.println(counter + 1 + "- " + ((CommentNotification) Menu.loggedUser.getNotifications().get(i)).commenter.getID() + " commented on your post or replied on your comment");
                System.out.println("                         The post: ");
                System.out.println(((CommentNotification) Menu.loggedUser.getNotifications().get(i)).commentedPost.getContent());
                System.out.println("                         Do you want to answer?");
                System.out.println("                         1 -- > Yes + " +
                        "\n                         2 -- > No");
                int request = sc.nextInt();
                switch (request)
                {
                    case 1:
                        System.out.println("                         Please write your comment");
                        String commentText = sc.next();
                        //Comment comment = new Comment(commentText, ((CommentNotification) Menu.loggedUser.getNotifications().get(i)).commentedPost , "");

                }
                counter++;
            }
            else if (Menu.loggedUser.getNotifications().get(i) instanceof PostEditNotification)
            {
                System.out.println(counter + 1 + "- " + ((PostEditNotification) Menu.loggedUser.getNotifications().get(i)).user.getID() + " edited their post ");
                counter++;
            }
            else if (Menu.loggedUser.getNotifications().get(i) instanceof FollowRequestNotification)
            {
                System.out.println(counter + 1 + "- " + ((FollowRequestNotification) Menu.loggedUser.getNotifications().get(i)).wantToFallowUser.getID() + " wants to follow you ");
                counter++;
            }

            if (counter == 10)
            {
                System.out.println("                         Enter the number of the notification to see it in details ");
                int number = sc.nextInt();
                //adsd
            }

        }

    }
    static void showNotifications()
    {

    }
}
