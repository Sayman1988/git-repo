package com.arithmetic;

import com.arithmetic.factory.OperationFactory;
import com.arithmetic.operations.Operation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Oleksandr Serogin
 */
@Slf4j
public class Calculator {
    private double value1;
    private String operator;
    private double value2;

    private OperationFactory factory = new OperationFactory();

    public Calculator(double value1, String operator, double value2) {
        this.value1 = value1;
        this.operator = operator;
        this.value2 = value2;
    }

    public double calculate() throws Exception {
        log.info("Try to find next expression result: " + value1 + " " + operator + " " + value2);
        Operation operation = factory.getOperation(operator);
        return operation.calculate(value1, value2);
    }
}
