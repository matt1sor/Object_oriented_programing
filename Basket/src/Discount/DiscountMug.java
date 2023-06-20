package Discount;
import Koszyk.*;
public class DiscountMug  implements Discount{

    @Override
    public double discountPrice(Koszyk koszyk) {
        return 0.0;
    }

    @Override
    public boolean free(Koszyk koszyk) {
        if(koszyk.price() > 200.00){
            return true ;
        }
        return false;
    }
}
