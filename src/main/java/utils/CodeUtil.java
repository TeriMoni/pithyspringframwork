package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Autor: bin.liu
 * @Desciption: 编码转换工具类
 * @Date: Created in 13:19 2017/9/7
 */
public class CodeUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodeUtil.class);

    /**
     * url 编码
     * @param url
     * @return
     */
    public static String encodeURL(String url){
        String result;
        try {
            result = URLEncoder.encode(url,"utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("url encode error !",e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * url 解码
     * @param url
     * @return
     */
    public static String deocdeURL(String url){
        String result ;
        try {
            result = URLDecoder.decode(url,"utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("url decode error !",e);
            throw new RuntimeException(e);
        }
        return  result;
    }
}
