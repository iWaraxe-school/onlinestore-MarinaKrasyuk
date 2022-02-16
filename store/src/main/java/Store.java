import org.xml.sax.SAXException;
import storepopulate.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Store {
    Map <Category,Integer> categorylist;


    public Store(Map<Category, Integer> categorylist) {
        this.categorylist = categorylist;
    }

    public void fillStore(Map <Category,Integer> categorylist) {
        RandomStorePopulator faker = RandomStorePopulator.getInstance(); //Singleton
        int id= 0;
        DBConnector.connection();
        for (Map.Entry<Category, Integer> entry : categorylist.entrySet()) {
            id++;
            try {
                DBConnector.insertCategoryTable(id, entry.getKey().getCategoryName());

                for (int i = 0; i < entry.getValue(); i++) {
                    Product product = new Product(
                            faker.getProductName(entry.getKey()),
                            faker.getRate(),
                            faker.getPrice(1.0, 10.0));
                    entry.getKey().addProductToCategory(product);
                    DBConnector.insertProductTable(id, product);

                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        DBConnector.closeConnection();
    }

    public void sortProduct() throws IOException, SAXException, ParserConfigurationException {
        for (Map.Entry <Category,Integer> entry : categorylist.entrySet()) {
             List <Product> sortList= entry.getKey().sortProductList(entry.getKey().getProductlist());
             entry.getKey().println(sortList);
        }

    }

    public Product findProduct(String name){
        List<Product> productlist = new ArrayList<>();
        for (Map.Entry <Category,Integer> entry : categorylist.entrySet()){
            productlist.addAll(entry.getKey().getProductlist());
        }
        Optional<Product> findproduct= productlist.stream()
                .filter(p->p.getName().contains(name))
                        .findFirst();
       return findproduct.get();
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
            System.out.println("Category: " + entry.getKey().getCategoryName());
            entry.getKey().println(entry.getKey().getProductlist());
        }
    }


}
