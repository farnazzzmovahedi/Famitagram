public class Comment
{
    String commentText;
    Post commentedPost;
    User postingUser;
    User commentingUser;

    public Comment(String commentText, Post commentedPost, User postingUser, User commentingUser) {
        this.commentText = commentText;
        this.commentedPost = commentedPost;
        this.postingUser = postingUser;
        this.commentingUser = commentingUser;
    }

    public String getCommentText() {
        return commentText;
    }

    public Post getCommentedPost() {
        return commentedPost;
    }

    public User getPostingUser() {
        return postingUser;
    }

    public User getCommentingUser() {
        return commentingUser;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public void setCommentedPost(Post commentedPost) {
        this.commentedPost = commentedPost;
    }

    public void setPostingUser(User postingUser) {
        this.postingUser = postingUser;
    }

    public void setCommentingUser(User commentingUser) {
        this.commentingUser = commentingUser;
    }
}
