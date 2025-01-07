import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UserService {
    public static List<User> users= new ArrayList<>();
    public static List<String> userNames= new ArrayList<>();

    public UserService() {

    }

    public static void getLeaderBoard(String order){
        if(order.equals("asc")) {
            Collections.sort(users, userSort.ASCENDING);
        }else{
            Collections.sort(users, userSort.DESCENDING);
        }
        for(User user: users){
            System.out.println("{ "+user.getName()+" Score "+ user.getRating()+" }");
        }
    }

    public static void addUser(String user){
        users.add(new User(user));
        userNames.add(user);
    }

    public static List<User> getUser(){
        return users;
    }

    public static List<String> getUserNames(){
        return userNames;
    }

    public static User getUser(String name){
        return users.get(userNames.indexOf(name));
    }


}
