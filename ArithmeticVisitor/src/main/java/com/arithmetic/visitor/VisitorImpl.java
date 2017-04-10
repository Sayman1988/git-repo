package com.arithmetic.visitor;

import com.arithmetic.operations.Add;
import com.arithmetic.operations.Divide;
import com.arithmetic.operations.Multiply;
import com.arithmetic.operations.Subtract;
import lombok.Getter;

/**
 * @author Oleksandr Serogin
 */

public class VisitorImpl implements Visitor {
    @Getter private double result;

    public void visit(Add add) {
        result = add.getValue1() + add.getValue2();
    }

    public void visit(Subtract subtract) {
        result = subtract.getValue1() - subtract.getValue2();
    }

    public void visit(Divide divide) {
        result = divide.getValue1() / divide.getValue2();
    }

    public void visit(Multiply multi) {
        result = multi.getValue1() * multi.getValue2();
    }
}
