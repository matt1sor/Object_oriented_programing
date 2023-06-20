package Discount;

import Koszyk.Koszyk;

public class Discount5for300Price implements Discount{


    @Override
    public boolean free(Koszyk koszyk) {
        return false;
    }

    @Override
    public double discountPrice(Koszyk koszyk) {
        return koszyk.price() > 300.00 ? koszyk.price() * 0.05 : 0.0;

    }
}
