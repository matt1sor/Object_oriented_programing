package Discount;
import Koszyk.*;
public class Discount30Product implements Discount{
    private String code = "001";

    @Override
    public double discountPrice(Koszyk koszyk) {
        for(Product obj : koszyk.koszyk){
            if(obj.code == code ){
                if(obj.price > obj.discount){
                    obj.discount = obj.price*0.3 ;

                }
            }

        }
        return 0.0;
    }



    @Override
    public boolean free(Koszyk koszyk) {
        return false;
    }
}
