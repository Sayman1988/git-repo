package com.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Oleksandr Serogin
 */

public class TDDPractice {

    public static String listAGG(List<String> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == 0)
                str = list.get(i);
            else str += ", " + list.get(i);
        }
        return str;
    }

    public static String strAGG(List<String> list) {
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0)
                strb.append(list.get(i));
            else strb.append(", " + list.get(i));
        }
        return strb.toString();
    }

    public static void main(String[] args) {
        List<String> input;
        if (args.length == 0)
            input = new ArrayList<>(Arrays.asList("Your", "input", "parameter", "list", "is empty"));
        else
            input = new ArrayList<>(Arrays.asList(args));

        //using String object
        System.out.println(listAGG(input));
        //using StringBuilder object
        System.out.println(strAGG(input));
    }
}
