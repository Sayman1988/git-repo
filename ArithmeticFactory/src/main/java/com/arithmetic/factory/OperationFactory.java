package com.arithmetic.factory;

import com.arithmetic.MissedOperatorException;
import com.arithmetic.operations.*;
import com.arithmetic.operations.impl.Addition;
import com.arithmetic.operations.impl.Division;
import com.arithmetic.operations.impl.Multiplication;
import com.arithmetic.operations.impl.Subtraction;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleksandr Serogin
 */
@Slf4j
public class OperationFactory {
    private Map<String, Operation> operationCatalog = new HashMap <String, Operation>() {{
        put("+", new Addition());
        put("-", new Subtraction());
        put("*", new Multiplication());
        put("/", new Division());
    }};

    public Operation getOperation(String operator) throws MissedOperatorException {
        if (operationCatalog.containsKey(operator)) return operationCatalog.get(operator);
        //if operator isn't defined in the operation catalog raise exception
        log.error("Operator \"{}\" can't be resolved or doesn't applied for this calculation method", operator);
        throw new MissedOperatorException("Check input operator \"" + operator + "\"");
    }
}
