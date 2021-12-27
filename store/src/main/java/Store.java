
import storepopulate.Category;
import storepopulate.Product;
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

            }
        }


    }
    public void printlnStore()
    {
        for (Map.Entry <Category,Integer> entry : categorylist.entrySet()){
            System.out.println("storepopulate.Category: ");
            entry.getKey().println();
        }
    }



}
