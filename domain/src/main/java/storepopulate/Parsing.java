package storepopulate;

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

        File file = new File("config.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        NodeList nodes = document.getElementsByTagName("sort");
        Map <String,String > sortMap= new HashMap<>();
        Element sortelement = (Element) nodes.item(0);
        NodeList childnode = sortelement.getChildNodes();

        for (int i = 0; i <childnode.getLength() ; i++) {
            if (childnode.item(i).getNodeType() == Node.ELEMENT_NODE) {
            sortMap.put(childnode.item(i).getNodeName(), childnode.item(i).getTextContent());
        } }

        return sortMap;
    }
}
