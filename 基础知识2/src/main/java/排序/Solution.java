package 排序;

/**
 * @author linqin07
 * @title: so
 * @description: https://blog.csdn.net/qq_32273417/article/details/105841349
 * @date 2022/4/1221:00 下午
 */
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        int arr[] = new int[]{5,2,3,1,4};
        // new Solution().quickSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    // 交换位置
    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start > end) return;
        // 获取第一个为中间数，把小于它的放左边，大于的放右边
        int key = arr[start];
        int left = start;
        int right = end;
        while(left != right) {
            // 移动right
            while(left<right && arr[right]>key) --right;
            swap(arr, left, right);
            while(left<right&& arr[left] <key) ++left;
            swap(arr, left, right);
        }
        quickSort(arr, start, left-1);
        quickSort(arr, left+1, end);
    }
}
