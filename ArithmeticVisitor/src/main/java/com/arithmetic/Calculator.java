package com.arithmetic;

import com.arithmetic.visitor.VisitorImpl;
import com.arithmetic.operations.Addition;
import com.arithmetic.operations.Subtraction;
import lombok.AllArgsConstructor;

/**
 * @author Oleksandr Serogin
 */
@AllArgsConstructor
public class Calculator {
    private double value1;
    private double value2;
    private String operator;

    public double calculate() {
        VisitorImpl visitor = new VisitorImpl();
        // Addition
        if (operator.trim().equals("+")) {new Addition(value1, value2).accept(visitor);}
        // Subtraction
        else if (operator.trim().equals("-")) {new Subtraction(value1, value2).accept(visitor);}

        return visitor.getResult();
    }
}
