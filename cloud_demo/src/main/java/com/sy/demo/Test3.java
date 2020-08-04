package com.sy.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author siyuan
 * @create 2020/7/15
 */
public class Test3 {
    public static List<Demo> list = new ArrayList<>();

   static {
       list.add(new Demo("siyuan",1));
       list.add(new Demo("siyuan",2));
       list.add(new Demo("siyuan",1));
       list.add(new Demo("siyuan",3));
   }


    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] newNums = new int[10];
        int temp = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp) {
                newNums[len] = nums[i];
                temp = nums[i];
                len++;
            }
        }
        System.out.println(len);
        for (int i = 0; i < newNums.length; i++) {
            System.out.println(newNums[i]);
        }
    }


}
