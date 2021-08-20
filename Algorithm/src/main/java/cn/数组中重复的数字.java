package cn;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description:
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 * @author: LinQin
 * @date: 2019/12/02
 */
public class 数组中重复的数字 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 1, 0, 2, 5};
        int[] duplication = new int[]{};
        System.out.println(duplicate1(nums, nums.length, duplication));
    }

    /**
     * 利用hashset的特性，使用contain方法。
     * @param nums
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate(int[] nums, int length, int[] duplication) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            } else {
                hashSet.add(nums[i]);
            }
        }
        return false;
    }

    /**
     * 自然排序，有连续两个值相同必然是重复数字
     * @param nums
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate1(int[] nums, int length, int[] duplication) {
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
