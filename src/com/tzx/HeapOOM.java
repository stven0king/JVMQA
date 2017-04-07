package com.tzx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by STVEN0KING
 * Date: 2016/9/24.
 * Description:堆溢出
 * VM Args: -Xms20m -Xmx20m
 */
public class HeapOOM {
    static class OOMObject {
        List<Object> list;
    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        for (;;) list.add(new OOMObject());
    }
}
/**
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 at java.util.Arrays.copyOf(Arrays.java:3210)
 at java.util.Arrays.copyOf(Arrays.java:3181)
 at java.util.ArrayList.grow(ArrayList.java:261)
 at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
 at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
 at java.util.ArrayList.add(ArrayList.java:458)
 at com.tzx.HeapOOM.main(HeapOOM.java:17)
 */
