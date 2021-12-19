
import storepopulate.Category;
import java.util.*;
import java.util.Map;

public class StoreApp {

    public static void main(String[] args) {


        Map <Category, Integer> categorylist = new HashMap<>();
        StoreHelper storeHelper= new StoreHelper();
        categorylist = storeHelper.reflectionCategory();
        Store store =new Store(categorylist);
        store.fillStore(categorylist);
        store.printlnStore();


    }

}
