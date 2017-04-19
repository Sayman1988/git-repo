package com.arithmetic;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

/**
 * @author Oleksandr Serogin
 */

public class CalculatorTest {
    @Test
    public void addition() throws Exception{
        assertEquals(new Calculator(10, "+", 10).calculate(), 20.0);
    }

    @Test
    public void substraction() throws Exception{
        assertEquals(new Calculator(10, "-", 10).calculate(), 0.0);
    }

    @Test
    public void multiplication() throws Exception{
        assertEquals(new Calculator(10, "*", 10).calculate(), 100.0);
    }

    @Test
    public void division() throws Exception{
        assertEquals(new Calculator(10, "/", 10).calculate(), 1.0);
    }

    @Test(expected = MissedOperatorException.class)
    public void illegalOperator() throws Exception{
        new Calculator(10, "%", 10).calculate();
    }

}
