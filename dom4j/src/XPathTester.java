import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

public class XPathTester {
    public void xpath(String xpathExp){
        String file = "../XML/dom4j/src/hr.xml";
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            List<Node> nodes = document.selectNodes(xpathExp);
            for (Node node: nodes){
                Element emp = (Element) node;
                System.out.println(emp.elementText("name"));
                System.out.println(emp.elementText("age"));
                System.out.println(emp.elementText("salary"));
                System.out.println("========================");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XPathTester tester = new XPathTester();
//        tester.xpath("/hr/employee");
//        tester.xpath("//employee");
//        tester.xpath("//employee[salary<4000]");
//        tester.xpath("//employee[name='Tim']");
//        tester.xpath("//employee[@no=3304]");
//        tester.xpath("//employee[1]");
//        tester.xpath("//employee[last()]");
//        tester.xpath("//employee[position()<6]");
        tester.xpath("//employee[3] | //employee[5]");







    }
}
