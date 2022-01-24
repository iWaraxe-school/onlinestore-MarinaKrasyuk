
import categories.Categories;
import org.xml.sax.SAXException;
import storepopulate.Category;
import storepopulate.CategoryFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;
import java.util.Map;

public class StoreApp {
    static Map<Category, Integer> categorylist = new HashMap<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {



        createCategory();
        Store store=createStore();
        System.out.println("Before sorting");
        store.printlnStore();

        System.out.println("Choose action : ");
        System.out.println("1-Sort");
        System.out.println("2-Top");
        System.out.println("3-Quit");
        Scanner scanner = new Scanner(System.in);
        boolean flag= true;
        while (!scanner.hasNext()) {
            scanner.next();
        }
        while(flag){
        switch (scanner.next().toLowerCase()) {
            case "sort":
                store.sortProduct();
                break;
            case "top":
                store.top();
                break;
            case "quit":
                scanner.close();
                flag=false;
                break;
            default:
                System.out.println("Incorrect value");
                System.out.println("choose from 1 to 3");
        }
    }
    }
    public static void createCategory(){
        CategoryFactory factory=new CategoryFactory();
        for (Categories category : Categories.values()){
            categorylist=factory.createCategory(category);
        }
    }
    public static Store createStore()
    {
        Store store = new Store(categorylist);
        store.fillStore(categorylist);
        return store;
    }

}
