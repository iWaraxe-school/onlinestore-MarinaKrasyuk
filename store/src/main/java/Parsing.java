import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Parsing {
    public static Map<String,String > parse() throws ParserConfigurationException, IOException, SAXException {

        File file = new File("sort.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        NodeList nodes = document.getElementsByTagName("sort");
        Map <String,String > sortMap= new HashMap<>();
        String first=null;
        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element sortelement = (Element) nodes.item(i);
                NodeList childnode = sortelement.getChildNodes();

                for (int j = 0; j < childnode.getLength(); j++) {
                    if (childnode.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childelement1 = (Element) childnode.item(j);

                        if (first != null){
                            sortMap.put(first,childelement1.getTextContent());
                            first = null;
                        }
                        else
                            first = childelement1.getTextContent();
                    }

                }

            }
        }
        return sortMap;
    }
}
