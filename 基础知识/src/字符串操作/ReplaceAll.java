package 字符串操作;

public class ReplaceAll {
    /**
     * 替换
     * 反斜杠\\  正则为\\\\
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "https://ke.qq.com/webcourse/index.html\\sdsd\\sd";
        //替换正则匹配的为 其他字符串
        String replaceAll = str.replaceAll("\\\\", "/");
        System.out.println(replaceAll);

        //替换字符串为其他字符串
        replaceAll = str.replace("s", "??");
        System.out.println(replaceAll);


        String index = "south:xxx";
        System.out.println(index.indexOf(":"));
        System.out.println(index.substring(index.indexOf(":") + 1));

    }

}
