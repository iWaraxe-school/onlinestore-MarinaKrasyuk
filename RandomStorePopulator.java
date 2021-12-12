import com.github.javafaker.Cat;
import com.github.javafaker.Faker;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Locale;

public  class RandomStorePopulator {

private final Faker faker = new Faker();

public String getProductName(Category category)
{
    switch (category.getCategory_name()) {
        case "Food":
            return faker.food().dish().toString();
        case "Book" :
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
