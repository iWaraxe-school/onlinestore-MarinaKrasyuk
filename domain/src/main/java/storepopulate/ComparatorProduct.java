package storepopulate;

import java.util.Comparator;
import java.util.List;

public class ComparatorProduct implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public static Comparator<Product> getComparator(String sortKey) {
        if("name".equals(sortKey)) {
            return Comparator.comparing(Product::getName);
        } else if ("price".equals(sortKey)) {
            return Comparator.comparing(Product::getPrice);
        } else if ("rate".equals(sortKey)) {
            return Comparator.comparing(Product::getRate);
        } else {
            throw new IllegalArgumentException();
        }
    }



}
