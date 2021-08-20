package String字符串优化;

public class Test {
    /**
     * 总结：明白字符串常量池的引用关系。
     * spit虽好，性能比较弱，建议使用index of和substring替换
     * 拼接为字符串：+""最弱，StringBuffer线程安全其次，StringBuilder最优。
     * 转化为String： +""最弱，使用String.valueOf其次，使用toString最快。
     */
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "123";
        String s3 = new String("123");
        System.out.println(s1 == s2);//true 同一个地址的引用
        System.out.println(s1 == s3);//false new 后地址不同
        System.out.println(s1 == s3.intern());//true intern返回地址池的引用


        String str = "121sddfdfs==-=";
        String[] split = str.split("-");
        //建议使用下面优化性能
        int index = str.indexOf("-");
        String substring = str.substring(0, index);

        Integer num = 0;
        int loop = 10000;//放大10000倍
        long StartTime3 = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            String s = num + "";
        }
        long endTime3 = System.currentTimeMillis();
        System.out.println("+''的时间为：" + (endTime3 - StartTime3) + "ms");

        long StartTime4 = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            String string = String.valueOf(num);
        }
        long endTime4 = System.currentTimeMillis();
        System.out.println("valueOf的时间为：" + (endTime4 - StartTime4) + "ms");

        long StartTime5 = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            String string = num.toString();
        }
        long endTime5 = System.currentTimeMillis();
        System.out.println("toString的时间为：" + (endTime5 - StartTime5) + "ms");


        //***************************************************************
        String s = "";
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s += "s";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("+拼接时间：" + (endTime - beginTime) + "ms");


        StringBuffer sb = new StringBuffer();
        long beginTime1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append("s");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("StringBuffer：" + (endTime1 - beginTime1) + "ms");

        StringBuilder sb1 = new StringBuilder();
        long beginTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb1.append("s");
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("StringBuilder：" + (endTime2 - beginTime2) + "ms");

        System.out.println("-----------");
        String string = "_ddd";
        if (string.matches("_ddd|_kkdfdfk")) {
            System.out.println("==========");
        }


    }

}
