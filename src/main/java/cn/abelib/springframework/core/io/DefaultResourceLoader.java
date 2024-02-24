package cn.abelib.springframework.core.io;


import cn.abelib.springframework.utils.ClassUtils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 23:23
 */
public class DefaultResourceLoader implements ResourceLoader {
    private ClassLoader classLoader;

    public DefaultResourceLoader() {
        this.classLoader = ClassUtils.getDefaultClassLoader();
    }

    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()), getClassLoader());
        } else {
            try {
                // Try to parse the location as a URL...
                URL url = new URL(location);
                return new UrlResource(url);
            }
            catch (MalformedURLException ex) {
                // No URL -> resolve as FileSystem path.
                return new FileSystemResource(location);
            }
        }
    }

    @Override
    public ClassLoader getClassLoader() {
       return this.classLoader;
    }
}
