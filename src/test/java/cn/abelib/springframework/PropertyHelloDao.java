package cn.abelib.springframework;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 0:39
 */
public class PropertyHelloDao {

    private static Map<String, String> hashMap = Maps.newHashMap();

    static {
        hashMap.put("abel", "hello");
        hashMap.put("bob", "world");
        hashMap.put("cindy", "hi");
    }

    public String hello(String word) {
        return hashMap.get(word);
    }

    public void initMethod() {
        System.err.println("----------initMethod----------");
    }

    public void destroyMethod() {
        System.err.println("----------destroyMethod----------");
    }
}
