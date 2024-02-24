package cn.abelib.springframework.utils;

import cn.abelib.springframework.core.io.SpringIOException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.io.Reader;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/1/27 23:38
 */
public class XmlUtils {

    public static Document readXML(InputStream inputStream) throws SpringIOException {
        return readXML(new InputSource(inputStream));
    }

    public static Document readXML(Reader reader) throws SpringIOException {
        return readXML(new InputSource(reader));
    }

    public static Document readXML(InputSource source) {
        DocumentBuilder builder = createDocumentBuilder();

        try {
            return builder.parse(source);
        } catch (Exception e) {
            throw new SpringIOException("Parse XML from stream error!", e);
        }
    }

    public static DocumentBuilder createDocumentBuilder() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            return factory.newDocumentBuilder();
        } catch (Exception e) {
            throw new SpringIOException("Parse XML from stream error!", e);
        }
    }
}
