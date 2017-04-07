package com.tzx;

/**
 * Created by STVEN0KING
 * Date: 2016/9/24.
 * Description:栈异常
 * 如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError
 * VM Args:-Xss2M
 */
public class JavaJVMStackOOM {
    int i = 0;
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            i++;
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaJVMStackOOM oom = new JavaJVMStackOOM();
        try {
            oom.stackLeakByThread();
        } catch (Exception e) {
            System.out.println("thread num:" + oom.i);
            throw e;
        }
    }

}
/**
 * result:死机（cpu used 100%）
 */
