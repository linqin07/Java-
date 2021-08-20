package 新建数组1M;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/25
 */
public class Test {
    public static void main(String[] args) {
        //因为int是java的基本数据类型，它的默认值是0；Integer默认是null
        int[] arr = new int[1024 * 1024 / 4];

        //一个boolean，byte类型占用1个字节。short，char 2字节，int，float 类型占用4个字节,1024字节为1KB
        //字符串utf-8：英文一个字节，中文三个字节
        //字符串gbk：英文一个字节，中文两个字节


        // 移位运算符，只针对 int 类型
        int i = 3;
        // 00000010  << 00000100  丢弃左边指定位数，右边补0
        System.out.println(i << 1);

        // 00000010  >> 00000001  丢弃右边指定位数，左边补上符号位
        System.out.println(i >> 1);


    }
}
