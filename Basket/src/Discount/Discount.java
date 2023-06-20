package Discount;
import Koszyk.*;
public interface Discount {


    double discountPrice(Koszyk koszyk);

    boolean free(Koszyk koszyk);
}
