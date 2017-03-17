package com.tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by aslobodyanyk on 17.03.2017.
 */
public class JoinedStringTest {
    @Test
    public void string() throws Exception {
        List<String> list = Arrays.asList("aaa", "bbb");
        JoinedString joinedString = new JoinedString(list);
        assertThat(joinedString.string(), equalTo("aaa, bbb"));
    }

    @Test
    public void string2() throws Exception {
        List<String> list = Arrays.asList("aaa");
        JoinedString joinedString = new JoinedString(list);
        assertThat(joinedString.string(), equalTo("aaa"));
    }

    @Test
    public void string3() throws Exception {
        List<String> list = Collections.emptyList();
        JoinedString joinedString = new JoinedString(list);
        assertThat(joinedString.string(), equalTo(""));
    }

    @Test
    public void string4() throws Exception {
        List<String> list = Arrays.asList("aaa", "bbb");
        JoinedString joinedString = new JoinedString(list, ";");
        assertThat(joinedString.string(), equalTo("aaa; bbb"));
    }

}