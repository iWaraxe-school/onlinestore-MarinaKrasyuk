//import jdk.jfr.Category;

import java.util.Map;

public class Store {
    Map <Category,Integer> category_list;

    public Store(Map<Category, Integer> category_list) {
        this.category_list = category_list;
    }

    public void fillStore(Map <Category,Integer> category_list){
        RandomStorePopulator faker = new RandomStorePopulator();

        for (Map.Entry <Category,Integer> entry : category_list.entrySet()){
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
        for (Map.Entry <Category,Integer> entry : category_list.entrySet()){
            System.out.println("Category: ");
            entry.getKey().println();
        }
    }



}
