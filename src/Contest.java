import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest {
    static int ContestId=0;
    private String ContestName;
    private User Creator;
    private Difficulty Level;
    private List<Question> questions;
    private List<User> user;
    private boolean fl;
    private Map<User,List<Integer>>SolvedQuestionList;
    private Map<User,Integer>scoreOfUser;

    public Map<User, Integer> getScoreOfUser() {
        return scoreOfUser;
    }

    public void setScoreOfUser(User user, int score) {

            scoreOfUser.put(user, score);

    }

    public Map<User, List<Integer>> getSolvedQuestionList() {
        return SolvedQuestionList;
    }

    public void setSolvedQuestionList(Map<User, List<Integer>> solvedQuestionList) {
        SolvedQuestionList = solvedQuestionList;
    }
    public void addSolvedQuestionList(User user,int questionId) {
        if(!SolvedQuestionList.containsKey(user)) {
            SolvedQuestionList.put(user, new ArrayList<>());
        }
        SolvedQuestionList.get(user).add(questionId);

    }

    public Contest(String contestName, User creator, Difficulty level, List<Question> questions) {
        ContestId+=1;
        ContestName = contestName;
        Creator = creator;
        Level = level;
        this.questions= new ArrayList<>();
        this.questions = questions;
        this.user= new ArrayList<>();
        SolvedQuestionList= new HashMap<>();
        scoreOfUser = new HashMap<>();
        fl=true;
    }

    public boolean getFl() {
        return  fl;
    }
    public void setFl(boolean b) {
       fl=b;
    }

    public int getContestId(){
        return ContestId;
    }

    public List<User> getUsersOfContest() {
        return user;
    }

    public void addUserToContest(User user1) {
        user.add(user1);
    }

    public String getContestName() {
        return ContestName;
    }

    public void setContestName(String contestName) {
        ContestName = contestName;
    }

    public User getCreator() {
        return Creator;
    }

    public void setCreator(User creator) {
        Creator = creator;
    }

    public Difficulty getLevel() {
        return Level;
    }

    public void setLevel(Difficulty level) {
        Level = level;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
