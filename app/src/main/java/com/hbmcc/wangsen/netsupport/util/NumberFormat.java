package com.hbmcc.wangsen.netsupport.util;

import java.math.BigDecimal;

public class NumberFormat {
    public static double doubleFormat(double x, int decimalPlaces) {
        BigDecimal b = new BigDecimal(x);//BigDecimal 类使用户能完全控制舍入行为
        double y = b.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP).doubleValue();
        return y;
    }
}
