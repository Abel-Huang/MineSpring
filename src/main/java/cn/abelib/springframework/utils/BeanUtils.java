package cn.abelib.springframework.utils;

import cn.abelib.springframework.beans.BeansException;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.List;
import java.util.Map;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/1/28 0:02
 */
public class BeanUtils {
    public static void setFieldValue(Object bean, String fieldNameOrIndex, Object value) {
        try {
            if (bean instanceof Map) {
                ((Map)bean).put(fieldNameOrIndex, value);
            } else if (bean instanceof List) {
               ListUtils.setOrPadding((List)bean, Convert.toInt(fieldNameOrIndex), value);
            } else if (ArrayUtils.isArray(bean)) {
                ArrayUtils.setOrAppend(bean, Convert.toInt(fieldNameOrIndex), value);
            } else {
                PropertyUtils.setProperty(bean, fieldNameOrIndex, value);
            }
        } catch (Exception e) {
            throw new BeansException("NoSuchMethodException");
        }
    }
}
