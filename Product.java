public class Product {
   final private String name;
   final private Integer rate;
   final private Integer price;

    public Product(String name, Integer rate, Integer price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public Integer getPrice() {
        return price;
    }

    public Integer getRate() {
        return rate;
    }


}
