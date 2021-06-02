import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class HrReader {
    public void readXml(){
        String file = "../XML/dom4j/src/hr.xml";
        //parse XML file and save as tree in memory
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            //get xml root element, hr label
            Element root = document.getRootElement();
            //elements to get specific label's elements.
            List<Element> employees= root.elements("employee");
            for (Element employee: employees){
                //use element to get a unique element for a child element.
                Element name = employee.element("name");
                String empName = name.getText();// get name label's value
                System.out.println(empName);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HrReader reader = new HrReader();
        reader.readXml();
    }
}
