package com.arithmetic.visitor;

import com.arithmetic.operations.Addition;
import com.arithmetic.operations.Division;
import com.arithmetic.operations.Multiplication;
import com.arithmetic.operations.Subtraction;

/**
 * @author Oleksandr Serogin
 */

public interface Visitor {
    double getResult();

    void visit(Addition addition);
    void visit(Subtraction subtraction);
    void visit(Division division);
    void visit(Multiplication multiplication);

}