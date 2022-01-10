package storepopulate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// to do abstract
public class Category {
    private String categoryName;
    private  final List<Product> productlist = new ArrayList<Product>();
    private final List<Product> sortproductlist = new ArrayList<Product>();



    public Category(String categoryName) {
        this.categoryName = categoryName;

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addProductToCategory(Product product){

        productlist.add(product);

    }

    public void createSortList(Product product)
    {
        sortproductlist.add(product);
    }


    public void sortProductByName(String field, String sort){
        Comparator comparator;
        switch(field){
            case "price":
                if (sort.equals("asc"))
                 comparator=new PriceComparatorAsc();
                else
                    comparator =new PriceComparatorDesc();
                 break;
            case "name":
                if (sort.equals("asc"))
                 comparator=new NameComparatorAsc();
                else
                    comparator=new NameComparatorDesc();
                 break;
            case "gate":
                if (sort.equals("asc"))
                    comparator=new PriceComparatorAsc();
                else
                    comparator =new PriceComparatorDesc();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + field);
        }

        Collections.sort(sortproductlist,comparator);

    }
    public void printlnAfterSort(){
        for (int i = 0; i< sortproductlist.size(); i++)
        {
            System.out.println(this.categoryName +" "+ sortproductlist.get(i).getName()+" "+ sortproductlist.get(i).getRate()+" "+ sortproductlist.get(i).getPrice());

        }

    }
    public void printTop(){
        int size;
        Comparator comparator=new PriceComparatorAsc();
        Collections.sort(sortproductlist,comparator);

        if ( sortproductlist.size()<=5) {
           size= sortproductlist.size();
        }
        else
            size=5;
            for (int i = 0; i < size; i++) {

                System.out.println(this.categoryName + " " + sortproductlist.get(i).getName() + " " + sortproductlist.get(i).getRate() + " " + sortproductlist.get(i).getPrice());

            }
    }
    public void println(){
        for (int i = 0; i< productlist.size(); i++)
        {
            System.out.println(this.categoryName +" "+ productlist.get(i).getName()+" "+ productlist.get(i).getRate()+" "+ productlist.get(i).getPrice());

        }

    }

}
