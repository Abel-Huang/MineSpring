package cn.abelib.springframework.utils;

import java.util.Collection;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/1/25 23:59
 */
public class StringUtils {

    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }

        return collection.toArray(new String[collection.size()]);
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isNotEmpty(cs);
    }

    public static boolean isEmpty(CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isEmpty(cs);
    }

    public static String lowerCase(String str) {
        return org.apache.commons.lang3.StringUtils.lowerCase(str);
    }
}
