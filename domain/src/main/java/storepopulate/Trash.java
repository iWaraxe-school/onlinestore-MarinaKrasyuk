package storepopulate;

import java.util.ArrayList;
import java.util.List;

public class Trash {

    static List<Product> trash= new ArrayList<>();

    public static void addToTrash(Product product){
        trash.add(product);
    }
    public static void clearTrash(){
        System.out.println("Trash is cleared");
        trash.clear();
    }
}
