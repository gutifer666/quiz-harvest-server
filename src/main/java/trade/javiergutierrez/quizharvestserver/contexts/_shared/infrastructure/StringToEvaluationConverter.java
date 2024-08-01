package trade.javiergutierrez.quizharvestserver.contexts._shared.infrastructure;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;

@Component
public class StringToEvaluationConverter implements Converter<String, Evaluation>{
  @Override
  public Evaluation convert(String source) {
    return Evaluation.valueOf(source.toUpperCase());
  }
}
