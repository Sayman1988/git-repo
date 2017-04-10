package com.arithmetic;

/**
 * @author Oleksandr Serogin
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator(3, "/", 5);
        System.out.println(calculator.calculate());
    }
}
