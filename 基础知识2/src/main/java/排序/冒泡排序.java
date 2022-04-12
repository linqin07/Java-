package 排序;

import java.util.Arrays;

/**
 * @author linqin07
 * @title: 冒泡排序
 * @description: TODO
 * @date 2022/4/1220:43 下午
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int arr[] = new int[]{2, 5, 8, 1, 3, 6, 4, -1, -6, 55};
        System.out.println(Arrays.toString( MySort(arr)));



    }

    public static int[] MySort(int[] arr) {
        // write code here 冒泡
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp;
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
