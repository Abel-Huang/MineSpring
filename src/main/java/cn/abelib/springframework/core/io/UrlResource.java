package cn.abelib.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 23:20
 * example:  http://abelib.cn/config.xml
 */
public class UrlResource implements Resource{
    private final URL url;

    public UrlResource(URI uri) throws MalformedURLException {
        this.url = uri.toURL();
    }

    public UrlResource(URL url) {
        this.url = url;
    }

    public UrlResource(String path) throws MalformedURLException {
        this.url = new URL(path);
    }


    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();

        try {
            return con.getInputStream();
        } catch (IOException e) {
            if (con instanceof HttpURLConnection) {
                ((HttpURLConnection)con).disconnect();
            }

            throw e;
        }
    }
}
