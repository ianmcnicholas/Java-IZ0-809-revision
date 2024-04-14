import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyUnitTest {
    @Test
    public void testConcatenateTest() {
        MyUnit myUnit = new MyUnit();
        String result = myUnit.concatenate("one", "two");
        assertEquals("onetwo", result);
    }

    @Test
    public void fizzBuzzTest(){
        MyUnit myUnit = new MyUnit(); // create an instance of the class under test
        String result = myUnit.fizzbuzz(15); // run the method within the class to test
        assertEquals("Fizzbuzz", result); // perform an assertion on the result
    }
}