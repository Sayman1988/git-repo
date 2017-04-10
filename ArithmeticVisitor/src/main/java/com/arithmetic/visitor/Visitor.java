package com.arithmetic.visitor;

import com.arithmetic.operations.Add;
import com.arithmetic.operations.Divide;
import com.arithmetic.operations.Multiply;
import com.arithmetic.operations.Subtract;

/**
 * @author Oleksandr Serogin
 */

public interface Visitor {
    double getResult();

    void visit(Add add);
    void visit(Subtract subtract);
    void visit(Divide divide);
    void visit(Multiply multiply);

}