package com.arithmetic.factory;

import com.arithmetic.operations.Operation;

/**
 * Created by aslobodyanyk on 18.04.2017.
 */
public class AddOperation implements Operation {
    public double calculate(double value1, double value2) {
        return value1 + value2;
    }
}
