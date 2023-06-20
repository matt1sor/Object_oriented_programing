package Discount;
import Koszyk.*;

public class Discount2and3Free implements Discount{


    @Override
    public double discountPrice(Koszyk koszyk) {
        if(koszyk.size() == 3){
            if(koszyk.cheapest().price > koszyk.cheapest().discount){
                koszyk.cheapest().discount = koszyk.cheapest().price ;
            }
        }
        return 0.0;
    }
    @Override
    public boolean free(Koszyk koszyk) {
        return false;
    }


}
