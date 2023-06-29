import java.util.Scanner;

public class ExploreMenu
{
    static User interactedUser = null;
    static Scanner sc = new Scanner(System.in);

    static void exploreMenu()
    {
        System.out.println("           ***           WELCOME TO EXPLORE MENU           ***           ");
        System.out.println("                         What do you want to do here?");
        System.out.println("                         1 -- > SEARCH FOR A USER");
        System.out.println("                         2 -- > SEE THE EXPLORE");
        System.out.println("                         3 -- > BACK TO PREVIOUS MENU");

        int request = sc.nextInt();
        switch (request)
        {
            case 1:
                search();
                break;
            case 2:
                explore();
                break;
            case 3:
                UserCommands.userCommandsMenu();
                break;
            default:
                System.out.println("                         Please enter the correct number!");
        }
    }
    static void search()
    {
        System.out.println("                         Please enter the ID you want to search for");
        String ID = sc.next();
        boolean foundID = false;
        for (int i = 0; i < Lists.getUsers().size(); i++)
            if (ID.equals(Lists.getUsers().get(i).getID()))
            {
                foundID = true;
                ExploreMenu.interactedUser = Lists.getUsers().get(i);
                System.out.println("                         The information of their page: ");
                System.out.println("name --> " + ExploreMenu.interactedUser.getFirstName() + "   ID --> " + ExploreMenu.interactedUser.getID() + "Bio -- > " + ExploreMenu.interactedUser.getBio());

                boolean isFollowing = false;
                for (int j = 0; j < Menu.loggedUser.getFollowing().size(); j++)
                    if (ExploreMenu.interactedUser.equals(Menu.loggedUser.getFollowing().get(j)))
                    {
                        isFollowing = true;
                    }
                if (isFollowing)
                {
                    System.out.println("                         Posts: ");
                    for (int  j = 0; j < ExploreMenu.interactedUser.getPosts().size(); j++)
                        System.out.println(j+1 + "-" + ExploreMenu.interactedUser.getPosts().get(j).toString());

                    System.out.println("                         What do you want to do here?");
                    System.out.println("                         1 -- > LIKE");
                    System.out.println("                         2 -- > DISLIKE");
                    System.out.println("                         3 -- > COMMENT");
                    System.out.println("                         4 -- > SAVE");
                    System.out.println("                         5 -- > DIRECT");
                    System.out.println("                         6 -- > BACK TO EXPLORE MENU");
                    int request = sc.nextInt();

                    System.out.println("                         Please select a post with its number");
                    int number = sc.nextInt();
                    ExploreMenu.interactedUser.getPosts().get(number-1).toString();

                    switch (request)
                    {
                        case 1:
                            like(ExploreMenu.interactedUser.getPosts().get(number-1));
                            break;
                        case 2:
                            disLike(ExploreMenu.interactedUser.getPosts().get(number-1));
                            break;
                        case 3:
                            comment(ExploreMenu.interactedUser.getPosts().get(number-1));
                            break;
                        case 4:
                            save(ExploreMenu.interactedUser.getPosts().get(number-1));
                            break;
                        case 5:
                            direct();
                            break;
                        case 6:
                            exploreMenu();
                            break;
                        default:
                            System.out.println("                         Please enter the correct number!");
                            search();
                    }
                }
                else if (!isFollowing)
                {
                    if (ExploreMenu.interactedUser.isPrivate())
                    {
                        System.out.println("                         This page is private!" +
                                "\n                         you have to send a follow request to get interaction with him/her" +
                                "\n                         Do you want to send it?");
                        System.out.println("                         1 -- > Yes + " +
                                "\n                         2 -- > No");
                        int request = sc.nextInt();
                        switch (request)
                        {
                            case 1:
                                FollowRequestNotification reqNotification = new FollowRequestNotification(Menu.loggedUser, ExploreMenu.interactedUser);
                                ExploreMenu.interactedUser.getNotifications().add(reqNotification);
                                ExploreMenu.interactedUser.getFollowRequests().add(Menu.loggedUser);
                                exploreMenu();
                                break;
                            case 2:
                                exploreMenu();
                                break;
                            default:
                                System.out.println("                         Please enter the correct number!");
                                search();
                        }

                    }
                    else if (!ExploreMenu.interactedUser.isPrivate())
                    {
                        System.out.println("                         Posts: ");
                        for (int  j = 0; j < ExploreMenu.interactedUser.getPosts().size(); j++)
                            System.out.println(j+1 + "-" + ExploreMenu.interactedUser.getPosts().get(j).toString());

                        System.out.println("                         Please select a post with its number");
                        int number = sc.nextInt();
                        ExploreMenu.interactedUser.getPosts().get(number-1).toString();

                        System.out.println("                         What do you want to do here?");
                        System.out.println("                         1 -- > LIKE");
                        System.out.println("                         2 -- > DISLIKE");
                        System.out.println("                         3 -- > COMMENT");
                        System.out.println("                         4 -- > SAVE");
                        System.out.println("                         5 -- > DIRECT");
                        System.out.println("                         6 -- > BACK TO EXPLORE MENU");
                        int request = sc.nextInt();
                        switch (request)
                        {
                            case 1:
                                like(ExploreMenu.interactedUser.getPosts().get(number-1));
                                break;
                            case 2:
                                disLike(ExploreMenu.interactedUser.getPosts().get(number-1));
                                break;
                            case 3:
                                comment(ExploreMenu.interactedUser.getPosts().get(number-1));
                                break;
                            case 4:
                                save(ExploreMenu.interactedUser.getPosts().get(number-1));
                                break;
                            case 5:
                                direct();
                                break;
                            case 6:
                                exploreMenu();
                                break;
                            default:
                                System.out.println("                         Please enter the correct number!");
                                search();
                        }
                    }
                }
            }
        if (!foundID)
        {
            System.out.println("                         There is no ID like something you entered!");
            exploreMenu();
        }
    }
    static void explore()
    {
        System.out.println("                         What is the subject you want to see in explore?");
        System.out.println("                         Choose the closest subject to your mind:");
        System.out.println("                         1-NATURE , 2-FASHION , 3-LANGUAGE , 4-ANIMAL , 5-SPORT , 6-FOOD , 7-ENTERTAINMENT");
        int subject = sc.nextInt();
        switch (subject)
        {
            case 1:
                for (int i = 0; i < Lists.getExplorePosts().size(); i++)
                    if (Lists.getExplorePosts().get(i).getCategory().equals(Categories.NATURE))
                        System.out.println(Lists.getExplorePosts().get(i).getContent());
                break;
            case 2:
                for (int i = 0; i < Lists.getExplorePosts().size(); i++)
                    if (Lists.getExplorePosts().get(i).getCategory().equals(Categories.FASHION))
                        System.out.println(Lists.getExplorePosts().get(i).getContent());
                break;
            case 3:
                for (int i = 0; i < Lists.getExplorePosts().size(); i++)
                    if (Lists.getExplorePosts().get(i).getCategory().equals(Categories.LANGUAGE))
                        System.out.println(Lists.getExplorePosts().get(i).getContent());
                break;
            case 4:
                for (int i = 0; i < Lists.getExplorePosts().size(); i++)
                    if (Lists.getExplorePosts().get(i).getCategory().equals(Categories.ANIMAL))
                        System.out.println(Lists.getExplorePosts().get(i).getContent());
                break;
            case 5:
                for (int i = 0; i < Lists.getExplorePosts().size(); i++)
                    if (Lists.getExplorePosts().get(i).getCategory().equals(Categories.SPORT))
                        System.out.println(Lists.getExplorePosts().get(i).getContent());
                break;
            case 6:
                for (int i = 0; i < Lists.getExplorePosts().size(); i++)
                    if (Lists.getExplorePosts().get(i).getCategory().equals(Categories.FOOD))
                        System.out.println(Lists.getExplorePosts().get(i).getContent());
                break;
            case 7:
                for (int i = 0; i < Lists.getExplorePosts().size(); i++)
                    if (Lists.getExplorePosts().get(i).getCategory().equals(Categories.ENTERTAINMENT))
                        System.out.println(Lists.getExplorePosts().get(i).getContent());
                break;
        }
        exploreMenu();

    }
    static void like(Post post)
    {
        LikeNotification likeNotification = new LikeNotification(ExploreMenu.interactedUser , post , Menu.loggedUser);
        ExploreMenu.interactedUser.getNotifications().add(likeNotification);
        post.getLikers().add(Menu.loggedUser);
        Menu.loggedUser.getLikedPosts().add(post);
        System.out.println("                         You liked this post!");
        exploreMenu();
    }
    static void comment(Post post)
    {
        System.out.println("                         Please enter your comment text");
        String commentText = sc.next();
        Comment comment = new Comment(commentText , post , ExploreMenu.interactedUser , Menu.loggedUser);
        CommentNotification commentNotification = new CommentNotification(interactedUser , commentText , post , Menu.loggedUser);
        ExploreMenu.interactedUser.getNotifications().add(commentNotification);
        post.getCommenters().add(Menu.loggedUser);
        Menu.loggedUser.getCommentedPosts().add(post);
        post.getComments().add(comment);
        System.out.println("                         You commented <" + comment.commentText + "> on this post!");
        exploreMenu();
    }
    static void disLike(Post post)
    {
        DisLikedNotification disLikedNotification = new DisLikedNotification(interactedUser , post , Menu.loggedUser);
        ExploreMenu.interactedUser.getNotifications().add(disLikedNotification);
        post.getDislikers().add(Menu.loggedUser);
        Menu.loggedUser.getDislikedPosts().add(post);
        System.out.println("                         You disliked this post!");
        exploreMenu();

    }
    static void save(Post post)
    {
        Menu.loggedUser.getSavedPosts().add(post);
        System.out.println("                         You saved this post!");
        exploreMenu();

    }
    static void direct() {
        int z = 0;
        for (DirectMessage i : Lists.getMessages()) {
            if ((i.getSender().equals(Menu.loggedUser) && i.getReceiver().equals(ExploreMenu.interactedUser)) ||
                    (i.getSender().equals(ExploreMenu.interactedUser) && i.getReceiver().equals(Menu.loggedUser))) {
                System.out.println(i.getSender().getFirstName() + " : " + i.getMessage());
                z++;
                if (z == 10)
                    break;
            }
        }
        Boolean texting = true;
        while (texting)
        {
            System.out.println("                         Please enter your message text");
            String message = sc.next();
            System.out.println("                         Do you want to send this message or add something or cancel it?");
            System.out.println("                         1 -- > SEND");
            System.out.println("                         2 -- > ADD SOMETHING");
            System.out.println("                         3 -- > CANCEL");
            int request = sc.nextInt();
            DirectMessage directMessage;
            switch (request)
            {
                case 1:
                    directMessage = new DirectMessage(Menu.loggedUser, ExploreMenu.interactedUser, message);
                    Lists.getMessages().add(directMessage);
                    ExploreMenu.interactedUser.getNotifications().add(new MessageNotification(directMessage));
                    System.out.println(                         "Message was sent successfully.");
                    texting = false;
                    break;
                case 2:
                    directMessage = new DirectMessage(Menu.loggedUser, ExploreMenu.interactedUser, message);
                    Lists.getMessages().add(directMessage);
                    ExploreMenu.interactedUser.getNotifications().add(new MessageNotification(directMessage));
                    break;
                case 3:
                    System.out.println(                         "Cancelled successfully.");
                    texting = false;
                    break;
            }
        }
        exploreMenu();
    }
}
