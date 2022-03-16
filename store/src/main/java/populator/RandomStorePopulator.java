package populator;

import com.github.javafaker.Faker;
import categories.Category;

public  class RandomStorePopulator {

    private final Faker faker = new Faker();
    private static RandomStorePopulator instance;

    private RandomStorePopulator() {
    }
    public static RandomStorePopulator getInstance() //Singleton
    {
        if (instance==null){
            instance=new RandomStorePopulator();
        }
        return instance;
    }

    public String getProductName(Category category)
    {
        switch (category.getCategoryName()) {
            case "Food":
                return faker.food().dish().toString();
            case "Book" :
                return faker.book().title();
            default: return "No This Items";
        }
    }
    public Double getPrice(double min, double max){

        double price =  min + (faker.random().nextDouble() * (max - min));
        return Math.round(price*100)/100D;
    }

    public Double getRate(){
        double rate = faker.random().nextDouble();
        return Math.round(rate*100)/100D;
    }

}
