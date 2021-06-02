import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class HrWriter {
    public void writeXml(){
        String file = "../XML/dom4j/src/hr.xml";
        SAXReader  reader = new SAXReader();
        try {
            Document document = reader.read(file);
            Element root = document.getRootElement();
            Element employee = root.addElement("employee");
            employee.addAttribute("no", "3311");
            Element name = employee.addElement("name");
            name.setText("Tim");
            employee.addElement("age").setText("33");
            employee.addElement("salary").setText("3600");
            Element department = employee.addElement("department");
            department.addElement("dname").setText("HR");
            department.addElement("address").setText("XXbuilding");
            Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            document.write(writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HrWriter hrWriter = new HrWriter();
        hrWriter.writeXml();
    }
}
