
import java.util.List;

public class Category {
    final private String category_name;
    private List<Product> product_list;

    public Category(String category_name, List<Product> product_list) {
        this.category_name = category_name;
        this.product_list = product_list;
    }

    public String getCategory_name() {
        return category_name;
    }

    public List<Product> getProduct_list() {
        return product_list;
    }
}
