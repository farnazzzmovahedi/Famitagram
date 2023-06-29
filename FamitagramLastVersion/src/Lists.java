import java.util.ArrayList;

public class Lists {
        public static ArrayList <Story> allStories = new ArrayList<Story>();
        private static ArrayList<User> users = new ArrayList<User>();
        private static ArrayList <Post> explorePosts = new ArrayList<Post>();
        private static ArrayList <Post> followingPosts = new ArrayList<Post>();
        private static ArrayList<DirectMessage> messages = new ArrayList<>();



        public static ArrayList<User> getUsers() {return users;}
        public static ArrayList<Post> getExplorePosts() {return explorePosts;}
        public static ArrayList<Post> getFollowingPosts() {return followingPosts;}
    public static ArrayList<DirectMessage> getMessages() {return messages;}
}
