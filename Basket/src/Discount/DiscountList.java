package Discount;

import java.util.HashMap;
import java.util.Map;

public class DiscountList {
    public static Map<String,Discount> discountMap = new HashMap<>();
    static{
        discountMap.put("5for300", new Discount5for300Price());
        discountMap.put("2and3free", new Discount2and3Free());
        discountMap.put("mug", new DiscountMug());
        discountMap.put("30Product", new Discount30Product());

    }
    public DiscountList(){

    }
    public static void  addDiscount(String discountName, Discount discount){
        if(!(discountMap.containsKey(discountName))){
            discountMap.put(discountName,discount);
        }else {
            throw new IllegalArgumentException("exist");
        }
    }
    public static void  deleteDiscount (String discountName){
        if(discountMap.containsKey(discountName)){
            discountMap.remove(discountName);
        }else {
            throw new IllegalArgumentException("not exist");
        }
    }

}
