public class Main {

    public static void main(String[] args) {

//        User a = new User("a", "a", "a", "a", "a", "a", "a", true);
//        Menu.loggedUser = a;
//        Post newPost = new Post(Menu.loggedUser , Categories.ANIMAL , "CONTENT");
//        Menu.loggedUser.getPosts().add(newPost);
//        newPost = new Post(Menu.loggedUser , Categories.FASHION , "CONTENT");
//        Menu.loggedUser.getPosts().add(newPost);
//        for (int i = 0; i < Menu.loggedUser.getPosts().size(); i++)
//        {
//            System.out.println(i+1 + "-" + Menu.loggedUser.getPosts().get(i).toString());
//        }
        User user1 = new User("dasd" , "asd" , "dsada" , "561564" , "564" , "asddsa" , "sasdf" , true);
        Lists.getUsers().add(user1);
        Menu.mainMenu();
//        for (int i = 0; i < Lists.getUsers().size(); i++)
//        {
//            Lists.getUsers().get(i).toString();
//        }
    }
}






