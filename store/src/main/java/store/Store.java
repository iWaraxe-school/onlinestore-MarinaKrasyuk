package store;

import categories.Category;
import org.xml.sax.SAXException;
import storepopulate.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class Store {
    List <Category> categorylist;
    static Trash trash;


    public Store(List<Category> categorylist,Trash trash) {
        this.categorylist = categorylist;
        this.trash=trash;

    }
    public Trash getTrash(){
        return trash;
    }

    public void sortProduct() throws IOException, SAXException, ParserConfigurationException {
        for (Category c: categorylist){
            List <Product> sortList=c.sortProductList(c.getProductlist());
            c.println(sortList);
        }
    }
    public static String addToCart(Product product){
        trash.addToTrash(product);
        return "Success";
    }
     public Product findProduct(String name){
         boolean  isFindProduct=false;
         Optional<Product> findproduct=null;
         List<Product>  productlist = new ArrayList<>();
         while (isFindProduct==false){
             for (Category c: categorylist) {
                 productlist = c.getProductlist();
                 findproduct = productlist.stream()
                     .filter(p -> p.getName().contains(name))
                     .findFirst();
              if (!findproduct.isEmpty()) {
                 isFindProduct = true;
                  break;
              }
         }
         }
       return findproduct.get();
    }
    public void top() {
        List<Product> productList = new ArrayList<>();
        for (Category c: categorylist) {
            productList.addAll(c.getProductlist());
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

    public void printStore()
    {
        for (Category c: categorylist){
            List<Product> productlist=c.getProductlist();
            c.println(productlist);
        }
    }

}
