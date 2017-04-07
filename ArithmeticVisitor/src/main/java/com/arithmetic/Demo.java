package com.arithmetic;

/**
 * @author Oleksandr Serogin
 */
public class Demo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(1, 1, "  +   ");
        System.out.println(calculator.calculate());
    }


}
