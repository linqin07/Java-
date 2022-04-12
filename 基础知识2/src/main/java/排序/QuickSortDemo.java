package 排序;

import java.util.Arrays;

/**
 * @author linqin07
 * @title: QuickSortDemo
 * @description: https://blog.csdn.net/qq_32273417/article/details/105841349
 * @date 2022/4/1219:05 下午
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int arr[] = new int[]{5,2,3,1,4};
        quickSort1(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int start, int end) {
        // 这个if判断很关键
        if (start < end) {
            // 使用第一个作为分组数，注意要是 start
            int key = arr[start];
            int l = start;
            int r = end;
            // 这里是不等
            while (l != r) {
                // 先移动 right
                while (l < r && arr[r] > key) {
                    --r;
                }
                // 否则交换位置
                swap(arr, l, r);

                //移动左边
                while (l < r && arr[l] < key) {
                    ++l;
                }
                // 否则交换位置
                swap(arr, l, r);
            }

            // 递归左右
            quickSort(arr, start, l - 1);
            quickSort(arr, l + 1, end);
        }
    }

    // 交换位置
    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort1(int[] arr, int start, int end) {
        // 获取第一个为中间数，把小于它的放左边，大于的放右边
        int key = arr[start];
        int left = start;
        int right = end;
        while(left != right) {
            // 移动right
            while(left<right && arr[right]>key) {
                --right;
            }
            swap(arr, left, right);
            while(left<right&& arr[left] <key) {
                ++left;
            }
            swap(arr, left, right);
        }
        quickSort1(arr, start, left-1);
        quickSort1(arr, left+1, end);
    }
}
