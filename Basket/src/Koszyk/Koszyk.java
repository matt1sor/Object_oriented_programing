package Koszyk;

import Discount.Discount;
import Discount.DiscountList;
import Sort.SortByPrice;
import Sort.SortList;
import Sort.SortPriceName;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Koszyk {
    public List<Product> koszyk;
    public boolean mug;


    public Koszyk(List<Product> koszyk){
        this.koszyk = koszyk;

    }

    public Integer size(){
       int size = 0;
        if(this.koszyk.size() > 0) {
            for (Product product : this.koszyk){
                size += product.amount;
            }
        }
        return size ;
    }
    private Product contain(Product product){
        for (Product obj : this.koszyk) {
            if (obj.code.equals(product.code)) {
                return obj;
            }
        }
        return null;
    }

    public void add(Product product){
        if (this.size() == 0 || contain(product)== null ){
            this.koszyk.add(product);

        }else if (contain(product) != null){
            if(contain(product).name.equals(product.name) && contain(product).price.equals(product.price)  ) {
                int index = this.koszyk.indexOf(contain(product));
                product.moreItem();
                this.koszyk.set(index, product);
            }else{
                throw new IllegalArgumentException("product code exist");
            }
        }else{
            throw new IllegalArgumentException("product code exist");
        }
        this.koszyk.sort(new SortPriceName());
    }

    public Product cheapest() {
        return cheapest(1).get(0);
    }
    public List<Product> cheapest(int n) {
        List<Product> helper = new ArrayList<>(this.koszyk);

        helper.sort(new SortByPrice());
        return helper.subList(0,n);
    }

    public Product expensive() {
        return expensive(1).get(0);
    }
    public List<Product> expensive(int n){
        List<Product> helper = new ArrayList<>(this.koszyk);

        helper.sort(new SortByPrice().reversed());
        return helper.subList(0,n);
    }

    public void Sort(String sortName) {
        this.koszyk.sort(SortList.getSort(sortName));
    }
    public void addSort(String sortName, Comparator<Product> sort) {
         SortList.addSort(sortName,sort);
    } public void deleteSort(String sortName)  {
        SortList.deleteSort(sortName);
    }
    public double price() {
        double price = 0.0;
        for (Product obj : this.koszyk) {
            price += obj.amount*obj.price - obj.discount;
        }
        return price;
    }

    public double discountPrice() {
        double discounts = 0.0;
        Koszyk kosz= new Koszyk(this.koszyk);
        for (Discount key : DiscountList.discountMap.values()) {
            key.discountPrice(kosz) ;
            mug = key.free(kosz);
            if (key.discountPrice(kosz)  != 0.0) {
                discounts+= key.discountPrice(kosz);
            }
        }
        for (Product obj : this.koszyk) {
                discounts += obj.discount;
        }
        if(mug){
            this.koszyk.add( new Product("mug", "mug", 0.0)) ;
        }
        return discounts;
    }

    public double discount() {
    return price() - discountPrice() ;
    }
}
