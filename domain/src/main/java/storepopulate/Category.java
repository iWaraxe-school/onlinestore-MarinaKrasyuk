package storepopulate;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;


public class Category {
    private String categoryName;
    private  final List<Product> productlist = new ArrayList<Product>();
    private  List<Product> sortproductlist = new ArrayList<>();



    public Category(String categoryName) {
        this.categoryName = categoryName;

    }
    public List<Product> getProductlist() {
        return productlist;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public void addProductToCategory(Product product){

        productlist.add(product);

    }



    public static List<Product> sortProductList(List<Product> productList) throws IOException, SAXException, ParserConfigurationException {
        List<Product> pl = new ArrayList(productList);
        Map<String, String> sortMap = Parsing.parse();

        for (String sortKey : sortMap.keySet()) {
            if (sortMap.get(sortKey).equals("asc")) {
                pl.sort(ComparatorProduct.getComparator(sortKey));
            } else if (sortMap.get(sortKey).equals("desc")) {
                pl.sort(ComparatorProduct.getComparator(sortKey).reversed());
            }
        }
        return pl;
    }


    public void println(List <Product> products){
        for (int i = 0; i< products.size(); i++)
        {
            System.out.println(this.categoryName +" "+ products.get(i).getName()+" "+ products.get(i).getRate()+" "+ products.get(i).getPrice());

        }

    }

}
