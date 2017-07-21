package com.localhost;

/**
 * Created by o.serohin on 11.07.2017.
 */
public class UnknownCellTypeException extends Exception {
    public UnknownCellTypeException(String cellType) {
        super("Unknown cell type '" + cellType + "' found. Raise exception");
    }
}
