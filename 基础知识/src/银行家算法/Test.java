package 银行家算法;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        //12.5的四舍五入值：13
        System.out.println("12.5的四舍五入值：" + Math.round(12.5));
        //-12.5的四舍五入值：-12
        System.out.println("-12.5的四舍五入值：" + Math.round(-12.5));
        /**
         * 银行家算法,数据库储存decimal类型，实体使用Double
         * 	使用
         */
        BigDecimal d = new BigDecimal(100000);      //存款
        BigDecimal r = new BigDecimal(0.001875 * 3);   //利息
        BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);     //使用银行家算法
        //季利息是：562.50
        System.out.println("季利息是：" + i);

        NumberFormat nf = new DecimalFormat();
        nf.setMaximumFractionDigits(2);

        System.out.println(nf.format(1L));

        Map<String, Object> map = new HashMap<>();
        map.put("1", 1);

        int i1 = (int) map.get("1");
        i1 = 9;

        System.out.println((int) map.get("1"));
    }

}
