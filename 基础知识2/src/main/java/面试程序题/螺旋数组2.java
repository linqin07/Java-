package 面试程序题;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/03/11
 */
public class 螺旋数组2 {
    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] nums = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };

        /*
         * 定义上右下左数组下标边界
         * 矩阵上边：从0开始，即第一维数组的第一个元素。
         * 矩阵右边：最大的列数，因为数组从0开始，故需要-1。
         * 矩阵下标：最大的行数，因为数组从0开始，故需要-1。
         * 矩阵左边：从0开始，即第二维数组的第一个元素。
         *
         */
        int up = 0;
        int right = n - 1;
        int down = m - 1;
        int left = 0;

        StringBuilder opStr = new StringBuilder("[");
        while (true) {
            //从左往右
            for (int i = left; i <= right; i++) {
                opStr.append(nums[up][i]).append(",");
            }
            if (++up > down) {
                break;
            }

            //从上到下
            for (int i = up; i <= down; i++) {
                opStr.append(nums[i][right]).append(",");
            }
            if (--right < left) {
                break;
            }

            //从右往左
            for (int i = right; i >= left; i--) {
                opStr.append(nums[down][i]).append(",");
            }
            if (up > --down) {
                break;
            }

            //从下到上
            for (int i = down; i >= up; i--) {
                opStr.append(nums[i][left]).append(",");
            }
            if (right < ++left) {
                break;
            }
        }

        //删除最末尾多余的逗号
        opStr.deleteCharAt(opStr.length() - 1);
        opStr.append("]");

        System.out.println(opStr);

    }
}
