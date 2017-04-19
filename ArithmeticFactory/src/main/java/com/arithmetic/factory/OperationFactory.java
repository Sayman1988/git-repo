package com.arithmetic.factory;

import com.arithmetic.MissedOperatorException;
import com.arithmetic.operations.*;
import com.arithmetic.operations.impl.Addition;
import com.arithmetic.operations.impl.Division;
import com.arithmetic.operations.impl.Multiplication;
import com.arithmetic.operations.impl.Subtraction;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Oleksandr Serogin
 */
@Slf4j
public class OperationFactory {
    public Operation getOperation(String operator) throws MissedOperatorException {
        switch (operator) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
        }
        log.error("Operator \"" + operator + "\" can't be resolved or doesn't applied for this calculation method");
        throw new MissedOperatorException("Check input operator \"" + operator + "\"");
    }
}
