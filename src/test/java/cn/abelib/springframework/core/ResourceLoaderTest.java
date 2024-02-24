package cn.abelib.springframework.core;

import cn.abelib.springframework.core.io.DefaultResourceLoader;
import cn.abelib.springframework.core.io.Resource;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/26 23:30
 */
public class ResourceLoaderTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void testClasspath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:spring.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8.toString());
        System.out.println(content);
    }

    @Test
    public void testFile() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/spring.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8.toString());
        System.out.println(content);
    }
}
