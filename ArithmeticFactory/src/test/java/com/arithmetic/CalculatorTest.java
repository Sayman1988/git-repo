package com.arithmetic;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Oleksandr Serogin
 */

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setupTestEnvironment() {
        calculator = new Calculator(10, null, 10);
    }

    @Test
    public void addition() throws Exception{
        assertEquals(new Calculator(10, "+", 10).calculate(), 20.0);
    }

    @Test
    public void substraction() throws Exception{
        calculator.setOperator(" - ");
        assertEquals(new Calculator(10, "-", 10).calculate(), 0.0);
    }

    @Test
    public void multiplication() throws Exception{
        calculator.setOperator(" * ");
        assertEquals(calculator.calculate(), 100.0);
    }

    @Test
    public void division() throws Exception{
        calculator.setOperator(" / ");
        assertEquals(calculator.calculate(), 1.0);
    }

    @Test(expected = MissedOperatorException.class)
    public void illegalOperator() throws Exception{
        calculator.setOperator(" % ");
        calculator.calculate();
    }

}
