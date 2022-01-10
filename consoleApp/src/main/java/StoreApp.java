
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import storepopulate.Category;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.Map;

public class StoreApp {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {


        Map<Category, Integer> categorylist = new HashMap<>();
        StoreHelper storeHelper = new StoreHelper();
        categorylist = storeHelper.reflectionCategory();
        Store store = new Store(categorylist);
        store.fillStore(categorylist);
        System.out.println("Do sortirovki");
        store.printlnStore();
        System.out.println("Choose action : ");
        System.out.println("1-Sort");
        System.out.println("2-Top");
        System.out.println("3-Quit");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext()) {
            scanner.next();
        }
        switch (scanner.next()) {
            case "sort":
                store.sortProduct();
                break;
            case "top":
                store.top();
            case "quit":
                scanner.close();
                break;
            default:
                System.out.println("choose from 1 to 3");
                scanner.close();


    }



    }

}
