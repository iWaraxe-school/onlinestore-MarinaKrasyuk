package populator;

import categories.Category;
import jdk.jshell.spi.ExecutionControl;
import org.xml.sax.SAXException;
import store.Store;
import storepopulate.Product;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface Populator {
    List<Category> getALLCategory() throws IOException, ParserConfigurationException, SAXException;
    void addToCart(Product product, Store store);

}
