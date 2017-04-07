package com.arithmetic.operations;

import com.arithmetic.visitor.Visitor;

/**
 * @author Oleksandr Serogin
 */
public interface Operation {
    void accept(Visitor visitor);
}