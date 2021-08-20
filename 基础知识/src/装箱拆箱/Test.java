package 装箱拆箱;

/**
 * 一个常量池：享元模式
 */
public class Test {
    /**
     * 基本数据类型：int byte short long float double char boolean
     * 包装类型 :Integer Byte Short Long Float Double Character Boolean
     * 转换为大写为装箱，转化为小写的为拆箱子
     * 缓冲池子：范围-128~127 会自动装箱拆箱。
     */
    public static void main(String[] args) {
        Integer ii = 1;
        Integer iii = Integer.valueOf(1);//自动装箱
        System.out.println(ii == iii && ii == 1 && iii == 1);

        //在-128~127 之外的数
        Integer i1 = 200;
        Integer i2 = 200;
        System.out.println("i1==i2: " + (i1 == i2));//false
        // 在-128~127 之内的数自动拆箱
        Integer i3 = 100;
        Integer i4 = 100;
        System.out.println("i3==i4: " + (i3 == i4));//true

        int i0 = 100;
        System.out.println(i3 == i0);//true
        System.out.println(i1 == i0);//false
        System.out.println("〇".getBytes().length);//2

    }

}
