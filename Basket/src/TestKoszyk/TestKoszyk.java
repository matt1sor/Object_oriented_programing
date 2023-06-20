package TestKoszyk;

import Koszyk.Koszyk;
import Koszyk.Product;

import Discount.Discount5for300Price;
import Discount.DiscountMug;

import Sort.SortPriceName;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


public class TestKoszyk {
    private Koszyk koszyk;
    private Product bread;
    private Product cheese;

    @BeforeEach
    void setUp(){
        koszyk = new Koszyk(new ArrayList<>());
        bread = new Product("001", "bread", 21.00);
        cheese = new Product("002", "cheese", 10.00);
        koszyk.add(bread);
        koszyk.add(cheese);
    }


    @Test
    void testAddMoreItem(){
        Assertions.assertEquals(Optional.of(2), Optional.ofNullable(koszyk.size()));
    }
    @Test
    void testSortPriceName(){
        Product orange = new Product("003", "orange", 21.00);
        Product butter = new Product("004", "butter", 21.60);
        koszyk.add(orange);
        koszyk.add(butter);
        Assertions.assertEquals(Arrays.asList(butter,bread,orange, cheese), koszyk.koszyk);
    }

    @Test
    void  testAddTheSameCodeDifferentItem(){
        Product product3 = new Product("001", "name2", 21.00);
        Assertions.assertThrows(IllegalArgumentException.class, () -> koszyk.add(product3));
    }

    @Test
    void testAddTheSameCode(){
        Product bread = new Product("001", "bread", 21.00);
        koszyk.add(bread);
        Assertions.assertEquals(Optional.of(3), Optional.ofNullable(koszyk.size()));
    }
    @Test
    void testCheapest(){
        Assertions.assertEquals(cheese, koszyk.cheapest());
    }

    @Test
    void testExpensive(){
        Assertions.assertEquals(bread, koszyk.expensive());
    }

    @Test
    void testManyCheapest(){
        Assertions.assertEquals(Arrays.asList(cheese, bread), koszyk.cheapest(2));
    }

    @Test
    void testManyExpensive(){
        Assertions.assertEquals(Arrays.asList(bread, cheese), koszyk.expensive(2));
    }
    @Test
    void testSortByNameDown(){
        koszyk.Sort("NameDown");
        Assertions.assertEquals(Arrays.asList(bread, cheese), koszyk.koszyk);
    }
    @Test
    void testSortByNameUp(){
        koszyk.Sort("NameUp");
        Assertions.assertEquals(Arrays.asList(cheese, bread), koszyk.koszyk);
    }
    @Test
    void testSortByPriceLow(){
        koszyk.Sort("PriceDown");
        Assertions.assertEquals(Arrays.asList(cheese, bread), koszyk.koszyk);
    }

    @Test
    void testSortByPriceHigh(){
        koszyk.Sort("PriceUp");
        Assertions.assertEquals(Arrays.asList(bread, cheese), koszyk.koszyk);
    }
    @Test
    void testSortByPriceDownNameDown(){
        koszyk.addSort("PriceDownNameDown", new SortPriceName());
        koszyk.Sort("PriceDownNameDown");
        Assertions.assertEquals(Arrays.asList(bread, cheese), koszyk.koszyk);
        koszyk.deleteSort("PriceDownNameDown");
        Assertions.assertThrows(IllegalArgumentException.class, () -> koszyk.Sort("PriceDownNameDown"));


    }

    @Test
    void testSumAllProduct(){
        Assertions.assertEquals(31.00, koszyk.price(), 0.00001);
    }

    @Test
    void testDiscountPrice300(){
        Product product3 = new Product("003", "name2", 300.00);
        koszyk.add(product3);

        Assertions.assertEquals(16.55, new Discount5for300Price().discountPrice(koszyk), 0.00001);
    }
    @Test
    void testDiscountThirdItem(){
        Product product3 = new Product("003", "name2", 300.00);
        koszyk.add(product3);
        koszyk.discountPrice();

        Assertions.assertEquals(10, cheese.discount, 0.00001);
    }
    @Test
    void testDiscountMug(){
        Product product3 = new Product("003", "name2", 300.00);
        koszyk.add(product3);
        koszyk.discountPrice();

        Assertions.assertTrue(new DiscountMug().free(koszyk));
    }

    @Test
    void testDiscount30(){
        Product product3 = new Product("003", "name2", 300.00);
        koszyk.add(product3);
        koszyk.discountPrice();
        Assertions.assertEquals(6.3, bread.discount, 0.00001);
    }

    @Test
    void testDiscount(){
        Product product3 = new Product("003", "name2", 300.00);
        koszyk.add(product3);
        Assertions.assertEquals(298.465, koszyk.discount(), 0.00001);
    }




}
