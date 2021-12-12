
import java.util.ArrayList;
import java.util.List;


// to do abstract
public class Category {
    private String categoryname;
    private final List<Product> productlist ;//= new ArrayList<Product>();//сделать ее файнал

    public Category(String category_name, List<Product> productlist) {
        this.categoryname = category_name;
        this.productlist = productlist;
    }

    public Category(String categoryname) {
        this.categoryname = categoryname;
        productlist = null;
    }

    public String getCategory_name() {
        return categoryname;
    }

    public List<Product> getProductlist() {
        return productlist;
    }


    public void addProductToCategory(Product product){

        this.productlist.add(product);

    }

    public void println(){
        for (int i = 0; i< productlist.size(); i++)
        {
            System.out.println(this.categoryname+" "+ productlist.get(i).getName()+" "+ productlist.get(i).getRate()+" "+ productlist.get(i).getPrice());

        }

    }

}
