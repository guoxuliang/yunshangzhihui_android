package yszhh.wlgj.com.yunshangzhihui_android.ui.tools;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @类名称: StringHelper
 * @类描述: TODO(1、判断字符串是否为null 或者 "" 工具类 2、验证是否一个正确的电话号码)
 * @作者 fengxian
 * @日期 2013-9-6 下午1:57:07
 * 
 */
public final class StringHelper {
    /**
     * 表示空字符串
     */
    public static final String EMPTY_STRING = "";

    public static boolean isNullOrEmpty(String aString) {
        if (null == aString || aString.equals(EMPTY_STRING)) {
            return true;
        }
        return false;
    }

    /** 
    * @Title: isEmail 
    * @Description: TODO(邮箱格式判断) 
    * @param @param email
    * @param @return    设定文件 
    * @return boolean    返回类型 
    * @throws 
    */
    public boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 尝试将obj转换为String，如果obj == null，则返回
     * 
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        if (null == obj) {
            return StringHelper.EMPTY_STRING;
        }
        return obj.toString();
    }

    /**
     * 将字符串转换成整数，无法转换时返回指定的默认值。
     * 
     * @param str
     *            要进行转换的字符串
     * @param defaultValue
     *            转换失败时要返回的默认值
     * @return
     */
    public static int toInteger(String str, final int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * @param phoneNumber
     *            验证正确的电话号码
     * @return
     */
    public static boolean isPhoneCDMAValid(String phoneNumber) {
        boolean isValid = false;

        /*
         * 可接受的电话格式有 ： @"^1(3[4-9]|5[012789]|8[78])\d{8}$"; 匹配移动手机号
         */
        // String expression = "^1(3[4-9]|5[012789]|8[234578]|4[7])\\d{8}$";
        /*
         * 可接受的电话格式有： 匹配电信手机号 @"^18[0-9]\d{8}$";
         */
        String expression2 = "^18[019]\\d{8}$";
        /*
         * 可接受的电话格式有： 匹配联通手机号 1(3[0-2]|5[56]|8[56])\d{8}$";
         */
        // String expression3 = "^1(3[0-2]|5[56]|8[56])\\d{8}$";
        /*
         * 可接受的电话格式有： 匹配CDMA手机号 @"^1[35]3\d{8}$";
         */

        String expression4 = "^1[35]3\\d{8}$";
        String expression5 = "^17[07]\\d{8}$";

        CharSequence inputStr = phoneNumber;
        // Pattern pattern = Pattern.compile(expression);
        // Matcher matcher = pattern.matcher(inputStr);

        Pattern pattern2 = Pattern.compile(expression2);
        Matcher matcher2 = pattern2.matcher(inputStr);
        // Pattern pattern3 = Pattern.compile(expression3);
        // Matcher matcher3 = pattern3.matcher(inputStr);
        Pattern pattern4 = Pattern.compile(expression4);
        Matcher matcher4 = pattern4.matcher(inputStr);
        Pattern pattern5 = Pattern.compile(expression5);
        Matcher matcher5 = pattern5.matcher(inputStr);
        if (matcher2.matches() || matcher4.matches() || matcher5.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * @Title: isDianxinPhone
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param phone
     * @param @return 设定文件
     * @return boolean 返回类型
     * @throws
     */
    public static boolean isDianxinPhone(String phone) {

        if (phone.indexOf("133") == 0 || phone.indexOf("153") == 0 || phone.indexOf("180") == 0 || phone.indexOf("181") == 0
                || phone.indexOf("189") == 0 || phone.indexOf("177") == 0 || phone.indexOf("170") == 0) {
            return true;
        }
        return false;
    }

    /**
     * @param postcode
     *            验证正确的邮政编码
     * @return
     */
    public static boolean isPostCodeValid(String postcode) {
        boolean isValid = false;

        /*
         * 可接受的电话格式有 ： @"^1(3[4-9]|5[012789]|8[78])\d{8}$"; 匹配移动手机号
         */
        String expression = "^[1-9]\\d{5}$";
        CharSequence inputStr = postcode;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**
     *            验证邮箱格式
     * @return
     */
    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "\\w+@(\\w+.)+[a-z]{2,3}";
        String expression1 = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        String expression2 = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        Pattern pattern1 = Pattern.compile(expression1);
        Matcher matcher1 = pattern.matcher(inputStr);
        Pattern pattern2 = Pattern.compile(expression2);
        Matcher matcher2 = pattern.matcher(inputStr);
        if (matcher.matches() || matcher1.matches() || matcher2.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * @param phoneNumber
     *            验证正确的电话号码
     * @return
     */
    public static boolean isPhoneNumberValid(String phoneNumber) {
        boolean isValid = false;

        /*
         * 可接受的电话格式有 ： @"^1(3[4-9]|5[012789]|8[78])\d{8}$"; 匹配移动手机号
         */
        String expression = "^1(3[4-9]|5[012789]|8[234578]|4[7])\\d{8}$";
        /*
         * 可接受的电话格式有： 匹配电信手机号 @"^18[0-9]\d{8}$";
         */
        String expression2 = "^18[019]\\d{8}$";
        /*
         * 可接受的电话格式有： 匹配联通手机号 1(3[0-2]|5[56]|8[56])\d{8}$";
         */
        String expression3 = "^1(3[0-2]|5[56]|8[56])\\d{8}$";
        /*
         * 可接受的电话格式有： 匹配CDMA手机号 @"^1[35]3\d{8}$";
         */
        String expression4 = "^1[35]3\\d{8}$";
        String expression5 = "^17[07]\\d{8}$";

        // 邮箱的格式
        String expression6 = "\\w+@(\\w+.)+[a-z]{2,3}";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);

        Pattern pattern2 = Pattern.compile(expression2);
        Matcher matcher2 = pattern2.matcher(inputStr);
        Pattern pattern3 = Pattern.compile(expression3);
        Matcher matcher3 = pattern3.matcher(inputStr);
        Pattern pattern4 = Pattern.compile(expression4);
        Matcher matcher4 = pattern4.matcher(inputStr);
        Pattern pattern5 = Pattern.compile(expression5);
        Matcher matcher5 = pattern5.matcher(inputStr);
        if (matcher.matches() || matcher2.matches() || matcher3.matches() || matcher4.matches() || matcher5.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * 将字节数组转换成十六进制表示的字符串。
     * 
     * @param raw
     * @return
     */
    public static String toHexString(byte[] raw) {
        byte[] hex = new byte[2 * raw.length];
        int index = 0;

        for (byte b : raw) {
            int v = b & 0xFF;
            hex[index++] = HEX_CHAR_TABLE[v >>> 4];
            hex[index++] = HEX_CHAR_TABLE[v & 0xF];
        }
        try {
            return new String(hex, "ASCII");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    static final byte[] HEX_CHAR_TABLE = { (byte) '0', (byte) '1', (byte) '2', (byte) '3', (byte) '4', (byte) '5', (byte) '6', (byte) '7',
            (byte) '8', (byte) '9', (byte) 'a', (byte) 'b', (byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f' };
}
