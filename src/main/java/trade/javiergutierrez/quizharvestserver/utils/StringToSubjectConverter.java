package trade.javiergutierrez.quizharvestserver.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import trade.javiergutierrez.quizharvestserver.model.Subject;

@Component
public class StringToSubjectConverter implements Converter<String, Subject>{
  @Override
  public Subject convert(String source) {
    return Subject.valueOf(source.toUpperCase());
  }
}
