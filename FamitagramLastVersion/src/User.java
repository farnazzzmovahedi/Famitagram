import java.util.ArrayList;

public class User
{

    private String firstName;
    private String lastName;
    private String birthDate;
    private String phoneNumber;
    private String password;
    private String ID;
    private String bio;
    private boolean isPrivate;

    private ArrayList<User> previousFollowers = new ArrayList<>();
    private ArrayList<User> previousFollowings = new ArrayList<>();

    public ArrayList <Story> stories = new ArrayList<Story>();
    private ArrayList <User> followers = new ArrayList<User>();
    private ArrayList <User> following = new ArrayList<User>();
    private ArrayList <Post> posts = new ArrayList<Post>();
    private ArrayList <User> followRequests = new ArrayList<User>();
    private ArrayList <Comment> yourComments = new ArrayList<Comment>();

    private ArrayList <Notification> notifications = new ArrayList<Notification>();
    private ArrayList <Post> likedPosts = new ArrayList<Post>();
    private ArrayList <Post> dislikedPosts = new ArrayList<Post>();
    private ArrayList <Post> viewedPosts = new ArrayList<Post>();
    private ArrayList <Post> commentedPosts = new ArrayList<Post>();
    private ArrayList <Post> savedPosts = new ArrayList<Post>();
    private ArrayList <Story> likedStories = new ArrayList<Story>();
    private ArrayList <Story> dislikedStories = new ArrayList<Story>();


    public User(String firstName, String lastName, String birthDate, String phoneNumber, String password, String ID, String bio, boolean isPrivate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.ID = ID;
        this.bio = bio;
        this.isPrivate = isPrivate;
    }

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getBirthDate() {return birthDate;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getPassword() {return password;}
    public String getID() {return ID;}
    public String getBio() {return bio;}
    public boolean isPrivate() {return isPrivate;}
    public ArrayList<User> getFollowers() {return followers;}
    public ArrayList<User> getFollowing() {return following;}
    public ArrayList<Post> getPosts() {return posts;}
    public ArrayList<User> getFollowRequests() {return followRequests;}
    public ArrayList<Comment> getYourComments() {return yourComments;}
    public ArrayList<Notification> getNotifications() {return notifications;}
    public ArrayList<Post> getLikedPosts() {return likedPosts;}
    public ArrayList<Post> getDislikedPosts() {return dislikedPosts;}
    public ArrayList<Post> getViewedPosts() {return viewedPosts;}
    public ArrayList<Post> getCommentedPosts() {return commentedPosts;}
    public ArrayList<Post> getSavedPosts() {return savedPosts;}
    public ArrayList <Story> viewedStories = new ArrayList<Story>();

    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setBirthDate(String birthDate) {this.birthDate = birthDate;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setPassword(String password) {this.password = password;}
    public void setID(String ID) {this.ID = ID;}
    public void setBio(String bio) {this.bio = bio;}
    public void setPrivate(boolean aPrivate) {isPrivate = aPrivate;}
    public void setFollowers(ArrayList<User> followers) {this.followers = followers;}
    public void setFollowing(ArrayList<User> following) {this.following = following;}
    public void setPosts(ArrayList<Post> posts) {this.posts = posts;}
    public void setFollowRequests(ArrayList<User> followRequests) {this.followRequests = followRequests;}
    public void setYourComments(ArrayList<Comment> yourComments) {this.yourComments = yourComments;}
    public void setNotifications(ArrayList<Notification> notifications) {this.notifications = notifications;}
    public void setLikedPosts(ArrayList<Post> likedPosts) {this.likedPosts = likedPosts;}
    public void setDislikedPosts(ArrayList<Post> dislikedPosts) {this.dislikedPosts = dislikedPosts;}
    public void setViewedPosts(ArrayList<Post> viewedPosts) {this.viewedPosts = viewedPosts;}
    public void setCommentedPosts(ArrayList<Post> commentedPosts) {this.commentedPosts = commentedPosts;}
    public void setSavedPosts(ArrayList<Post> savedPosts) {this.savedPosts = savedPosts;}

    public void setViewedStories(ArrayList<Story> viewedStories) {
        this.viewedStories = viewedStories;
    }

    public ArrayList<Story> getViewedStories() {
        return viewedStories;
    }

    public void setStories(ArrayList<Story> stories) {
        this.stories = stories;
    }

    public void setLikedStories(ArrayList<Story> likedStories) {
        this.likedStories = likedStories;
    }

    public void setDislikedStories(ArrayList<Story> dislikedStories) {
        this.dislikedStories = dislikedStories;
    }
    public ArrayList<Story> getStories() {
        return stories;
    }
    public ArrayList<Story> getLikedStories() {
        return likedStories;
    }
    public ArrayList<Story> getDislikedStories() {
        return dislikedStories;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", ID='" + ID + '\'' +
                ", bio='" + bio + '\'' +
                ", isPrivate=" + isPrivate +
                '}';
    }

    public ArrayList<User> getPreviousFollowers() {
        return previousFollowers;
    }

    public void setPreviousFollowers(ArrayList<User> previousFollowers) {
        this.previousFollowers = previousFollowers;
    }

    public ArrayList<User> getPreviousFollowings() {
        return previousFollowings;
    }

    public void setPreviousFollowings(ArrayList<User> previousFollowings) {
        this.previousFollowings = previousFollowings;
    }
}
