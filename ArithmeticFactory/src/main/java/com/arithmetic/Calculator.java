package com.arithmetic;

import com.arithmetic.factory.OperationFactory;
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

    public double calculate () throws Exception{
        final OperationFactory factory = new OperationFactory();
        log.info("Try to find next expression result: " + value1 + " " + operator + " " + value2);

        // Add
        if (operator.trim().equals("+")) {return factory.createAddition().add(value1, value2);}
        // Subtract
        else if (operator.trim().equals("-")) {return factory.createSubstraction().substract(value1, value2);}
        // Multiply
        else if (operator.trim().equals("*")) {return factory.createMultiplication().multiply(value1, value2);}
        // Divide
        else if (operator.trim().equals("/")) {return factory.createDivision().divide(value1, value2);}
        //else raise MissedOperatorException
        else {
            log.error("Operator \"" + operator + "\" can't be resolved or doesn't applied for this calculation method");
            throw new MissedOperatorException("Check input operator \"" + operator + "\"");
        }
    }
}
