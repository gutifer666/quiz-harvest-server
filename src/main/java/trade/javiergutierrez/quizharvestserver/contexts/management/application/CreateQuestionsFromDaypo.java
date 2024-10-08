package trade.javiergutierrez.quizharvestserver.contexts.management.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import trade.javiergutierrez.quizharvestserver.contexts.management.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts.management.domain.QuestionMapper;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class CreateQuestionsFromDaypo {
    QuestionService questionService;

    public CreateQuestionsFromDaypo(QuestionService questionService) {
        this.questionService = questionService;
    }

    private Document formatXML(MultipartFile file) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file.getInputStream());
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Question> createQuestionsFromXML(Document document) {
        NodeList nodeList = document.getElementsByTagName("c");
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String typeStr = getTagValue("t", element);
                String question = getTagValue("p", element);
                String election = getTagValue("c", element);
                NodeList respuestasNodeList = element.getElementsByTagName("o");
                List<String> solution = new ArrayList<>();
                for (int j = 0; j < respuestasNodeList.getLength(); j++) {
                    solution.add(respuestasNodeList.item(j).getTextContent());
                }

                if(typeStr != null && typeStr.equals("0")
                    && election != null
                    && election.equals("2111")
                    || Objects.equals(election, "1211")
                    || Objects.equals(election, "1121")
                    || Objects.equals(election, "1112"))
                {
                    questions.add(new Question(question, election, solution));
                }
            }
        }
        return questions;
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        if (nodeList.getLength() > 0 && nodeList.item(0) != null) {
            Node node = nodeList.item(0).getChildNodes().item(0);
            if (node != null) {
                return node.getNodeValue();
            }
        }
        return null;
    }

    public void execute(MultipartFile file) {
        Document document = formatXML(file);
        List<Question> questions = null;
        List<trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Question> questionsMapped = new ArrayList<>();

        if (document != null) {
            questions = createQuestionsFromXML(document);
        }
        for (Question question : questions) {
            questionsMapped.add(QuestionMapper.map(question));
        }
        questionService.createQuestions(questionsMapped);
    }
}
