package com.arithmetic;

import com.arithmetic.factory.OperationFactory;
import com.arithmetic.operations.impl.Addition;
import com.arithmetic.operations.impl.Division;
import com.arithmetic.operations.impl.Multiplication;
import com.arithmetic.operations.impl.Subtraction;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Oleksandr Serogin
 */

public class CalculatorTest {
    private OperationFactory factory = new OperationFactory();

    @Test
    public void addition1() throws Exception{
        assertTrue(factory.getOperation("+") instanceof Addition);
    }

    @Test
    public void addition2() throws Exception{
        assertEquals(new Calculator(10, "+", 10).calculate(), 20.0);
    }

    @Test
    public void substraction1() throws Exception{
        assertTrue(factory.getOperation("-") instanceof Subtraction);
    }

    @Test
    public void substraction2() throws Exception{
        assertEquals(new Calculator(10, "-", 10).calculate(), 0.0);
    }

    @Test
    public void multiplication1() throws Exception{
        assertTrue(factory.getOperation("*") instanceof Multiplication);
    }

    @Test
    public void multiplication2() throws Exception{
        assertEquals(new Calculator(10, "*", 10).calculate(), 100.0);
    }

    @Test
    public void division1() throws Exception{
        assertTrue(factory.getOperation("/") instanceof Division);
    }

    @Test
    public void division2() throws Exception{
        assertEquals(new Calculator(10, "/", 10).calculate(), 1.0);
    }

    @Test(expected = MissedOperatorException.class)
    public void illegalOperator() throws Exception{
        new Calculator(10, "%", 10).calculate();
    }

}
