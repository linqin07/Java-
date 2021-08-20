package cn;

/**
 * @Description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * <p>
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 * @author: LinQin
 * @date: 2019/12/04
 */
public class 二维数组中的查找 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(Find1(0, matrix));
    }

    /**
     * 从左下找
     * 利用该二维数组的性质：
     *
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序
     * @param target
     * @param array
     * @return
     */
    public static boolean Find1(int target, int[][] array) {
        if (array.length == 0) return false;

        // 行
        int row = array.length - 1;
        // 列
        int cols = array[0].length;

        // 左下
        int col = 0;
        while (row >= 0 && col < cols) {
            if (array[row][col] < target) {
                col ++ ;
            } else if (array[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }

            return false;
    }

    // 两重循环，暴力，时间复杂度：O(n^2) 空间复杂度：O(1)O(1)

// --Commented out by Inspection START (2020/9/27 12:51 下午):
//    public static boolean Find(int target, int[][] array) {
//        if (array.length == 0) return false;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                if (array[i][j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
// --Commented out by Inspection STOP (2020/9/27 12:51 下午)

}
