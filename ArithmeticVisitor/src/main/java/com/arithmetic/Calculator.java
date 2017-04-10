package com.arithmetic;

import com.arithmetic.operations.Addition;
import com.arithmetic.operations.Division;
import com.arithmetic.operations.Multiplication;
import com.arithmetic.visitor.VisitorImpl;
import com.arithmetic.operations.Subtraction;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Oleksandr Serogin
 */
@Slf4j
@AllArgsConstructor
public class Calculator {
    private double value1;
    @Setter private String operator;
    private double value2;

    public double calculate() throws Exception {
        final VisitorImpl visitor = new VisitorImpl();
        log.info("Try to find next expression result: " + value1 + " " + operator + " " + value2);

        // Add
        if (operator.trim().equals("+")) {new Addition(value1, value2).accept(visitor);}
        // Subtract
        else if (operator.trim().equals("-")) {new Subtraction(value1, value2).accept(visitor);}
        // Multiply
        else if (operator.trim().equals("*")) {new Multiplication(value1, value2).accept(visitor);}
        // Divide
        else if (operator.trim().equals("/")) {new Division(value1, value2).accept(visitor);}
        //else raise MissedOperatorException
        else {
            log.error("Operator \"" + operator + "\" can't be resolved or doesn't applied for this calculation method");
            throw new MissedOperatorException("Check input operator \"" + operator + "\"");
        }

        return visitor.getResult();
    }
}
