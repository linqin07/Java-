package 一次排序选第二大的数;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{222, 223, 22, 77, 33, 11, 55, 8, 9, 5};

        int Max = a[0];
        int SecondMax = a[1];

        for (int i = 2; i < a.length; i++) {
            // 从第三个开始循环，如果元素大于最大值，则最大值更新，原最大值赋给第二大值
            if (a[i] > Max) {
                SecondMax = Max;
                Max = a[i];
            }
            // 如果该元素不大于最大值，且大约第二大的值，则第二大的值更新
            if (a[i] > SecondMax && a[i] < Max)
                SecondMax = a[i];

        }
        System.out.println(Max);
        System.out.println(SecondMax);
    }

}
