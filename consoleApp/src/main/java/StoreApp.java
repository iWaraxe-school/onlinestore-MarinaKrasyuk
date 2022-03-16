
import categories.Categories;
import categories.Category;
import http.AppServer;
import org.xml.sax.SAXException;
import populator.HttpPopulator;
import populator.Populator;
import store.Store;
import storepopulate.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.Map;

public class StoreApp {

    static Store store=null;
    static List<Category> categorylist=null;
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, SQLException, ClassNotFoundException {

        Populator populator=new HttpPopulator();
        AppServer.startServer();
        categorylist= populator.getALLCategory();

      /* for (Category c: categorylist){
            List<Product> productlist=c.getProductlist();
            c.println(productlist);
       }*/
        createStore();
        CommandsManager commands= new CommandsManager(store,new Scanner(System.in));
        commands.init();

    }

   public static  Map<Category, Integer> createCategory( Map<Category, Integer> categories){
        CategoryFactory factory=new CategoryFactory();
        for (Categories category : Categories.values()){
            categories=factory.createCategory(category);
        }
        return  categories;

    }
    public static Store createStore()  {
        Trash trash=null;
        store = new Store(categorylist,trash);
        return store;
    }


}
