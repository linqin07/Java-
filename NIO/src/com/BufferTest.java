package com;

import java.nio.IntBuffer;

public class BufferTest {
    /**
     * limit 不可以操作的位置。
     */
    public static void main(String[] args) {
        //创建指定大小的缓冲区
        IntBuffer buff = IntBuffer.allocate(10);
        int[] array = new int[]{3, 5, 6};

        //把一个int数组读入缓冲区。
//		buff = buff.wrap(array);
        buff = buff.wrap(array, 0, 3);

        //修改对应位置数组值
        buff.put(0, 32);

        for (int i = 0; i < buff.limit(); i++) {
            System.out.println(buff.get(i));
        }
        System.out.println(buff.toString());

        buff.flip();
        System.out.println(buff.toString());

        buff.clear();
        System.out.println(buff.toString());

    }

}
