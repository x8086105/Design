package com.xmm.design.factory.methodfactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by hoopan
 * on 2016/6/30.
 */
public class LogisticsMathUtils {

    // 默认乘除法运算精度
    public static final int DEF_DIV_SCALE = 2;

    private LogisticsMathUtils() {
    }


    /**
     * 提供默认精度的乘法运算(第三个参数为空则不参与计算)
     * @param b1
     * @param b2
     * @param b3
     * @return
     */
    public static BigDecimal mulBigDecimal(BigDecimal b1, BigDecimal b2, BigDecimal b3) {
        BigDecimal result = b1.multiply(b2);
        if(b3 == null) {
            return result.setScale(DEF_DIV_SCALE, RoundingMode.HALF_EVEN);
        }
        return result.multiply(b3).setScale(DEF_DIV_SCALE, RoundingMode.HALF_EVEN);
    }

    /**
     * 提供指定精度的乘法运算(第三个参数为空则不参与计算)
     * @param b1
     * @param b2
     * @param b3
     * @param scale
     * @return
     */
    public static BigDecimal mulBigDecimal(BigDecimal b1, BigDecimal b2, BigDecimal b3, int scale) {
        BigDecimal result = b1.multiply(b2).multiply(b3);
        if(b3 == null) {
            return result.setScale(scale, RoundingMode.HALF_EVEN);
        }
        return result.multiply(b3).setScale(scale, RoundingMode.HALF_EVEN);
    }

    /**
     * 提供默认精度的加法运算
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal addBigDecimal(BigDecimal b1, BigDecimal b2) {
        return b1.add(b2).setScale(DEF_DIV_SCALE, RoundingMode.HALF_EVEN);
    }

    /**
     * 提供指定精度的加法运算
     * @param b1
     * @param b2
     * @param scale
     * @return
     */
    public static BigDecimal addBigDecimal(BigDecimal b1, BigDecimal b2,
                                           int scale) {
        return b1.add(b2).setScale(scale, RoundingMode.HALF_EVEN);
    }

    /**
     * 指定精度的除法
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal divideBigDecimal(BigDecimal b1, BigDecimal b2) {

        return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * 简单减法
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal subBigDecimal(BigDecimal b1, BigDecimal b2) {

        return b1.subtract(b2);
    }

    /**
     * 简单乘法
     * @param b1
     * @param b2
     * @return
     */
    public static BigDecimal mulBigDecimal(BigDecimal b1, BigDecimal b2) {
        return b1.multiply(b2).setScale(DEF_DIV_SCALE, RoundingMode.HALF_EVEN);
    }
}
