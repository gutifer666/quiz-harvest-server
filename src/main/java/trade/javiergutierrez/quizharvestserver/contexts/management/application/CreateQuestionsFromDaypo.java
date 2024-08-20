package trade.javiergutierrez.quizharvestserver.contexts.management.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import trade.javiergutierrez.quizharvestserver.contexts.management.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts.management.domain.QuestionMapper;
import trade.javiergutierrez.quizharvestserver.contexts.management.domain.SetOfQuestions;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class CreateQuestionsFromDaypo {
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
/*        System.out.println("Questions not mapped");
        printConsole(questions);*/
        System.out.println("Questions mapped");
        printConsoleQuestionsMapped(questionsMapped);

    }

    private void printConsoleQuestionsMapped(List<trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Question> questionsMapped) {
        if (questionsMapped != null) {
            for (trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Question question : questionsMapped) {
                System.out.println(question.getId());
                System.out.println(question.getTextQuestion());
                for (trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Option option : question.getOptions()) {
                    System.out.println(option.getId());
                    System.out.println(option.getTextOption());
                    System.out.println(option.isCorrect());
                }
                System.out.println(question.getSubject());
                System.out.println(question.getEvaluation());
            }
        }
    }

    private void printConsole(List<Question> questions) {
        if (questions != null) {
            for (Question question : questions) {
                System.out.println(question.getId());
                System.out.println(question.getQuestion());
                System.out.println(question.getElection());
                System.out.println("Solutions");
                for (String solution : question.getSolutions()) {
                    System.out.println(solution);
                }
            }
        }
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
}
