package com.tzx;

import java.util.ArrayList;
import java.util.List;

/**
 * vmpotions: -Xmx10m -Xms10m  -XX:PermSize=10M -XX:MaxPermSize=10M
 * Created by STVEN0KING
 * Date: 2016/9/24.
 * Description:当运行时常量池过大或者类过多时就会导致方法区溢出。
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
            System.out.println(i);
        }
    }
}

/**
 *Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
	at java.lang.Integer.toString(Integer.java:401)
	at java.lang.String.valueOf(String.java:3099)
	at java.io.PrintStream.print(PrintStream.java:597)
	at java.io.PrintStream.println(PrintStream.java:736)
	at com.tzx.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:18)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)


 Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
 at java.lang.String.intern(Native Method)
 at com.company.Main.main(Main.java:12)
 at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
 at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)
 at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
 at java.lang.reflect.Method.invoke(Method.java:597)
 at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)

 *
 */
