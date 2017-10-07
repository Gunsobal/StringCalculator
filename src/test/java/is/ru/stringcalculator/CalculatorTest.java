package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest
{
    @Test
    public void itReturnsZeroForEmptyString() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void itReturnsTheNumberForSingleNumbers(){
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void itReturnsTheSumOfTwoNumbers(){
        assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    public void itReturnsTheSumOfUnknownManyNumbers(){
        assertEquals(6, Calculator.add("1,2,3"));
    }
}