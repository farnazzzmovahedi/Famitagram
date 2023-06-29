import java.util.ArrayList;

public class Post
{
    private boolean seen;
    private User postingUser;
    private String content;
    private Categories category;
    private ArrayList<Post> previousPosts = new ArrayList<Post>(); // post before being edited
    private ArrayList<User> likers = new ArrayList<User>();
    private ArrayList<User> commenters = new ArrayList<User>();
    private ArrayList<User> dislikers = new ArrayList<User>();
    private ArrayList<Comment> comments = new ArrayList<Comment>();

    public Post(User postingUser, Categories category , String content) {
        this.setPostingUser(postingUser);
        this.setContent(content);
        this.setCategory(category);
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public User getPostingUser() {
        return postingUser;
    }

    public void setPostingUser(User postingUser) {
        this.postingUser = postingUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<User> getLikers() {
        return likers;
    }

    public void setLikers(ArrayList<User> likers) {
        this.likers = likers;
    }

    public ArrayList<User> getCommenters() {
        return commenters;
    }

    public void setCommenters(ArrayList<User> commenters) {
        this.commenters = commenters;
    }

    public ArrayList<User> getDislikers() {
        return dislikers;
    }

    public void setDislikers(ArrayList<User> dislikers) {
        this.dislikers = dislikers;
    }

    public ArrayList<Post> getPreviousPosts() {
        return previousPosts;
    }

    public void setPreviousPosts(ArrayList<Post> previousPosts) {
        this.previousPosts = previousPosts;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public boolean isSeen() {
        return seen;
    }


    @Override
    public String toString() {
        return "Post{" +
                "postingUser=" + postingUser.getID() +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", number of the users who have liked =" + likers.size() +
                ", number of the users who have commented =" + commenters.size() +
                ", number of the users who have disliked =" + dislikers.size() +
                '}';
    }
}