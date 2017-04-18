package com.arithmetic.factory;

import com.arithmetic.MissedOperatorException;
import com.arithmetic.operations.*;
import com.arithmetic.operations.impl.Addition;
import com.arithmetic.operations.impl.Division;
import com.arithmetic.operations.impl.Multiplication;
import com.arithmetic.operations.impl.Subtraction;

/**
 * @author Oleksandr Serogin
 */
public class OperationFactory {
    public Operation getOperation(String operator) throws MissedOperatorException {
        switch (operator.toCharArray()[0]) {
            case '+':
                return new AddOperation();
        }
        throw new MissedOperatorException();
    }
}
