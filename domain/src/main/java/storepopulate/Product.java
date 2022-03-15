package storepopulate;

public class Product {
     private String name;
     private Double rate;
     private Double price;
    public Product() {


    }
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
