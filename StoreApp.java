import com.github.javafaker.Cat;

import java.util.*;
import java.util.Map;

public class StoreApp {

    public static void main(String[] args) {


        Map <Category, Integer> category_list= new HashMap<Category, Integer>();
        Store store =new Store(category_list);
        try {
            Class <Category> C1= (Class<Category>) Class.forName("Book");
            category_list.put(new Category(C1.getName(),new ArrayList<Product>()),2);
            Class <Category> C2= (Class<Category>) Class.forName("Food");
            category_list.put(new Category(C2.getName(),new ArrayList<Product>()),5);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        store.fillStore(category_list);
        store.printlnStore();


    }

}
