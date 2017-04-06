package com.tdd;

import java.util.List;

/**
 * Created by aslobodyanyk on 17.03.2017.
 */
public class JoinedString {
    private final List<String> list;
    private final String separator;

    public JoinedString(List<String> list) {
        this(list, ",");
    }

    public JoinedString(List<String> list, String separator) {
        this.list = list;
        this.separator = separator;
    }

    public String string() {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str += (i == 0)? list.get(i) : separator + " " + list.get(i);
        }
        return str;
    }
}
