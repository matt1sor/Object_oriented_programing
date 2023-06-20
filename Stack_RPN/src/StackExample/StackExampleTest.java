package StackExample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackExampleTest {

    static StackExample<String> stack;

    @BeforeEach
    public void setupStack(){
        stack = new StackExample<String>(8);
    }


    @Test
    @DisplayName("Create new Stack")
    void test1(){
        assertEquals(true, stack.empty() );
        assertEquals(8,stack.capacityOfStack());
    }


    @Test
    @DisplayName("Push element to an empty Stack")
    void test2() {
        assertEquals(true, stack.empty() );
        stack.push("one");
        assertEquals(1, stack.sizeOfStack());
        assertEquals("one",stack.peek());


    }

    @Test
    @DisplayName("Push element to Stack with existing element")
    void test3() {
        assertEquals(true, stack.empty() );
        stack.push("one");
        stack.push("two");
        assertEquals(2, stack.sizeOfStack());
        assertEquals("two", stack.peek() );

    }

    @Test
    @DisplayName("Pop element from Stack")
    void test4() {

        assertEquals(true, stack.empty() );
        stack.push("one");
        assertEquals(1,stack.sizeOfStack());
        assertEquals("one",stack.pop());
        assertEquals(true, stack.empty() );

    }

    @Test
    @DisplayName("Pop element from empty Stack")
    void test5(){

        assertEquals(true, stack.empty() );
        assertThrows(EmptyStackException.class, stack::pop);

    }

    @Test
    @DisplayName("Peek element from empty Stack")
    void test6() {

        assertEquals(true, stack.empty() );
        assertThrows(EmptyStackException.class, stack::pop);

    }

    @Test
    @DisplayName("Peek element from Stack")
    void test7(){

        assertEquals(true, stack.empty() );
        stack.push("one");
        assertEquals("one",stack.peek());
    }

}

