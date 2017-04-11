package com.arithmetic.factory;

import com.arithmetic.operations.IAddition;
import com.arithmetic.operations.IDivision;
import com.arithmetic.operations.IMultiplication;
import com.arithmetic.operations.ISubstraction;

/**
 * @author Oleksandr Serogin
 */

public abstract class AbstrOperationFactory {
    public abstract IAddition createAddition();

    public abstract IDivision createDivision();

    public abstract IMultiplication createMultiplication();

    public abstract ISubstraction createSubstraction();
}
