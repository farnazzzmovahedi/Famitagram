import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class HomeMenu
{
    static Scanner sc = new Scanner(System.in);
    static void homeMenu()
    {
        System.out.println("           ***           WELCOME TO HOME MENU!           ***           ");
        System.out.println("                         1 --> CREATE A NEW POST");
        System.out.println("                         2 --> BROWSE MY FEED");
        System.out.println("                         3 --> CREATE A NEW STORY");
        System.out.println("                         4 --> BROWSE STORIES");
        System.out.println("                         4 --> BROWSE MY OWN STORIES");
        System.out.println("                         5 --> SEE WHO HAVE LIKED MY STORIES");
        System.out.println("                         6 --> SEE WHO HAVE DISLIKED MY STORIES");
        System.out.println("                         7 --> BACK");

        int re = sc.nextInt();
        if (re == 1)
        {
            YourPageMenu.addPost();
            System.out.println("done !");
            homeMenu();
        }
        if (re == 2)
        {
            showPost();
            System.out.println("done !");
            homeMenu();
        }
        if (re == 3)
        {
            System.out.println("                         ENTER THE CONTENT OF YOUR STORY PLEASE");
            String content = sc.next();
            Story story = new Story(Menu.loggedUser , content);
            Menu.loggedUser.stories.add(story);
            Lists.allStories.add(story);
            System.out.println("done !");
            homeMenu();
        }
        if (re == 4)
        {
            try
            {
                showStory();
                homeMenu();
            }
            catch (InterruptedException e)
            {
                e.getMessage();
                homeMenu();
            }
        }
        if (re == 5)
        {
            for (int j = 0 ; j < Menu.loggedUser.getStories().size() ; j++)
                for (int k = 0; k < Menu.loggedUser.getStories().get(j).getLikerStory().size() ; k++)
                    System.out.println(Menu.loggedUser.getStories().get(j).getLikerStory().get(k));
            homeMenu();
        }
        if (re == 6)
        {
            for (int j = 0 ; j < Menu.loggedUser.getStories().size() ; j++)
                for (int k = 0; k < Menu.loggedUser.getStories().get(j).getDislikerStory().size() ; k++)
                    System.out.println(Menu.loggedUser.getStories().get(j).getDislikerStory().get(k));
            homeMenu();
        }
        if (re == 7)
        {}
    }
    static void showStory() throws InterruptedException
    {
        System.out.println("           ***           WELCOME TO STORY MENU           ***           ");
        for (int i = 0; i < Menu.loggedUser.getFollowing().size(); i++)
        {
            for (int j = 0 ; j < Menu.loggedUser.getFollowing().get(i).getStories().size() ; j++)
            {
                if (Menu.loggedUser.getFollowing().get(i).getStories().get(j).isSeen() == false)
                {
                    System.out.println(Menu.loggedUser.getFollowing().get(i).getStories().get(j).toString());
                    Menu.loggedUser.getFollowing().get(i).getStories().get(j).setSeen(true);
                    Menu.loggedUser.viewedStories.add(Menu.loggedUser.getFollowing().get(i).getStories().get(j));
                    TimeUnit.SECONDS.sleep(4);
                }
            }
        }
        for (int k = 0 ; k < Lists.allStories.size() ; k++)
        {
            System.out.println("WHAT DO YOU WANNA DO NOW?");
            System.out.println("                         1 --> LIKE A STORY");
            System.out.println("                         2 --> DISLIKE A STORY");
            System.out.println("                         3 --> BACK TO HOME MENU");
            int request = sc.nextInt();
            if (request == 1)
            {
                System.out.println("PLEASE ENTER THE NUMBER OF STORY THAT YOU WANNA LIKE");
                int re = sc.nextInt();
                for (int i = 0; i < Lists.allStories.size(); i++)
                {
                    if (Lists.allStories.get(i).getStoryNumber() == re)
                        likeStory(Lists.allStories.get(i));
                }
            }
            if (request == 2)
            {
                System.out.println("PLEASE ENTER THE NUMBER OF STORY THAT YOU WANNA DISLIKE");
                int re = sc.nextInt();
                for (int i = 0; i < Lists.allStories.size(); i++)
                {
                    if (Lists.allStories.get(i).getStoryNumber() == re)
                        dislikeStory(Lists.allStories.get(i));
                }
            }
            if (request == 3)
            {
                homeMenu();
            }

        }
    }
    static void showPost()
    {

        System.out.println("           ***           WELCOME TO HOME MENU           ***           ");
        for (int i = 0; i < Menu.loggedUser.getFollowing().size(); i++)
        {
            for (int j = 0 ; j < Menu.loggedUser.getFollowing().get(i).getPosts().size() ; j++)
            {
                if (Menu.loggedUser.getFollowing().get(i).getPosts().get(j).isSeen() == false)
                {
                    System.out.println(Menu.loggedUser.getFollowing().get(i).getPosts().get(j).toString());
                    Menu.loggedUser.getFollowing().get(i).getPosts().get(j).setSeen(true);
                    Menu.loggedUser.getViewedPosts().add(Menu.loggedUser.getFollowing().get(i).getPosts().get(j));

                    System.out.println("                         What do you want to do now?");
                    System.out.println("                         1 -- > LIKE THIS POST");
                    System.out.println("                         2 -- > DISLIKE THIS POST");
                    System.out.println("                         3 -- > COMMENT ON THIS POST");
                    System.out.println("                         4 -- > NEXT POST");
                    int request = sc.nextInt();
                    switch (request)
                    {
                        case 1 :
                            like(Menu.loggedUser.getFollowing().get(i).getPosts().get(j));
                            break;
                        case 2 :
                            disLike(Menu.loggedUser.getFollowing().get(i).getPosts().get(j));
                            break;
                        case 3 :
                            comment(Menu.loggedUser.getFollowing().get(i).getPosts().get(j));
                            break;
                        case 4 :
                            break;
                        default:
                            showPost();
                    }
                }
            }
            //main menu
        }

    }
    static void comment(Post post)
    {
        System.out.println("                         Please enter your comment text");
        String commentText = sc.next();
        Comment comment = new Comment(commentText , post , ExploreMenu.interactedUser , Menu.loggedUser);
        CommentNotification commentNotification = new CommentNotification(ExploreMenu.interactedUser , commentText , post , Menu.loggedUser);
        ExploreMenu.interactedUser.getNotifications().add(commentNotification);
        post.getCommenters().add(Menu.loggedUser);
        Menu.loggedUser.getCommentedPosts().add(post);
        post.getComments().add(comment);
        System.out.println("                         You commented <" + comment.commentText + "> on this post!");

    }
    static void like(Post post)
    {
        LikeNotification likeNotification = new LikeNotification(ExploreMenu.interactedUser , post , Menu.loggedUser);
        ExploreMenu.interactedUser.getNotifications().add(likeNotification);
        post.getLikers().add(Menu.loggedUser);
        Menu.loggedUser.getLikedPosts().add(post);
        System.out.println("                         You liked this post!");
    }
    static void disLike(Post post)
    {
        DisLikedNotification DisLikedNotification = new DisLikedNotification(ExploreMenu.interactedUser , post , Menu.loggedUser);
        ExploreMenu.interactedUser.getNotifications().add(DisLikedNotification);
        post.getDislikers().add(Menu.loggedUser);
        Menu.loggedUser.getDislikedPosts().add(post);
        System.out.println("                         You disliked this post!");
    }
    static void dislikeStory(Story story)
    {
        DislikedStoryNotification dislikedStoryNotification = new DislikedStoryNotification(ExploreMenu.interactedUser , story , Menu.loggedUser);
        ExploreMenu.interactedUser.getNotifications().add(dislikedStoryNotification);
        story.getDislikerStory().add(Menu.loggedUser);
        Menu.loggedUser.getDislikedStories().add(story);
        System.out.println("                         You disliked this story!");
    }
    static void likeStory(Story story)
    {
        LikedStoryNotification likedStoryNotification = new LikedStoryNotification(ExploreMenu.interactedUser , story , Menu.loggedUser);
        ExploreMenu.interactedUser.getNotifications().add(likedStoryNotification);
        story.getLikerStory().add(Menu.loggedUser);
        Menu.loggedUser.getLikedStories().add(story);
        System.out.println("                         You liked this story!");
    }
}
