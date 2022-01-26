package storepopulate;


import categories.Book;
import categories.Categories;
import categories.Food;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class CategoryFactory {
    Map<Category, Integer> categorylist = new HashMap<Category, Integer>();

    public Map<Category, Integer> createCategory(Categories type) {

    Category category = null;
        switch (type) {
            case Book:
                category=new Book();
                break;
            case Food:
                category=new Food();
                break;
        }
        Random random = new Random();
        categorylist.put(category,random.nextInt(10));
                return categorylist;
    }
}