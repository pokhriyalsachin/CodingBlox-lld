//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        UserService.addUser("Ross");
        UserService.addUser("Monica");
        UserService.addUser("Joey");
        UserService.addUser("Chandler");

        UserService.getLeaderBoard("asc");

        ContestManager contestManager= new ContestManager();

        contestManager.addQuestion(new Question(Difficulty.LOW, 17));
        contestManager.addQuestion(new Question(Difficulty.LOW, 18));
        contestManager.addQuestion(new Question(Difficulty.LOW, 19));
        contestManager.addQuestion(new Question(Difficulty.LOW, 20));

        contestManager.addQuestion(new Question(Difficulty.MEDIUM,47));
        contestManager.addQuestion(new Question(Difficulty.MEDIUM,48));
        contestManager.addQuestion(new Question(Difficulty.MEDIUM,49));
        contestManager.addQuestion(new Question(Difficulty.MEDIUM,50));

        contestManager.addQuestion(new Question(Difficulty.HIGH,101));
        contestManager.addQuestion(new Question(Difficulty.HIGH,104));
        contestManager.addQuestion(new Question(Difficulty.HIGH,108));
        contestManager.addQuestion(new Question(Difficulty.HIGH,120));


        contestManager.ListQuestion(Difficulty.LOW);

        contestManager.CreateContest("Codeforces Div 1",Difficulty.HIGH,"Ross");
        contestManager.AttendContest("1","Joey");
        contestManager.AttendContest("1","Monica");
        contestManager.AttendContest("1","Ross");

        contestManager.RunContest("1","Ross");
        UserService.getLeaderBoard("asc");

        contestManager.ContestHistory("1");



    }
}