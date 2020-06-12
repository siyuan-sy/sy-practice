package com.sy.demo;

public class TestEnum {

    public static void main(String[] args) {
        System.out.println("BusinessStatus.SUCCESS.ordinal() = " + BusinessStatus.SUCCESS.ordinal());
        System.out.println("BusinessStatus.FAIL.ordinal() = " + BusinessStatus.FAIL.name());
        System.out.println("BusinessStatus.FAIL.ordinal() = " + BusinessStatus.CUSTOM.ordinal());
    }
}
