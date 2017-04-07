package com.tzx;

/**
 * Created by STVEN0KING
 * Date: 2016/9/24.
 * Description:栈异常
 * 如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError
 * VM Args: -Xss128k(栈的内存容量)
 */
public class JavaJVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaJVMStackSOF oom = new JavaJVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}

/**
 * Exception in thread "main" java.lang.StackOverflowError
 at com.tzx.JavaJVMStackSOF.stackLeak(JavaJVMStackSOF.java:13)
 at com.tzx.JavaJVMStackSOF.stackLeak(JavaJVMStackSOF.java:14)
 at com.tzx.JavaJVMStackSOF.stackLeak(JavaJVMStackSOF.java:14)
 */
