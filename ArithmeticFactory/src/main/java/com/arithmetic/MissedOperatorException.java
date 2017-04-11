package com.arithmetic;

/**
 * @author Oleksandr Serogin
 */

public class MissedOperatorException extends Exception {
    public MissedOperatorException(){}

    public MissedOperatorException(String message){
        super(message);
    }
}
