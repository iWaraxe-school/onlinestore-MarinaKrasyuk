package storepopulate;

import java.util.List;


// to do abstract
public class Category {
    private String categoryName;
    private final List<Product> productlist ;//= new ArrayList<storepopulate.Product>();//сделать ее файнал

    public Category(String category_name, List<Product> productlist) {
        this.categoryName = category_name;
        this.productlist = productlist;
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
        productlist = null;
    }

    public String getCategoryName() {
        return categoryName;
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
            System.out.println(this.categoryName +" "+ productlist.get(i).getName()+" "+ productlist.get(i).getRate()+" "+ productlist.get(i).getPrice());

        }

    }

}
