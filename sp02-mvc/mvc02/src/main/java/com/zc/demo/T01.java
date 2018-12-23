package com.zc.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T01 {
    @Test
    public void test01() {
        Set<Integer> destGroupIdSet = new HashSet<Integer>() {
            {
                add(7);
                add(64);
                add(181);
            }
        };
    }

    @Test
    public void testSplit() {
        String s1 = "";
        String s2 = "GV";
        String s3 = "GV|AG|NA";
        String[] arr = s1.split("\\|");
        System.out.println(Arrays.toString(s1.split("\\|")));
        System.out.println(Arrays.toString(s2.split("\\|")));
        System.out.println(Arrays.toString(s3.split("\\|")));
    }
}

