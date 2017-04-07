package com.tzx;

import java.util.Locale;

/**
 * Created by tanzhenxing on 2017/3/1.
 */
public class ClassLoaderSort {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
    }
}

interface A {
    int a = 0;
}

interface B extends A{
    int a = 1;
}

class SuperClass implements A{
    static {
        System.out.println("SuperClass init");
    }
    static int a = 3;
    public static  int value = 12;

}

class SubClass extends SuperClass implements B{
    public SubClass() {

        System.out.println("SubClass");
    }

    static int a = 4;
    static {
        System.out.println("SubClass init");
    }
}