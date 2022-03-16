package populator;

import http.Client;
import categories.Category;
import store.Store;
import storepopulate.Product;
import java.io.IOException;
import java.util.List;

public class HttpPopulator implements Populator{
    public final static Client client=new Client();

    @Override
    public List<Category> getALLCategory() throws IOException {
        return client.getAllCategories();
    }

    @Override
    public void addToCart(Product product, Store store) {
        client.addProductToCart(product,store);
    }


}
