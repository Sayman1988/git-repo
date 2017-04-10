package com.arithmetic;

import com.arithmetic.operations.Division;
import com.arithmetic.operations.Multiplication;
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
    private String operator;
    private double value2;

    public double calculate() throws Exception {
        VisitorImpl visitor = new VisitorImpl();

        // Addition
        if (operator.trim().equals("+")) {new Addition(value1, value2).accept(visitor);}
        // Subtraction
        else if (operator.trim().equals("-")) {new Subtraction(value1, value2).accept(visitor);}
        // Multiplication
        else if (operator.trim().equals("*")) {new Multiplication(value1, value2).accept(visitor);}
        // Division
        else if (operator.trim().equals("/")) {new Division(value1, value2).accept(visitor);}

        //else raise MissedOperatorException
        else throw new MissedOperatorException("Operator \"" + operator + "\" can't be resolved or doesn't applied for this calculation method" );

        return visitor.getResult();
    }
}
