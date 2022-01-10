import org.xml.sax.SAXException;
import storepopulate.Category;
import storepopulate.Product;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
                entry.getKey().createSortList(product);

            }
        }


    }


    public void sortProduct() throws IOException, SAXException, ParserConfigurationException {
        Parsing parsing=new Parsing();
        Map<String,String> sortmap= new HashMap<>();
        sortmap=parsing.parse();
        for (Map.Entry <Category,Integer> entry : categorylist.entrySet()){

            for (Map.Entry <String,String> entry1 : sortmap.entrySet()){
                System.out.println("Order BY     "+entry1.getKey()+"   "+ entry1.getValue());
                entry.getKey().sortProductByName(entry1.getKey(),entry1.getValue());
                entry.getKey().printlnAfterSort();
            }

        }
    }
    public void top() throws ParserConfigurationException, SAXException, IOException {
        for (Map.Entry <Category,Integer> entry : categorylist.entrySet()){
            System.out.println("Top five of Product:    ");
            entry.getKey().printTop();
        }

    }

    public void printlnStore()
    {
        for (Map.Entry <Category,Integer> entry : categorylist.entrySet()){
            System.out.println("storepopulate Category: ");
            entry.getKey().println();
        }
    }



}
