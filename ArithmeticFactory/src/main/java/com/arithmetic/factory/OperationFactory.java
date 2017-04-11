package com.arithmetic.factory;

import com.arithmetic.operations.IDivision;
import com.arithmetic.operations.IMultiplication;
import com.arithmetic.operations.ISubstraction;
import com.arithmetic.operations.impl.Addition;
import com.arithmetic.operations.impl.Division;
import com.arithmetic.operations.impl.Multiplication;
import com.arithmetic.operations.IAddition;
import com.arithmetic.operations.impl.Subtraction;

/**
 * @author Oleksandr Serogin
 */
public class OperationFactory extends AbstrOperationFactory{
    public IAddition createAddition() {
        return new Addition();
    }

    public IDivision createDivision() {
        return new Division();
    }

    public IMultiplication createMultiplication() {
        return new Multiplication();
    }

    public ISubstraction createSubstraction() {
        return new Subtraction();
    }
}
