package com.liyc.common.util.number;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lyc
 * @Date 2020-11-20 9:43
 * @ClassName NumberToChn
 * @Description 金钱数字转中文大写
 */
public class NumberToChn {
    private static final String[] BEFORE_SCALE = { "万", "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "" };

    private static final String[] AFTER_SCALE = { "角", "分" };

    private static final String DEFAULT_PATH_SEPARATOR = ".";

    private static final Map<String, String> NUMBER_MAPPING = new HashMap<String, String>();
    static {
        NUMBER_MAPPING.put("-", "负");
        NUMBER_MAPPING.put("0", "零");
        NUMBER_MAPPING.put("1", "壹");
        NUMBER_MAPPING.put("2", "贰");
        NUMBER_MAPPING.put("3", "叁");
        NUMBER_MAPPING.put("4", "肆");
        NUMBER_MAPPING.put("5", "伍");
        NUMBER_MAPPING.put("6", "陆");
        NUMBER_MAPPING.put("7", "柒");
        NUMBER_MAPPING.put("8", "捌");
        NUMBER_MAPPING.put("9", "玖");
    }

    public static String getChineseNumber(String number) {
        return getChineseNumber(number, null, null);
    }

    public static String getChineseNumber(String number, String unit, String postfix) {

        String[] numbers = strToStrArray(number, DEFAULT_PATH_SEPARATOR);
        if (numbers.length > 2) {
            new NumberFormatException("数字格式错误!");
        }
        int length = numbers[0].length();
        int isZero = 0;
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < length; i++) {
            String digit = String.valueOf(numbers[0].charAt(i));

            boolean allZero = true; // 如果后继的全部是零,则跳出
            for (int j = i; j < length; j++) {
                if (numbers[0].charAt(j) != '0') {
                    allZero = false;
                    break;
                }
            }

            if (allZero) {
                result.append(NUMBER_MAPPING.get("0"));
                boolean hasValue = false;
                for (int z = i; z >= 0; z--) {
                    if (numbers[0].charAt(z) != '0' && length - z <= 7 && length - z >= 5) {
                        hasValue = true;
                        break;
                    }
                }
                // 加万单位
                if ( ( length - i > 4 && length <= 8 ) || ( hasValue && length - i > 4 )) {
                    result.append(BEFORE_SCALE[8]);
                }
                // 加亿单位
                if (length - i >= 9) {
                    result.append(BEFORE_SCALE[4]);
                }
                break;
            }

            if (length < 9 && length - i == 5) {
                if (!"0".equals(digit) && isZero > 0) {
                    result.append(NUMBER_MAPPING.get("0"));
                }
                if ("0".equals(digit)) {
                    result.append(BEFORE_SCALE[8]);
                    if (isZero > 0) {
                        result.append(NUMBER_MAPPING.get("0"));
                    }
                    continue;
                }
            }
            if ("0".equals(digit) && length > 9 && length - i == 9) {
                result.append(BEFORE_SCALE[4]);
                continue;
            }

            if (isZero < 1 || !"0".equals(digit)) {
                if ("0".equals(digit)) {
                    if (length - i != 6 && length - i != 7) {
                        result.append(NUMBER_MAPPING.get(digit));
                    }
                } else {
                    result.append(NUMBER_MAPPING.get(digit));
                }

                if (!"0".equals(digit)) {
                    result.append(BEFORE_SCALE[BEFORE_SCALE.length - length + i]);
                }
            }

            if ("0".equals(digit)) {
                isZero++;
            } else {
                isZero = 0;
            }
        }
        result.append(unit == null ? "圆" : result.append(unit));

        if (numbers.length == 1) {
            result.append(postfix == null ? "整" : result.append(postfix));
            return result.toString();
        }

        length = numbers[1].length();
        for (int j = 0; j < length; j++) {
            if (j > 2) {
                break;
            }
            if (numbers[1].charAt(j) == '0') {
                continue;
            }
            result.append(NUMBER_MAPPING.get(String.valueOf(numbers[1].charAt(j))));
            result.append(AFTER_SCALE[j]);
        }

        result.append(postfix == null ? "整" : result.append(postfix));

        return result.toString();
    }

    private static String[] strToStrArray(String number, String defaultPathSeparator) {
        String[] numbers;
        int doz = number.indexOf('.');
        if(doz > 0) {
            numbers = new String[2];
            numbers[0] = number.substring(0, doz);
            numbers[1] = number.substring(doz + 1);
            if(numbers[1].length()>2) {
                numbers[1] = numbers[1].substring(0,2);
            }
        }else {
            numbers = new String[1];
            numbers[0] = number;
        }
        return numbers;
    }

    public static String getChineseNumber(int number) {
        return getChineseNumber(new Integer(number));
    }

    public static String getChineseNumber(int number, String unit, String postfix) {
        return getChineseNumber(new Integer(number), unit, postfix);
    }

    public static String getChineseNumber(Long number) {
        return getChineseNumber(number.toString(), null, null);
    }

    public static String getChineseNumber(Integer number) {
        return getChineseNumber(number.toString(), null, null);
    }

    public static String getChineseNumber(Integer number, String unit, String postfix) {
        return getChineseNumber(number.toString(), unit, postfix);
    }

    public static String getChineseNumber(Long number, String unit, String postfix) {
        return getChineseNumber(number.toString(), unit, postfix);
    }

    public static String getChineseNumber(long number) {
        return getChineseNumber(new Long(number));
    }

    public static String getChineseNumber(long number, String unit, String postfix) {
        return getChineseNumber(new Long(number), unit, postfix);
    }

    public static String getChineseNumber(double number, String unit, String postfix) {
        DecimalFormat f = (DecimalFormat) DecimalFormat.getInstance();
        f.applyLocalizedPattern("#.##");
        return getChineseNumber(f.format(number), unit, postfix);
    }

    public static String getChineseNumber(double number) {
        return getChineseNumber(number, null, null);
    }

    public static String getChineseNumber(Double number) {
        return getChineseNumber(number.doubleValue());
    }

    public static String getChineseNumber(Double number, String unit, String postfix) {
        return getChineseNumber(number.doubleValue(), unit, postfix);
    }

    public static void main(String[] args) {
        //System.out.println(getChineseNumber(1994));
        //System.out.println(getChineseNumber(1994.1115));
        //System.out.println(getChineseNumber(19941115));
        //System.out.println(getChineseNumber(-19941115));
        System.out.println(getChineseNumber(0.00));
    }
}
