import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import storepopulate.Category;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class StoreHelper {

    Reflections reflections = new Reflections ("categories", new SubTypesScanner(false));
    Map<Category, Integer> categorylist = new HashMap<Category, Integer>();
    private static StoreHelper instance;

    private StoreHelper() {
    }

    public static StoreHelper getInstance()
    {
        if (instance==null){
            instance=new StoreHelper();
        }
        return instance;
    }

    public Map<Category, Integer> reflectionCategory()
    {
        Set<Class<? extends Category>> allClasses =
                reflections.getSubTypesOf(Category.class);

        for (Class<? extends Category> cl : allClasses) {
            try{
                Random random = new Random();
                categorylist.put(cl.getConstructor().newInstance(),random.nextInt(10));
            }
            catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


        }

        return categorylist;
    }


}
