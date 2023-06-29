import java.util.ArrayList;

public class Story
{
    static private int index = 0;
    private int storyNumber;
    private boolean seen;
    private User storingUser;
    private String content;
    private ArrayList<User> likerStory = new ArrayList<User>();
    private ArrayList<User> dislikerStory = new ArrayList<User>();

    public Story(User storingUser, String content)
    {
        setContent(content);
        setStoringUser(storingUser);
        setSeen(false);
        setStoryNumber(++index);
    }

    public String getContent() {
        return content;
    }
    public User getStoringUser() {
        return storingUser;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setStoringUser(User storingUser) {
        this.storingUser = storingUser;
    }
    public ArrayList<User> getLikerStory() {
        return likerStory;
    }
    public ArrayList<User> getDislikerStory() {
        return dislikerStory;
    }
    public void setDislikeStory(ArrayList<User> dislikeStory) {
        this.dislikerStory = dislikeStory;
    }
    public void setLikerStory(ArrayList<User> likerStory) {
        this.likerStory = likerStory;
    }
    public void setStoryNumber(int storyNumber) {
        this.storyNumber = storyNumber;
    }
    public int getStoryNumber() {
        return storyNumber;
    }
    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public boolean isSeen() {
        return seen;
    }

    @Override
    public String toString() {
        return "Story{" +
                "storyNumber=" + storyNumber +
                ", seen=" + seen +
                ", storingUser=" + storingUser +
                ", content='" + content + '\'' +
                ", likerStory=" + likerStory +
                ", dislikeStory=" + dislikerStory +
                '}';
    }
}
