package com.arithmetic.operations;

import com.arithmetic.visitor.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Oleksandr Serogin
 */
@AllArgsConstructor
public class Divide implements Operation {
    @Getter private double value1;
    @Getter private double value2;

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
