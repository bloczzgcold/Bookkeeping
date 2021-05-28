package com.bloczzgcold.core.base.utils;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class BigDecimalUtils {
    private static Pattern PATTERN_IS_INTEGER = Pattern.compile("-?[0-9]*");
    private BigDecimalUtils() {
    }

    public static int add(int value1, int value2) {
        return BigDecimal.valueOf(value1).add(BigDecimal.valueOf(value2)).stripTrailingZeros().intValue();
    }

    public static double add(double value1, double value2) {
        return BigDecimal.valueOf(value1).add(BigDecimal.valueOf(value2)).stripTrailingZeros().doubleValue();
    }

    public static String add(String value1, String value2) {
        return new BigDecimal(value1).add(new BigDecimal(value2)).stripTrailingZeros().toPlainString();
    }

    public static int subtract(int value1, int value2) {
        return BigDecimal.valueOf(value1).subtract(BigDecimal.valueOf(value2)).stripTrailingZeros().intValue();
    }

    public static double subtract(double value1, double value2) {
        return BigDecimal.valueOf(value1).subtract(BigDecimal.valueOf(value2)).stripTrailingZeros().doubleValue();
    }

    public static String subtract(String value1, String value2) {
        return new BigDecimal(value1).subtract(new BigDecimal(value2)).stripTrailingZeros().toPlainString();
    }

    public static int multiply(int value1, int value2) {
        return BigDecimal.valueOf(value1).multiply(BigDecimal.valueOf(value2)).stripTrailingZeros().intValue();
    }

    public static double multiply(double value1, double value2) {
        return BigDecimal.valueOf(value1).multiply(BigDecimal.valueOf(value2)).stripTrailingZeros().doubleValue();
    }

    public static String multiply(String value1, String value2) {
        return new BigDecimal(value1).multiply(new BigDecimal(value2)).stripTrailingZeros().toPlainString();
    }

    public static double multiply(double value1, double value2, int scale) {
        return new BigDecimal(value1).multiply(new BigDecimal(value2)).setScale(scale, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().doubleValue();
    }

    public static String multiply(String value1, String value2, int scale) {
        return new BigDecimal(value1).multiply(new BigDecimal(value2)).setScale(scale, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
    }

    public static double multiply(double value1, double value2, int scale, int roundingMode) {
        return new BigDecimal(value1).multiply(new BigDecimal(value2)).setScale(scale, roundingMode).stripTrailingZeros().doubleValue();
    }

    public static String multiply(String value1, String value2, int scale, int roundingMode) {
        return new BigDecimal(value1).multiply(new BigDecimal(value2)).setScale(scale, roundingMode).stripTrailingZeros().toPlainString();
    }

    public static String divide(String value1, String value2) {
        return new BigDecimal(value1).divide(new BigDecimal(value2), BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
    }

    public static double divide(int value1, int value2, int scale) {
        return BigDecimal.valueOf(value1).divide(BigDecimal.valueOf(value2), scale, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().doubleValue();
    }

    public static double divide(double value1, double value2, int scale) {
        return BigDecimal.valueOf(value1).divide(BigDecimal.valueOf(value2), scale, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().doubleValue();
    }

    public static String divide(String value1, String value2, int scale) {
        return new BigDecimal(value1).divide(new BigDecimal(value2), scale, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
    }

    public static double divide(int value1, int value2, int scale, int roundingMode) {
        return BigDecimal.valueOf(value1).divide(BigDecimal.valueOf(value2), scale, roundingMode).stripTrailingZeros().doubleValue();
    }

    public static double divide(double value1, double value2, int scale, int roundingMode) {
        return BigDecimal.valueOf(value1).divide(BigDecimal.valueOf(value2), scale, roundingMode).stripTrailingZeros().doubleValue();
    }

    public static String divide(String value1, String value2, int scale, int roundingMode) {
        return new BigDecimal(value1).divide(new BigDecimal(value2), scale, roundingMode).stripTrailingZeros().toPlainString();
    }

    public static double format(double value) {
        return BigDecimal.valueOf(value).stripTrailingZeros().doubleValue();
    }

    public static String format(String value) {
        return new BigDecimal(value).stripTrailingZeros().toPlainString();
    }

    public static String decimalFormat(double value) {
        return new DecimalFormat("0.00").format(new BigDecimal(value));
    }

    public static String decimalFormat(String value) {
        if (TextUtils.isEmpty(value)) {
            value = "0";
        }

        return new DecimalFormat("0.00").format(new BigDecimal(value));
    }

    public static String decimalFormat(String value, String pattern) {
        if (TextUtils.isEmpty(value)) {
            value = "0";
        }

        return new DecimalFormat(pattern).format(new BigDecimal(value));
    }

    public static String decimalFormat(String value, int pattern) {
        if (isInteger(value)) {
            return format(value);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("0.");
            for (int i = 0; i < pattern; i++) {
                sb.append("0");
            }

            return decimalFormat(value, sb.toString());
        }
    }

    public static String formatScale(String value) {
        return new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
    }

    public static String formatScale(String value, int newScale) {
        return new BigDecimal(value).setScale(newScale, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
    }

    public static String absToString(String value) {
        return new BigDecimal(value).abs().toPlainString();
    }

    public static String absToString(double value) {
        return BigDecimal.valueOf(value).abs().toPlainString();
    }

    public static int compareTo(double value1, double value2) {
        return BigDecimal.valueOf(value1).compareTo(BigDecimal.valueOf(value2));
    }

    public static int compareTo(String value1, String value2) {
        return new BigDecimal(value1).compareTo(new BigDecimal(value2));
    }

    public static boolean isEquals(String value1, String value2) {
        return compareTo(value1, value2) == 0;
    }

    public static boolean isNotEquals(String value1, String value2) {
        return compareTo(value1, value2) != 0;
    }

    public static boolean isGreater(String value1, String value2) {
        return compareTo(value1, value2) > 0;
    }

    public static boolean isGreater(BigDecimal value1, BigDecimal value2) {
        return value1.compareTo(value2) > 0;
    }

    public static boolean isLess(String value1, String value2) {
        return compareTo(value1, value2) < 0;
    }

    public static boolean isGreaterAndEquals(String value1, String value2) {
        return compareTo(value1, value2) >= 0;
    }

    public static boolean isLessAndEquals(String value1, String value2) {
        return compareTo(value1, value2) <= 0;
    }

    public static boolean isEquals0(String value1) {
        return compareTo(value1, "0") == 0;
    }

    public static boolean isNotEquals0(String value1) {
        return compareTo(value1, "0") != 0;
    }

    public static boolean isGreater0(String value1) {
        return compareTo(value1, "0") > 0;
    }

    public static boolean isLess0(String value1) {
        return compareTo(value1, "0") < 0;
    }

    public static boolean isGreaterAndEquals0(String value1) {
        return compareTo(value1, "0") >= 0;
    }

    public static boolean isLessAndEquals0(String value1) {
        return compareTo(value1, "0") <= 0;
    }

    public static String transferDecimal(String value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.######");
        return decimalFormat.format(value);
    }

    public static String transferBig(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("########.##");
        return decimalFormat.format(value);
    }

    public static String transferBig(String value) {
        DecimalFormat decimalFormat = new DecimalFormat("########.##");
        return decimalFormat.format(value);
    }

    public static String ternaryOperatorLess(String value1, String value2) {
        return isLess(value1, value2) ? value1 : value2;
    }

    public static String ternaryOperatorGreater(String value1, String value2) {
        return isGreater(value1, value2) ? value1 : value2;
    }

    public static String giveUpAmountPoints(String value) {
        if (value == null) {
            return "0.00";
        }
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.setScale(1, BigDecimal.ROUND_DOWN).toString();
    }

    public static String roundDownFormat(String value, int scale) {
        if (value == null) {
            value = "0.00";
        }
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.setScale(scale, BigDecimal.ROUND_DOWN).toString();
    }

    public static boolean isInteger(String value) {
        return (!TextUtils.isEmpty(value)) && PATTERN_IS_INTEGER.matcher(value).matches();
    }

    /**
     * 分转元
     * @param value 单位为分的金额
     * @return  单位为元的金额
     */
    public static String priceFenToYuan(String value) {
        if (TextUtils.isEmpty(value)) {
            return "0.00";
        }
        String divide = divide(value, "100", 2);
        return decimalFormat(divide);
    }

    /**
     * 金额取负数
     * @param value 金额
     * @return  负数
     */
    public static String amountToMinus(String value) {
        if (TextUtils.isEmpty(value)) {
            return "0.00";
        }
        if (isEquals0(value)) {
            return "0.00";
        }
        double abs = Math.abs(Double.parseDouble(value));
        return String.valueOf(-abs);
    }

    /**
     * 金额取正数
     * @param value 金额
     * @return  正数
     */
    public static String amountToPositive(String value) {
        if (TextUtils.isEmpty(value)) {
            return "0.00";
        }
        if (isEquals0(value)) {
            return "0.00";
        }
        double abs = Math.abs(Double.parseDouble(value));
        return String.valueOf(abs);
    }
}
