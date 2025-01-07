import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collection;

public class ContestManager {
    List<Question> LowQuestion;
    List<Question> MediumQuestion;
    List<Question> HighQuestion;
    List<Contest> ActiveContest;

    public ContestManager() {
        LowQuestion = new ArrayList<>();
        MediumQuestion =  new ArrayList<>();
        HighQuestion =  new ArrayList<>();
        ActiveContest =  new ArrayList<>();
    }

    public void addQuestion(Question question){
        if(question.difficulty == Difficulty.LOW){
            LowQuestion.add(question);
        }
        if(question.difficulty == Difficulty.MEDIUM){
            MediumQuestion.add(question);
        }
        if(question.difficulty == Difficulty.HIGH) {
            HighQuestion.add(question);
        }
    }

    public void CreateContest(String Name, Difficulty level, String creator){

        if(!UserService.getUserNames().contains(creator)){
            System.out.println("Unregistered Creator");
            return;
        }
        User Creator= UserService.getUser(creator);
         ;

        if(level== Difficulty.LOW){
            Contest contest=new Contest(Name,Creator,level,LowQuestion);
            contest.addUserToContest(Creator);
            this.ActiveContest.add(contest);
        }
        if(level== Difficulty.MEDIUM){
            Contest contest=new Contest(Name,Creator,level,MediumQuestion);
            contest.addUserToContest(Creator);
            this.ActiveContest.add(contest);
        }
        if(level== Difficulty.HIGH){
            Contest contest=new Contest(Name,Creator,level,HighQuestion);
            contest.addUserToContest(Creator);
            this.ActiveContest.add(contest);
        }
    }

    public void getquestion(){
        for(Question q:LowQuestion){
            System.out.println(q.toString());
        }
        for(Question q:HighQuestion){
            System.out.println(q.toString());
        }
        for(Question q:MediumQuestion){
            System.out.println(q.toString());
        }
    }
    public void ListQuestion(Difficulty difficulty){
        if(difficulty == Difficulty.LOW){

            LowQuestion.forEach(val -> System.out.println("Question" +"{"+val.getquestionId() +" "+ val.getDifficulty() + " " + val.getScore()+"}") );
        }
        else if(difficulty == Difficulty.MEDIUM){

             MediumQuestion.forEach(val -> System.out.println("Question" +"{"+val.getquestionId() +" "+ val.getDifficulty() + val.getScore()+"}") );
        }
        else if(difficulty == Difficulty.HIGH){
             HighQuestion.forEach(val -> System.out.println("Question" +"{"+val.getquestionId() +" "+ val.getDifficulty() + val.getScore()+"}") );
        }

    }

    public void AttendContest(String contestId, String UserId){
        User user= UserService.getUser(UserId);

        for(Contest con:ActiveContest){
            if(con.getContestId() == ((Integer.parseInt(contestId))) && con.getFl()){
                if(con.getUsersOfContest().contains(user)){
                    System.out.println("Already Registered");
                    return;
                }
                con.addUserToContest(user);
                return;
            }
        }
        System.out.println("Already Over Over");

    }

    public void RunContest(String contestId,String creator){

        for(Contest con: ActiveContest ){
            if(con.getContestId() == Integer.parseInt((contestId)) && con.getFl()){
                con.setFl(false);
                Difficulty diff= con.getLevel();
                List<User> users=con.getUsersOfContest();
                List<Question> question= con.getQuestions();

                for(int j=0;j<users.size();j++) {
                    int total=0;
                    for (int i = 0; i < question.size(); i++) {

                        if(((int)(Math.random()*100))%2 == 0){
                            con.addSolvedQuestionList(users.get(j), question.get(i).getquestionId());
                            total+= question.get(i).getScore();
                        }
                    }

                    if(diff == Difficulty.LOW){
                        users.get(j).addRating(total-50);
                        con.setScoreOfUser(users.get(j),total-50);
                    }
                    if(diff == Difficulty.MEDIUM){
                        users.get(j).addRating(total-30);
                        con.setScoreOfUser(users.get(j),total-30);
                    }
                    if(diff == Difficulty.HIGH){
                        users.get(j).addRating(total);
                        con.setScoreOfUser(users.get(j),total);
                    }
                }
                return;
            }

        }

    }

    public void ContestHistory(String contestId){
        for(Contest con: ActiveContest ) {
            if (con.getContestId() == Integer.parseInt((contestId))) {
                Map<User, List<Integer>> userSolvedQuestions= con.getSolvedQuestionList();
                Map<User, Integer> ScoreOfUser= con.getScoreOfUser();
                for(Map.Entry<User, List<Integer>> m1 : userSolvedQuestions.entrySet()){

                    System.out.println("User " + m1.getKey().getName() +  ": "+ ScoreOfUser.get(m1.getKey())+"{"+ m1.getValue()+"}");
                }
            }
        }
    }







}
