package com.wp.youbuy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @desc 手机号工具类
 * @Author wenpeng
 * @2018年3月20日 上午9:44:09
 */
public class MobileUtil {

    private static Pattern p = Pattern.compile("^1\\d{10}$");

    public static boolean isValidPhoneNumber(String mobile) {
        if (mobile == null) {
            return false;
        }
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

}
