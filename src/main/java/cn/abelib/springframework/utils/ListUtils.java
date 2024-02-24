package cn.abelib.springframework.utils;

import java.util.List;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/1/28 17:46
 */
public class ListUtils {

    public static <T> List<T> setOrPadding(List<T> list, int index, T element) {
        return setOrPadding(list, index, element, null);
    }

    public static <T> List<T> setOrPadding(List<T> list, int index, T element, T paddingElement) {
        int size = list.size();
        if (index < size) {
            list.set(index, element);
        } else {
            for(int i = size; i < index; ++i) {
                list.add(paddingElement);
            }

            list.add(element);
        }

        return list;
    }
}
