import org.xml.sax.SAXException;
import storepopulate.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class Store {
    Map <Category,Integer> categorylist;


    public Store(Map<Category, Integer> categorylist) {
        this.categorylist = categorylist;
    }

    public void fillStore(Map <Category,Integer> categorylist){
        RandomStorePopulator faker = new RandomStorePopulator();

        for (Map.Entry <Category,Integer> entry : categorylist.entrySet()){
            for (int i=0; i< entry.getValue();i++){
                Product product = new Product(
                        faker.getProductName(entry.getKey()),
                        faker.getRate(),
                        faker.getPrice(1.0,10.0));
                entry.getKey().addProductToCategory(product);


            }
        }


    }


    public void sortProduct() throws IOException, SAXException, ParserConfigurationException {
        for (Map.Entry <Category,Integer> entry : categorylist.entrySet()) {
           List <Product> sortList= entry.getKey().sortProductList(entry.getKey().getProductlist());
           entry.getKey().println(sortList);
        }

    }

    public void top() {

        List<Product> productList = new ArrayList<>();
        for (Map.Entry <Category,Integer> entry : categorylist.entrySet()){
           productList.addAll(entry.getKey().getProductlist());
        }

        productList.sort(ComparatorProduct.getComparator("price").reversed());
        printTop(productList);

    }
    public void printTop(List<Product> topproduct){
        int size;

        if ( topproduct.size()<=5) {
            size= topproduct.size();
        }
        else
            size=5;
        System.out.println("Top five of Product:    ");
        for (int i = 0; i < size; i++) {

            System.out.println(topproduct.get(i).getName() + " " + topproduct.get(i).getRate() + " " + topproduct.get(i).getPrice());

        }
    }
    public void printlnStore()
    {
        for (Map.Entry <Category,Integer> entry : categorylist.entrySet()){
            System.out.println("storepopulate Category: ");
            entry.getKey().println(entry.getKey().getProductlist());
        }
    }



}