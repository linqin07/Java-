package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        double price = 1.016;
        double percent = 0.0277;
        double low = 0.846;
        double hign = 1.257;

        ArrayList<BigDecimal> list = new ArrayList<>();

        BigDecimal ii = new BigDecimal(price);
        list.add(ii);
        while (ii.doubleValue() < hign) {
            // price = price + price * percent;
            BigDecimal bigDecimal1 = ii.multiply(new BigDecimal(percent)).setScale(3, RoundingMode.HALF_EVEN);
            ii = ii.add(bigDecimal1);
            // System.out.println(ii.setScale(3, RoundingMode.HALF_EVEN));
            list.add(ii);
        }

        Stack<BigDecimal> stack1 = new Stack<>();
        BigDecimal jj = new BigDecimal(price);
        while (jj.doubleValue() > low) {
            BigDecimal bigDecimal1 = jj.multiply(new BigDecimal(percent)).setScale(3, RoundingMode.HALF_EVEN);
            jj = jj.subtract(bigDecimal1);
            stack1.push(jj);
        }

        while (stack1.size() != 0) {
            System.out.println(stack1.pop().setScale(3, RoundingMode.HALF_EVEN));
        }
        list.forEach(item -> System.out.println(item.setScale(3, RoundingMode.HALF_EVEN)));

    }
}
