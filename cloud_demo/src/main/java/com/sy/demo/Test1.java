package com.sy.demo;

import java.util.LinkedList;

/**
 * @author siyuan
 * @create 2020/7/14
 */
public class Test1 {
    public static void main(String[] args) {
//        ring(10, 5);
        s1();
    }

    public static void s1() {
        String s = "goodgoogle";
        String t = "google";
        int isfind = 0;

        for (int i = 0; i < s.length() - t.length() + 1; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                int jc = 0;
                for (int j = 0; j < t.length(); j++) {
                    if (s.charAt(i + j) != t.charAt(j)) {
                        break;
                    }
                    jc = j;
                }
                if (jc == t.length() - 1) {
                    isfind = 1;
                }
            }
        }
        System.out.println(isfind);
    }

    public static void ring(int n, int m) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        int k = 2;
        int element = 0;
        int i = 0;
        for (; i<k; i++) {
            element = q.poll();
            q.add(element);
        }
        i = 1;
        while (q.size() > 0) {
            element = q.poll();
            if (i < m) {
                q.add(element);
                i++;
            } else {
                i = 1;
                System.out.println(element);
            }
        }
    }

}
