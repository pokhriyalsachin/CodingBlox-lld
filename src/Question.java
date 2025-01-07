public class Question {
    static int question_cnt=0;
    int question_id;
    Difficulty difficulty;
    int score;

    public int getquestionId() {
        return question_id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId='" + question_cnt + '\'' +
                ", difficulty=" + difficulty +
                ", score=" + score +
                '}';
    }

    public Question(Difficulty difficulty, int score) {
        question_cnt+=1;
        question_id=question_cnt;
        this.difficulty = difficulty;
        this.score = score;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
