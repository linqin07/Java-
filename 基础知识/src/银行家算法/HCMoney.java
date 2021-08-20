package 银行家算法;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.logging.Logger;

public class HCMoney {
    public static Logger logger = Logger.getLogger("api");
    /**
     * 金额为分的格式
     */
    public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";

    /**
     * 将分为单位的转换为元并返回金额格式的字符串 （除100）
     *
     * @param amount
     * @return
     * @throws Exception
     */
    public static String changeF2Y(Long amount) throws Exception {
        if (!amount.toString().matches(CURRENCY_FEN_REGEX)) {
            throw new Exception("金额格式有误");
        }
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(amount);
    }

    /**
     * 将分为单位的转换为元 （除100）
     *
     * @param amount
     * @return
     * @throws Exception
     */
    public static String changeF2Y(String amount) {
        return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();
    }

    /**
     * 将分装化成元
     *
     * @param amount
     * @return Double
     * @throws Exception
     */
    public static Double changeF2D(String amount) {
        String samount = BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();
        return Double.parseDouble(samount);
    }


    /**
     * 将元为单位的转换为分 （乘100）
     *
     * @param amount
     * @return
     */
    public static String changeY2F(Long amount) {
        return BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).toString();
    }

    /**
     * 将元为单位的转换为分 替换小数点，支持以逗号区分的金额
     *
     * @param amount
     * @return
     */
    public static String changeY2F2(String amount) {
        String currency = amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额
        int index = currency.indexOf(".");
        int length = currency.length();
        Long amLong = 0l;
        if (index == -1) {
            amLong = Long.valueOf(currency + "00");
        } else if (length - index >= 3) {
            amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
        } else if (length - index == 2) {
            amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
        } else {
            amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
        }

        //转化为12位长度
        String sAmount = amLong.toString();
	        /*int len=12-sAmount.length();
	        for(int i=1;i<=len;i++){
	        	sAmount="0"+sAmount;
	        }*/
        return sAmount;
    }

    /**
     * 元转分, 金额乘以100, 第三位小数点起将不计算
     *
     * @param money 如果是Null,返回0
     * @return
     */
    public static String changeY2F(Double money) {
        money = money == null ? 0.0 : money;
        BigDecimal numOne = BigDecimal.valueOf(money);
        numOne = numOne.multiply(BigDecimal.valueOf(100));
        return String.valueOf(numOne.longValue());
    }

    /**
     * 将传入的金额保留两位小数
     *
     * @return
     */
    public static String changeMoneyFormat(String moneyStr) {
        if (moneyStr.isEmpty()) {
            return "0.00";
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(Double.valueOf(moneyStr));
    }

    /**
     * 将传入的金额保留两位小数
     *
     * @return
     */
    public static Double changeStrToDouble(String moneyStr) {
        if (moneyStr.isEmpty()) {
            return 0.00;
        }
        return Double.valueOf(moneyStr);
    }

    /**
     * double相减方法,此方法会对double转型成BigDeimal进行运算,解决精度问题  </br>
     * 只能是2位小数,超出将被截取,不会进行四舍五入操作
     *
     * @param source    被减的数-元
     * @param subSource 减去的数-元
     * @return
     */
    public static Double subtract(Double source, Double subSource) {
        BigDecimal numOne = BigDecimal.valueOf(source).setScale(2, RoundingMode.FLOOR);
        BigDecimal numTwo = BigDecimal.valueOf(subSource).setScale(2, RoundingMode.FLOOR);
        BigDecimal result = numOne.subtract(numTwo);
        return result.doubleValue();
    }

    public static Double subTwo(Double source) {
        BigDecimal numOne = BigDecimal.valueOf(source).setScale(2, RoundingMode.FLOOR);
        return numOne.doubleValue();
    }

    /**
     * double相加方法,此方法会对double转型成BigDeimal进行运算,解决精度问题</br>
     * 只能是2位小数,超出将被截取,不会进行四舍五入操作
     *
     * @param source    被加的数-元
     * @param subSource 加的数-元
     * @return
     */
    public static Double add(Double source, Double subSource) {
        BigDecimal numOne = BigDecimal.valueOf(source).setScale(2, RoundingMode.FLOOR);
        BigDecimal numTwo = BigDecimal.valueOf(subSource).setScale(2, RoundingMode.FLOOR);
        BigDecimal result = numOne.add(numTwo);
        return result.doubleValue();
    }

    public static Double add(Double source, Double... other) {
        BigDecimal numOne = BigDecimal.valueOf(source).setScale(2, RoundingMode.FLOOR);
        for (Double temp : other) {
            BigDecimal numTwo = BigDecimal.valueOf(temp).setScale(2, RoundingMode.FLOOR);
            numOne = numOne.add(numTwo);
        }
        return numOne.doubleValue();
    }

    public static Double multiply(Double source, Double subSource) {
        BigDecimal numOne = BigDecimal.valueOf(source);
        BigDecimal numTwo = BigDecimal.valueOf(subSource);
        BigDecimal result = numOne.multiply(numTwo);
        return result.setScale(2, RoundingMode.UP).doubleValue();
    }

    public static Double multiply(Double source, Double... other) {
        BigDecimal numOne = BigDecimal.valueOf(source);
        for (Double temp : other) {
            BigDecimal numTwo = BigDecimal.valueOf(temp);
            numOne = numOne.multiply(numTwo);
        }
        return numOne.setScale(2, RoundingMode.UP).doubleValue();
    }

    public static void main(String[] args) {
        Double a = HCMoney.add(10.0, 0.02, 0.0);
        System.out.println(a);
    }


    public static Double subtract(Double source, Double... other) {
        BigDecimal numOne = BigDecimal.valueOf(source).setScale(2, RoundingMode.FLOOR);
        for (Double temp : other) {
            BigDecimal numTwo = BigDecimal.valueOf(temp).setScale(2, RoundingMode.FLOOR);
            numOne = numOne.subtract(numTwo);
        }
        return numOne.doubleValue();
    }

    /**
     * 补零操作
     *
     * @param source
     * @param length 长度
     * @return
     */
    public static String appendZeroToLeft(String source, int length) {
        if (source == null) return null;
        if (source.length() == length) return source;
        while (source.length() < length) {
            source = "0" + source;
        }
        return source;
    }

    /**
     * 补零操作
     *
     * @param source
     * @param length 长度
     * @return
     */
    public static String appendZeroToRight(String source, int length) {
        if (source == null) return null;
        if (source.length() == length) return source;
        while (source.length() < length) {
            source += "0";
        }
        return source;
    }

    /**
     * 当浮点型数据位数超过10位之后，数据变成科学计数法显示。用此方法可以使其正常显示。
     *
     * @param value
     * @return Sting
     */
    public static String formatDoubleNumber(double value) {
        if (value != 0.00) {
            DecimalFormat df = new DecimalFormat("###0.00");
            return df.format(value);
        } else {
            return "0.00";
        }

    }

    /**
     * 补空格操作
     *
     * @param source
     * @param length
     * @return
     */
    public static String appendEmptyToRight(String source, int length) {
        if (source == null) return null;
        if (source.length() == length) return source;
        while (source.length() < length) {
            source += " ";
        }
        return source;
    }

    /**
     * 四舍五入保存两位小数
     *
     * @param source
     * @param length
     * @return
     */
    public static Double roundTwo(double d) {
        BigDecimal b = new BigDecimal(d);
        return b.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

}