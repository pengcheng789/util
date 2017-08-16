package top.pengcheng789.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码与解码操作工具类
 *
 * CreateDate:2017-07-24
 *
 * @author pen
 */
public final class CodecUtil {

    /**
     * 将 URL 编码
     */
    public static String encodeURL(String source) throws UnsupportedEncodingException {
        return URLEncoder.encode(source, "UTF-8");
    }

    /**
     * 将 URL 解码
     */
    public static String decodeURL(String source) throws UnsupportedEncodingException {
        return URLDecoder.decode(source, "UTF-8");
    }

    /**
     * MD5 加密
     */
    public static String md5(String source) {
        return DigestUtils.md5Hex(source);
    }
}
