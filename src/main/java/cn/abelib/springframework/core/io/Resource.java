package cn.abelib.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 23:17
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
