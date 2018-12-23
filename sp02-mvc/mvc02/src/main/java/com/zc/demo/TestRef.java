package com.zc.demo;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TestRef {
    /**
     * 只有map会改变
     * @param args
     */
    public static void main(String[] args) {
        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        Integer in = 1;
        String s = "s";
        int i = 1;

        print(map,in,s,i);
        ha(map, in, s, i);
        print(map,in,s,i);

        ha2(map, in, s, i);
        print(map,in,s,i);
    }

    public static void print(Map<String, BigDecimal> map, Integer in, String s, int i) {
        System.out.println("====");
        System.out.println(in);
        System.out.println(map);
        System.out.println(s);
        System.out.println(i);
    }

    public static void ha(Map<String, BigDecimal> map, Integer in, String s, int i) {
        map.put("a", new BigDecimal(1));
        in = 2;
        s = "ss";
        i = 2;
    }

    public static void ha2(Map<String, BigDecimal> map, Integer in, String s, int i) {
        map.put("b", new BigDecimal(1));
        in = Integer.valueOf(3);
        s = String.valueOf("sss");
        i = 3;
    }

    @Test
    public void testIsNum() {

    }
}
