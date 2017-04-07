package com.arithmetic.visitor;

import com.arithmetic.operations.Addition;
import com.arithmetic.operations.Subtraction;
import lombok.Getter;

/**
 * @author Oleksandr Serogin
 */

public class VisitorImpl implements Visitor {
    @Getter private double result;

    public void visit(Addition addition) {
        result = addition.getValue1() + addition.getValue2();
    }

    public void visit(Subtraction subtraction) {
        result = subtraction.getValue1() - subtraction.getValue2();
    }
}
