public class Notification {
    User user;

    public Notification(User user) {
        this.user = user;
    }
}

class LikeNotification extends Notification
{
    Post likedPost;
    User liker;

    public LikeNotification(User user , Post likedPost , User liker) {
        super(user);
        this.likedPost = likedPost;
        this.liker = liker;
    }
}
class DisLikedNotification extends Notification
{
    Post disLikedPost;
    User disliker;

    public DisLikedNotification(User user , Post disLikedPost , User disliker) {
        super(user);
        this.disLikedPost = disLikedPost;
        this.disliker = disliker;
    }
}
class CommentNotification extends Notification
{
    String commentText;
    Post commentedPost;
    User commenter;

    public CommentNotification(User user , String commentText , Post commentedPost , User commenter) {
        super(user);
        this.commentText = commentText;
        this.commentedPost = commentedPost;
        this.commenter = commenter;
    }
}
class PostEditNotification extends Notification
{
    Post previousPost;
    Post editedPost;
    User interactedUser;

    public PostEditNotification(User user , Post previousPost, Post editedPost , User interactedUser)
    {
        super(user);
        this.previousPost = previousPost;
        this.editedPost = editedPost;
        this.interactedUser = interactedUser;
    }
}
class FollowRequestNotification extends Notification
{
    User wantToFallowUser;

    public FollowRequestNotification(User user , User wantToFallowUser) {
        super(user);
        this.wantToFallowUser = wantToFallowUser;
    }
}
class MessageNotification extends Notification
{
    DirectMessage message;

    public MessageNotification(DirectMessage message) {
        super(message.getSender());
        this.message = message;
    }
}
class LikedStoryNotification extends Notification
{
    Story likedStory;
    User liker;
    public LikedStoryNotification(User user , Story likedStory , User liker) {
        super(user);
        this.likedStory = likedStory;
        this.liker = liker;
    }
}
class DislikedStoryNotification extends Notification
{
    Story dislikedStory;
    User disliker;
    public DislikedStoryNotification(User user , Story dislikedStory , User disliker) {
        super(user);
        this.dislikedStory = dislikedStory;
        this.disliker = disliker;
    }
}
