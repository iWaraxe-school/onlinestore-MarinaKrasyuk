import com.github.javafaker.Faker;
import storepopulate.Category;

public  class RandomStorePopulator {

private final Faker faker = new Faker();

public String getProductName(Category category)
{
    switch (category.getCategoryName()) {
        case "categories.Food":
            return faker.food().dish().toString();
        case "categories.Book" :
            return faker.book().title();
        case "toys" :
            return faker.animal().name();
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
