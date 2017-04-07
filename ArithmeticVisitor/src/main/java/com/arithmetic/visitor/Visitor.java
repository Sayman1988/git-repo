package com.arithmetic.visitor;

import com.arithmetic.operations.Addition;
import com.arithmetic.operations.Subtraction;

/**
 * @author Oleksandr Serogin
 */

public interface Visitor{
    public void visit(Addition addition);
    public void visit(Subtraction subtraction);
}