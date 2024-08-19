package trade.javiergutierrez.quizharvestserver.contexts.management.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private Long id;
    private String question;
    private String election;

    private List<String> solutions = new ArrayList<>();

    public Question() {
    }

    public Question(String question, String election, List<String> solutions) {
        this.question = question;
        this.election = election;
        this.solutions = solutions;
    }
    public String getQuestion() {
        return this.question;
    }

    public Long getId() {
        return this.id;
    }

    public List<String> getSolutions() {
        return this.solutions;
    }


    public String getElection() {
        return this.election;
    }
}
