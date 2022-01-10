package storepopulate;

import java.util.Comparator;

public class NameComparatorDesc   implements Comparator<Product>

{
    @Override
    public int compare(Product o1, Product o2) {
        int comp = o1.getName().compareTo(o2.getName());
        if (comp != 0) {    // names are different
            return -comp;
        }
        return 0;
    }
}
