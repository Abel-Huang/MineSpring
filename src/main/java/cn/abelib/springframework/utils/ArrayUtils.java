package cn.abelib.springframework.utils;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/1/28 17:26
 */
public class ArrayUtils {

    public static boolean isArray(Object object) {
        if (Objects.isNull(object)) {
            return false;
        }
        return object.getClass().isArray();
    }

    public static Object setOrAppend(Object array, int index, Object value) {
        int len = length(array);
        if (index < len) {
            Array.set(array, index, value);
            return array;
        } else {
            return append(array, index, value);
        }
    }

    public static int length(Object array) throws IllegalArgumentException {
        return null == array ? 0 : Array.getLength(array);
    }

    public static Object append(Object array, int index, Object value) throws IllegalArgumentException {
        int len = index + 1;
        Object[] source = (Object[]) array;
        Object[] dest = new Object[len + 1];
        System.arraycopy(source, 0, dest, 0, len);
        Array.set(array, index, value);
        return dest;
    }
}
