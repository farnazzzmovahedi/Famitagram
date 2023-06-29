import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class YourPageMenu
{
    static User interactedUser = null;
    static Scanner sc = new Scanner(System.in);

    static void yourPageMenu()
    {
        System.out.println("           ***           WELCOME TO YOUR PAGE MENU           ***           ");
        System.out.println("                         What do you want to do here?");
        System.out.println("                         1 -- > ADD POST");
        System.out.println("                         2 -- > REMOVE POST");
        System.out.println("                         3 -- > EDIT POST");
        System.out.println("                         4 -- > SHOW YOUR POSTS");
        System.out.println("                         5 -- > SHOW SAVED POSTS");
        System.out.println("                         6 -- > EDIT INFORMATION");
        System.out.println("                         7 -- > FOLLOWERS AND FOLLOWINGS");
        System.out.println("                         8 -- > SHOW YOUR POSTS IN SORT");
        System.out.println("                         9 -- > BACK TO PREVIOUS MENU");
        int request = sc.nextInt();
        switch (request)
        {
            case 1:
                addPost();
                break;
            case 2:
                removePost();
                break;
            case 3:
                editPost();
                break;
            case 4:
                showYourPosts();
                break;
            case 5:
                showSavedPosts();
                break;
            case 6:
                editInfo();
                break;
            case 7:
                followersAndFollowing();
                break;
            case 8:
                showYourPostsInSort();
                break;
            case 9:
                UserCommands.userCommandsMenu();
                break;
            default:
                System.out.println("                         Please enter the correct number!");
        }
    }
    static void editInfo()
    {
        System.out.println("                         Your information: ");
        System.out.println(Menu.loggedUser.toString());
        System.out.println("                         Enter your new information");

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
        while (sameID)
        {
            for (int i = 0; i < Lists.getUsers().size(); i++)
            {
                if (Lists.getUsers().get(i).getID().equals(ID))
                {
                    System.out.println("                         Your chosen ID is not unique! Please choose another one ");
                    ID = sc.next();
                    break;
                }
                sameID = false;
            }
        }

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
                editInfo();
        }
        Menu.loggedUser.setFirstName(firstName);
        Menu.loggedUser.setLastName(lastName);
        Menu.loggedUser.setBirthDate(birthDate);
        Menu.loggedUser.setPhoneNumber(phoneNumber);
        Menu.loggedUser.setPassword(password);
        Menu.loggedUser.setBio(bio);
        Menu.loggedUser.setPrivate(isPrivate);
        System.out.println("                         Your information edited successfully! ");
        yourPageMenu();

    }
    static void addPost()
    {
        System.out.println("                         Write your post's content.");
        String content = sc.next();
        sc.nextLine();
        System.out.println("                         What is your post's total subject?");
        System.out.println("                         Choose the closest subject to your post:");
        System.out.println("                         NATURE , FASHION , LANGUAGE , ANIMAL , SPORT , FOOD , ENTERTAINMENT");
        if (!Menu.loggedUser.isPrivate())
            System.out.println("                         *The total subject of your post will be added to a special category for the explore!*");
        String category = sc.next();
        Post newPost = new Post(Menu.loggedUser , Categories.valueOf(category) , content);
        Menu.loggedUser.getPosts().add(newPost);
        System.out.println("                         Posted successfully.");
        YourPageMenu.yourPageMenu();
    }

    static void removePost()
    {
        System.out.println("                         Enter the number of the post you are going to delete.");
        System.out.println("                         Your posts: ");
        for (int i = 0; i < Menu.loggedUser.getPosts().size(); i++)
            System.out.println(i+1 + "-" + Menu.loggedUser.getPosts().get(i).toString());

        int number = sc.nextInt();
        Menu.loggedUser.getPosts().remove(number-1);
        System.out.println("                         The post was deleted successfully.");
        YourPageMenu.yourPageMenu();
    }

    static void editPost()
    {

        System.out.println("                         Enter the number of the post you are going to edit.");
        for (int i = 0; i < Menu.loggedUser.getPosts().size(); i++)
            System.out.println(i+1 + "-" + Menu.loggedUser.getPosts().get(i).toString());

        int j = sc.nextInt();
        Menu.loggedUser.getPosts().get(j-1).getPreviousPosts().add(Menu.loggedUser.getPosts().get(j-1));
        System.out.println("                         Write your post's new content.");
        String newContent = sc.next();
        sc.nextLine();
        System.out.println("                         Did your post's total subject change?");
        System.out.println("                         1 -- > Yes + " +
                "\n                         2 -- > No");
        int request = sc.nextInt();
        switch (request)
        {
            case 1:
                System.out.println("                         Choose the closest subject to your post:");
                System.out.println("                         NATURE , FASHION , LANGUAGE , ANIMAL , SPORT , FOOD , ENTERTAINMENT");
                if (!Menu.loggedUser.isPrivate())
                    System.out.println("                         *The total subject of your post will be added to a special category for the explore!*");
                String category = sc.next();
                Post editedPost1 = new Post(Menu.loggedUser , Categories.valueOf(category) , newContent);
                PostEditNotification newPostEditNotification1 = new PostEditNotification(Menu.loggedUser , Menu.loggedUser.getPosts().get(j-1), editedPost1 , interactedUser);
                Menu.loggedUser.getPosts().set(j-1, editedPost1);
                for (User i : Menu.loggedUser.getPosts().get(j-1).getLikers())
                    i.getNotifications().add(newPostEditNotification1);
                for (User i : Menu.loggedUser.getPosts().get(j-1).getDislikers())
                    i.getNotifications().add(newPostEditNotification1);
                for (User i : Menu.loggedUser.getPosts().get(j-1).getCommenters())
                    i.getNotifications().add(newPostEditNotification1);
                System.out.println("                         The post was edited successfully.");
                YourPageMenu.yourPageMenu();
                break;
            case 2:
                Post editedPost2 = new Post(Menu.loggedUser , Menu.loggedUser.getPosts().get(j-1).getCategory() , newContent);
                PostEditNotification newPostEditNotification2 = new PostEditNotification(Menu.loggedUser , Menu.loggedUser.getPosts().get(j-1), editedPost2 , interactedUser);
                Menu.loggedUser.getPosts().set(j-1, editedPost2);
                for (User i : Menu.loggedUser.getPosts().get(j-1).getLikers())
                    i.getNotifications().add(newPostEditNotification2);
                for (User i : Menu.loggedUser.getPosts().get(j-1).getDislikers())
                    i.getNotifications().add(newPostEditNotification2);
                for (User i : Menu.loggedUser.getPosts().get(j-1).getCommenters())
                    i.getNotifications().add(newPostEditNotification2);
                System.out.println("                         The post was edited successfully.");
                YourPageMenu.yourPageMenu();
                break;
            default:
                System.out.println("                         Please enter the correct number!");
        }

    }
    static void showYourPosts()
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Menu.loggedUser.getPosts().size(); i++)
        {
            System.out.println(i+1 + "-" + Menu.loggedUser.getPosts().get(i).getContent());
        }
        System.out.println("                         Enter the number of the post that you want to see in details");
        int postNumber = sc.nextInt();
        System.out.println(Menu.loggedUser.getPosts().get(postNumber-1).toString());


        System.out.println("                         What do you want to do? " +
                "\n                         1 -- > See the ID of the people who have liked " +
                "\n                         2 -- > See the ID of the people who have commented " +
                "\n                         3 -- > Back to the previous menu ");
        int request = sc.nextInt();
        switch (request)
        {
            case 1:
                System.out.println("                         Post: ");
                System.out.println(Menu.loggedUser.getPosts().get(postNumber - 1).getContent());
                System.out.println("                         People who have liked: ");
                for (User i : Menu.loggedUser.getPosts().get(postNumber - 1).getLikers())
                {
                    System.out.println(i.getID());
                }
                YourPageMenu.yourPageMenu();
            case 2:
                System.out.println("                         Post: ");
                System.out.println(Menu.loggedUser.getPosts().get(postNumber - 1).getContent());
                System.out.println("                         People who have commented");
                for (User i : Menu.loggedUser.getPosts().get(postNumber - 1).getCommenters())
                {
                    System.out.println(i.getID());
                }
                System.out.println("                         Do you want to see the comments too?");
                System.out.println("                         1 -- > Yes + " +
                        "\n                         2 -- > No");
                int request2 = sc.nextInt();
                switch (request2)
                {
                    case 1:
                        System.out.println("                         Post: ");
                        System.out.println(Menu.loggedUser.getPosts().get(postNumber - 1).getContent());
                        System.out.println("                         Comments: ");
                        System.out.println("--------------------------------------------------------------------");
                        for (Comment i : Menu.loggedUser.getPosts().get(postNumber - 1).getComments())
                        {
                            System.out.println(i.commentingUser.getID() + ": " + i.commentText);
                            System.out.println("--------------------------------------------------------------------");
                        }
                        System.out.println("                         Do you want to answer a comment too?");
                        System.out.println("                         1 -- > Yes + " +
                                "\n                         2 -- > No");
                        int request3 = sc.nextInt();
                        switch (request3)
                        {
                            case 1:
                                System.out.println("                         enter the ID of the person you want to answer to their comment");
                                String ID = sc.next();
                                for (int i = 0; i < Lists.getUsers().size(); i++)
                                {
                                    if (Lists.getUsers().get(i).getID().equals(ID))
                                    {
                                        interactedUser = Lists.getUsers().get(i);
                                        System.out.println("                         Please enter your comment text");
                                        String commentText = sc.next();
                                        Comment comment = new Comment(commentText , Menu.loggedUser.getPosts().get(postNumber - 1) , Menu.loggedUser , YourPageMenu.interactedUser);
                                        CommentNotification commentNotification = new CommentNotification(YourPageMenu.interactedUser , commentText , Menu.loggedUser.getPosts().get(postNumber - 1) , Menu.loggedUser);
                                        YourPageMenu.interactedUser.getNotifications().add(commentNotification);
                                        Menu.loggedUser.getPosts().get(postNumber - 1).getComments().add(comment);
                                        System.out.println("                         You commented <" + comment.commentText + "> on this post!");
                                        yourPageMenu();
                                    }
                                }
                                break;
                            case 2:
                                yourPageMenu();
                                break;
                            default:
                                System.out.println("                         Please enter the correct number!");
                        }
                    case 2:
                        System.out.println("                         do you want to go back to the main menu or the previous menu?");
                        System.out.println("                         1 -- > Main menu + " +
                                "\n                         2 -- > Previous menu");
                        int request4 = sc.nextInt();
                        switch (request4)
                        {
                            case 1:
                                yourPageMenu();
                                break;
                            case 2:
                                showYourPosts();
                                break;
                            default:
                                System.out.println("                         Please enter the correct number!");
                        }
                    default:
                        System.out.println("                         Please enter the correct number!");
                }
            case 3:
                showYourPosts();
                break;
            default:
                System.out.println("                         Please enter the correct number!");
        }

    }
    static void showSavedPosts()
    {
        for (int i = 0; i < Menu.loggedUser.getSavedPosts().size(); i++)
            System.out.println(i+1 + "-" + Menu.loggedUser.getSavedPosts().get(i).getContent());
        System.out.println("                         Enter the number of the post that you want to see in details");
        int postNumber = sc.nextInt();
        System.out.println(Menu.loggedUser.getPosts().get(postNumber-1).toString());

        yourPageMenu();
    }
    static void followersAndFollowing()
    {
        System.out.println("                         What do you want to see here?");
        System.out.println("                         1 -- > YOUR FOLLOWINGS THAT DO NOT FOLLOW YOU BACK");
        System.out.println("                         2 -- > YOUR FOLLOWERS THAT YOU DO NOT FOLLOW THEM");
        System.out.println("                         3 -- > USERS BOTH IN YOUR FOLLOWERS AND FOLLOWINGS LIST");
        System.out.println("                         4 -- > MISSED FOLLOWERS");
        System.out.println("                         5 -- > MISSED FOLLOWINGS");
        System.out.println("                         6 -- > SHOW POSTS SORTED BY LIKES NUMBER");
        System.out.println("                         7 -- > SHOW POSTS SORTED BY COMMENTS NUMBER");
        System.out.println("                         8 -- > SHOW MY MOST DISLIKED POST");
        System.out.println("                         9 -- > THE BEST FOLLOWER AT LIKING");
        System.out.println("                         10 -- > THE WORST FOLLOWER AT LIKING");
        System.out.println("                         11 -- > THE BEST FOLLOWER AT COMMENTING");
        System.out.println("                         12 -- > THE WORST FOLLOWER AT COMMENTING");
        if (!Menu.loggedUser.isPrivate())
            System.out.println("                         13 -- > FOLLOWERS AND LIKERS WHO DO NOT FOLLOW ME");
        System.out.println("                         14 -- > SUGGESTIONS");

        int request = sc.nextInt();

        switch (request) {
            case 1:
                for (User i : Menu.loggedUser.getFollowing())
                    if (!i.getFollowing().contains(Menu.loggedUser))
                        System.out.println("                         ID: " + i.getID());
                break;
            case 2:
                for (User i : Menu.loggedUser.getFollowers())
                    if (!Menu.loggedUser.getFollowing().contains(i))
                        System.out.println("                         ID: " + i.getID());
                break;
            case 3:
                for (User i : Menu.loggedUser.getFollowers())
                    if (Menu.loggedUser.getFollowing().contains(i))
                        System.out.println("                         ID: " + i.getID());
                break;
            case 4:
                for (User i : Menu.loggedUser.getPreviousFollowers())
                    if (!Menu.loggedUser.getFollowers().contains(i))
                        System.out.println("                         ID: " + i.getID());
                Menu.loggedUser.setPreviousFollowers(Menu.loggedUser.getFollowers());
                break;
            case 5:
                ArrayList<User> followerAndFollowings = new ArrayList<>();
                for (User i : Menu.loggedUser.getPreviousFollowings())
                    if (!Menu.loggedUser.getFollowing().contains(i)) {
                        System.out.println("                         ID: " + i.getID());
                        followerAndFollowings.add(i);
                    }
                break;
            case 6:
                ArrayList<Post> sortedPostsByLike = Menu.loggedUser.getPosts();
                for (int i = 0; i < sortedPostsByLike.size() - 1; i++)
                    for (int j = 0; j < sortedPostsByLike.size() - i - 1; j++)
                        if (sortedPostsByLike.get(j).getLikers().size() < sortedPostsByLike.get(j + 1).getLikers().size())
                            Collections.swap(sortedPostsByLike, j, j + 1);
                for (Post i : sortedPostsByLike)
                    System.out.println("                         Post : " + i.getContent() + "     Likes number : " + i.getLikers().size());
                break;
            case 7:
                ArrayList<Post> sortedPostsByComment = Menu.loggedUser.getPosts();
                for (int i = 0; i < sortedPostsByComment.size() - 1; i++)
                    for (int j = 0; j < sortedPostsByComment.size() - i - 1; j++)
                        if (sortedPostsByComment.get(j).getLikers().size() < sortedPostsByComment.get(j + 1).getLikers().size())
                            Collections.swap(sortedPostsByComment, j, j + 1);
                for (Post i : sortedPostsByComment)
                    System.out.println("                         Post : " + i.getContent() + "     Comments number : " + i.getComments().size());
                break;
            case 8:
                Post mostDislikedPost = Menu.loggedUser.getPosts().get(0);
                for (Post i : Menu.loggedUser.getPosts())
                    if (i.getDislikers().size() > mostDislikedPost.getDislikers().size()) {
                        mostDislikedPost = i;
                    }
                System.out.println("                         Post : " + mostDislikedPost.getContent() + "     Dislikes number : " + mostDislikedPost.getDislikers().size());
                break;
            case 9:
                User bestLiker = null;
                int bestLikersLikesNumber = 0;
                int followersLikesNumber = 0;
                for (User follower : Menu.loggedUser.getFollowers())
                {
                    for (Post post : Menu.loggedUser.getPosts())
                        if (post.getLikers().contains(follower))
                            followersLikesNumber++;
                    if (followersLikesNumber > bestLikersLikesNumber)
                    {
                        bestLiker = follower;
                        bestLikersLikesNumber = followersLikesNumber;
                    }
                }
                System.out.println("                         Best liker : " + bestLiker.getID() + "     Liked posts number : " + bestLikersLikesNumber);
                break;
            case 10:
                for (User follower : Menu.loggedUser.getFollowers())
                {
                    Boolean hasLiked = false;
                    for (Post post : Menu.loggedUser.getPosts())
                        if (post.getLikers().contains(follower))
                        {
                            hasLiked = true;
                            break;
                        }
                    if (!hasLiked)
                        System.out.println("                         " + follower.getID());
                }
                break;
            case 11:
                User bestCommenter = null;
                int bestCommentersCommentsNumber = 0;
                int followersCommentsNumber = 0;
                for (User follower : Menu.loggedUser.getFollowers())
                {
                    for (Post post : Menu.loggedUser.getPosts())
                        if (post.getCommenters().contains(follower))
                            followersCommentsNumber++;
                    if (followersCommentsNumber > bestCommentersCommentsNumber)
                    {
                        bestCommenter = follower;
                        bestCommentersCommentsNumber = followersCommentsNumber;
                    }
                }
                System.out.println("                         Best commenter : " + bestCommenter.getID() + "     Commented posts number : " + bestCommentersCommentsNumber);
                break;
            case 12:
                for (User follower : Menu.loggedUser.getFollowers())
                {
                    Boolean hasCommented = false;
                    for (Post post : Menu.loggedUser.getPosts())
                        if (post.getCommenters().contains(follower))
                        {
                            hasCommented = true;
                            break;
                        }
                    if (!hasCommented)
                        System.out.println("                         " + follower.getID());
                }
                break;
            case 13:
                if (Menu.loggedUser.isPrivate())
                    System.out.println("                         This feature is only for public pages.");
                else
                {
                    for (Post post : Menu.loggedUser.getPosts())
                    {
                        for (User liker : post.getLikers())
                            if (!Menu.loggedUser.getFollowers().contains(liker))
                                System.out.println("                         " + liker.getID());

                        for (User commenter : post.getCommenters())
                            if (!Menu.loggedUser.getFollowers().contains(commenter))
                                System.out.println("                         " + commenter.getID());
                    }
                }
                break;
            case 14 :
                // be dast avardane liste kasani ke ham follower va ham following hastand
                followerAndFollowings = new ArrayList<>();
                for (User i : Menu.loggedUser.getPreviousFollowings())
                    if (!Menu.loggedUser.getFollowing().contains(i))
                        followerAndFollowings.add(i);

                ArrayList<User> suggestedUsers = new ArrayList<>();
                for (User i : followerAndFollowings)
                    // jostojoye tak be take following haye kasani ke ham follower va ham following hastand
                    for (User j : i.getFollowing())
                    {
                        int seenTimes = 0;
                        // be dast avardane tedade kasani ke in shakhs ra follow mikonand
                        for (User t : followerAndFollowings)
                            if (t.getFollowing().contains(j))
                                seenTimes++;
                        // chap kardane ID be sharti ke hade aghal 5 bar dide shode bashad va tekrari nabashad
                        if (seenTimes > 4 && !suggestedUsers.contains(j))
                            suggestedUsers.add(j);
                    }
                for (User i : suggestedUsers)
                    System.out.println("                         " + i.getID());
                break;
            default:
                System.out.println("                         Please enter the correct number!");
        }

    }
    static void showYourPostsInSort()
    {
        System.out.println("                         Do you want to sort your posts by likes number or comments number?");
        System.out.println("                         1-likes number");
        System.out.println("                         1-comments number");
        int i = sc.nextInt();
        if (i==1) {
            ArrayList<Post> sortedPostsByLike = Menu.loggedUser.getPosts();
            for (int t = 0; t < sortedPostsByLike.size() - 1; t++)
                for (int j = 0; j < sortedPostsByLike.size() - t - 1; j++)
                    if (sortedPostsByLike.get(j).getLikers().size() < sortedPostsByLike.get(j + 1).getLikers().size())
                        Collections.swap(sortedPostsByLike, j, j + 1);
            for (Post t : sortedPostsByLike)
                System.out.println("                         Post : " + t.getContent() + "     Likes number : " + t.getLikers().size());
        }
        else if (i==2) {
            ArrayList<Post> sortedPostsByComment = Menu.loggedUser.getPosts();
            for (int t = 0; t < sortedPostsByComment.size() - 1; t++)
                for (int j = 0; j < sortedPostsByComment.size() - t - 1; j++)
                    if (sortedPostsByComment.get(j).getLikers().size() < sortedPostsByComment.get(j + 1).getLikers().size())
                        Collections.swap(sortedPostsByComment, j, j + 1);
            for (Post t : sortedPostsByComment)
                System.out.println("                         Post : " + t.getContent() + "     Comments number : " + t.getComments().size());
        }
    }
}
