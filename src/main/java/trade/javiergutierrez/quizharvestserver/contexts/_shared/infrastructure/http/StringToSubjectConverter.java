package trade.javiergutierrez.quizharvestserver.contexts._shared.infrastructure.http;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Subject;

@Component
public class StringToSubjectConverter implements Converter<String, Subject>{
  @Override
  public Subject convert(String source) {
    return Subject.valueOf(source.toUpperCase());
  }
}
