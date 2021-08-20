package 面试程序题;

/**
 * @Description:
 * 1    2	3	4	5
 * 16	17	18	19	6
 * 15	24	25	20	7
 * 14	23	22	21	8
 * 13	12	11	10	9
 * @author: LinQin
 * @date: 2019/03/11
 */
public class 螺旋数组 {
    public static void main(String[] args) {
        int n = 5;
        int matrix[][] = new int[n][n];


        final int DIRECTION_R = 1;
        final int DIRECTION_D = 2;
        final int DIRECTION_L = 3;
        final int DIRECTION_U = 4;

        int dir = DIRECTION_R;
        int i = 0, j = 0;  // i = 行， j = 列

        for (int cnt = 1; cnt <= n * n; ) {
            matrix[i][j] = cnt++;
            switch (dir) {
                case DIRECTION_R:
                    if (j + 1 >= n || matrix[i][j + 1] != 0) {
                        dir = DIRECTION_D;
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case DIRECTION_D:
                    if (i + 1 >= n || matrix[i + 1][j] != 0) {
                        dir = DIRECTION_L;
                        j--;
                    } else {
                        i++;
                    }
                    break;
                case DIRECTION_L:
                    if (j - 1 < 0 || matrix[i][j - 1] != 0) {
                        dir = DIRECTION_U;
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case DIRECTION_U:
                    if (i - 1 < 0 || matrix[i - 1][j] != 0) {
                        dir = DIRECTION_R;
                        j++;
                    } else {
                        i--;
                    }
                    break;
                default:
                    continue;
            }
        }


        for (int ii = 0; ii < n; ii++) {
            for (int jj = 0; jj < n; jj++) {
                System.out.print(matrix[ii][jj] + "\t");
            }
            System.out.println();
        }
    }
}
