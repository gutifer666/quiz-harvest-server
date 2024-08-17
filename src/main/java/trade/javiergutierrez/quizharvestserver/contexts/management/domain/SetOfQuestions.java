package trade.javiergutierrez.quizharvestserver.contexts.management.domain;

import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Question;

import java.util.List;

public class SetOfQuestions {
    private List<Question> questions;

    public void addQuestion(Question question){
        questions.add(question);
    }
    public List<Question> get(){
        return questions;
    }
}
