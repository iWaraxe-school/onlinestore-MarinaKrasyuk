import java.util.ArrayList;

public class Category {
    String category_name;
    ArrayList<String> product_list=new ArrayList<>();

    public Category(String category_name, ArrayList<String> product_list) {
        this.category_name = category_name;
        this.product_list = product_list;
    }
}
