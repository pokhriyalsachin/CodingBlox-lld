import java.util.Comparator;

public class userSort {
    // Comparator for ascending order
    public static final Comparator<User> ASCENDING = (u1, u2) -> Integer.compare(u1.getRating(), u2.getRating());

    // Comparator for descending order
    public static final Comparator<User> DESCENDING = (u1, u2) -> Integer.compare(u2.getRating(), u1.getRating());
}