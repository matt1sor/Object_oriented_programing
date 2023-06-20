package Koszyk;

public class Product {

    public String code;
    public String name;
    public Double price;
    public Integer amount = 1;
    public Double discount = 0.0;

    public Product(String code, String name, Double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
    public void moreItem(){
        this.amount+=1;
    }
}
