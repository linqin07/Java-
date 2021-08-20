package 跟钱有关的精度问题;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class Test {
    public static void main(String[] args) {
        // Double d=5.36;
        // Double.parseDouble(d)*100;
        // NumberFormat nf = NumberFormat.getInstance();
        // nf.setGroupingUsed(false);
        // System.out.println((nf.format(d)));
        // //
        String totalFee = "5.10";
        BigDecimal b1 = new BigDecimal(totalFee);
        BigDecimal b2 = new BigDecimal(100);
        long amountStr = b1.multiply(b2).longValue();
        totalFee = "-" + amountStr;
        System.err.println(totalFee);

        /**
         * 原因 36.10
         */
        String str = "5.10";
        Double d = Double.parseDouble(str) * 100;
        System.out.println(d.intValue());// 509.99999999999994

        System.out.println(Double.parseDouble(str) * 100);
        double dd = Double.parseDouble("36.10") * 100;
        System.out.println(double2Str(dd));

        DecimalFormat dc = new DecimalFormat();
        double num = 0;
        try {
            num = dc.parse("5.10").doubleValue();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(num);
        // BigDecimal bd1 = new BigDecimal(Integer.toString(a));
        // BigDecimal bd2 = new BigDecimal(Double.toString(b));
        // double c = bd1.multiply(bd2).doubleValue();

        double g = 2.0;
        System.out.println(String.valueOf(g - 1.43));
    }

    public static String double2Str(Double d) {
        if (d == null) {
            return "";
        }
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return (nf.format(d));
    }
}
