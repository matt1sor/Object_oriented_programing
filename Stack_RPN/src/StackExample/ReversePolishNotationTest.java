package StackExample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationTest {

    ReversePolishNotation calculator ;

    @BeforeEach
    public void setupStack(){
         calculator = new ReversePolishNotation();
    }


    @Test
    @DisplayName("Sum")
    void test1() {

        assertEquals(3, calculator.calcualte("1 2 +"));

    }


    @Test
    @DisplayName("Sub")
    void test2() {

        assertEquals(-1,calculator.calcualte("1 2 -"));

    }


    @Test
    @DisplayName("Multiply")
    void test3() {

        assertEquals(2,calculator.calcualte("1 2 *"));

    }
    @Test
    @DisplayName("Divide")
    void test4() {

        assertEquals(2,calculator.calcualte("6 3 /"));

    }

    @Test
    @DisplayName("Wrong input")
    void test5(){
        assertThrows(NumberFormatException.class, ()-> calculator.calcualte("2 _ 3 +"));
    }


    @Test
    @DisplayName("Two operations")
    void test6(){
        assertEquals(3,calculator.calcualte("6 3 + 3 /"));
    }

    @Test
    @DisplayName("Three operations")
    void test7(){
        assertEquals(9,calculator.calcualte("6 3 + 3 / 3 * "));
    }

    @Test
    @DisplayName("All operations at once")
    void test8(){
        assertEquals(8,calculator.calcualte("6 3 + 3 / 3 * 1 -"));
    }







}