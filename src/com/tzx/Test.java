package com.tzx;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by tanzhenxing on 2017/3/17.
 */
public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        //out o = new out() {
        //    @Override
        //    public void println() {
        //        System.out.println(Thread.currentThread().getName());
        //    }
        //};
        Queue<out> list = new SynchronousQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                list.add(new out() {
                    @Override
                    public void println() {
                        System.out.println(Thread.currentThread().getName());
                    }
                });
            }
        }).start();
        for (;;) {
            if (!list.isEmpty()) {
                out e = list.poll();
                if (e != null) {
                    e.println();
                    list.remove(e);
                }
            }
        }
    }


}
interface out {
    void println();
}

