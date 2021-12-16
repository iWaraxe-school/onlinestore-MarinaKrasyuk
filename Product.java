package storepopulate;

public class Product {
   final private String name;
   final private Double rate;
   final private Double price;

    public Product(String name, Double rate, Double price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getRate() {
        return rate;
    }



}
