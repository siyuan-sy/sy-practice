package com.sy.excel.demo;

/**
 * @author siyuan
 * @create 2020/7/2
 */
public class Demo1 {

    public static void main(String[] args) {
        int[] a = {1,2,2,1,1,4,1,5,1,2,2};
        int result = a[0];
        int times = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != result) {
                times--;
            }
            else {
                times++;
            }
            if (times == -1) {
                times = 1;
                result = a[i];
            }
        }
        System.out.println(result);
    }

}
