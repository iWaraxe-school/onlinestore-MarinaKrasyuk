import org.apache.log4j.PropertyConfigurator;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;
import storepopulate.Category;
import storepopulate.Product;

import java.io.IOException;
import java.util.*;
import java.util.Map;
import categories.*;
import static org.reflections.scanners.Scanners.SubTypes;

public class StoreApp {

    public static void main(String[] args) {


        Map <Category, Integer> categorylist = new HashMap<Category, Integer>();
        Store store =new Store(categorylist);

        Reflections reflections = new Reflections("categories");

        Set<Class<? extends Category>> allClasses =
                reflections.getSubTypesOf(Category.class);

        for (Class cl : allClasses) {
                categorylist.put(new Category(cl.getSimpleName(),new ArrayList<Product>()),2);
                store.fillStore(categorylist);

        }

        store.printlnStore();


    }

}
