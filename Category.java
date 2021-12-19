package storepopulate;

import java.util.ArrayList;
import java.util.List;


// to do abstract
public class Category {
    private String categoryName;
    private  final List<Product> productlist = new ArrayList<Product>();//сделать ее файнал



    public Category(String categoryName) {
        this.categoryName = categoryName;

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addProductToCategory(Product product){

        productlist.add(product);

    }

    public void println(){
        for (int i = 0; i< productlist.size(); i++)
        {
            System.out.println(this.categoryName +" "+ productlist.get(i).getName()+" "+ productlist.get(i).getRate()+" "+ productlist.get(i).getPrice());

        }

    }

}
