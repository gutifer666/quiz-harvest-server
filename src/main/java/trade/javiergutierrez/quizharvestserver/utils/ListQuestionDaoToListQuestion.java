package trade.javiergutierrez.quizharvestserver.utils;

import org.springframework.stereotype.Component;
import trade.javiergutierrez.quizharvestserver.model.Option;
import trade.javiergutierrez.quizharvestserver.model.Question;
import trade.javiergutierrez.quizharvestserver.model.dao.OptionDao;
import trade.javiergutierrez.quizharvestserver.model.dao.QuestionDao;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListQuestionDaoToListQuestion {

  public List<Question> convert(List<QuestionDao> questionDaos) {
    List<Question> questions;
    questions = questionDaos.stream().map(questionDao -> {
      return new Question(questionDao.getId(), questionDao.getTextQuestion(), convertToOptionList(questionDao.getOptions()), questionDao.getSubject(), questionDao.getEvaluation());
    }).toList();
    return questions;
  }

  private List<Option> convertToOptionList(List<OptionDao> optionEntityList) {
    List<Option> options = new ArrayList<>();
    for (OptionDao optionEntity : optionEntityList) {
      options.add(new Option(optionEntity.getId(), optionEntity.getTextOption(), optionEntity.isCorrect()));
    }
    return options;
  }
}
