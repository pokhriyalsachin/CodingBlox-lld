public class User {
    String name;
    int Rating;
    public User(String name) {
        this.name = name;
        this.Rating=1500;
    }

    public int getRating() {
        return Rating;
    }

    public void addRating(int rating) {
        Rating += rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
