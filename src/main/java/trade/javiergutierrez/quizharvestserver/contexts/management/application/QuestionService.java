package trade.javiergutierrez.quizharvestserver.contexts.management.application;

import org.springframework.stereotype.Service;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.QuestionRepository;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Subject;

import java.util.List;

@Service
public class QuestionService {
    QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void createQuestion(Question question) {
        questionRepository.save(question);
    }

    public List<Question> readQuestionsBySubjectAndEvaluation(String subject, String evaluation) {
        Subject subjectEnum = Subject.valueOf(subject.toUpperCase());
        Evaluation evaluationEnum = Evaluation.valueOf(evaluation.toUpperCase());
        return questionRepository.bySubjectAndEvaluation(subjectEnum, evaluationEnum);
    }
}
