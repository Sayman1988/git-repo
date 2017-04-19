package com.arithmetic.operations.impl;

import com.arithmetic.operations.Operation;

/**
 * @author Oleksandr Serogin
 */
public class Subtraction implements Operation {
    public double calculate(double value1, double value2) {
        return value1 - value2;
    }
}
