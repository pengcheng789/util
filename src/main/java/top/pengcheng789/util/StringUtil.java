package top.pengcheng789.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 *
 * Created by pen on 17-7-2.
 */
public final class StringUtil {

    /**
     * 字符串分隔符 "^]"
     */
    public static final String SEPARATOR = String.valueOf((char)29);

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String string){
        if(string != null){
            string = string.trim();
        }

        return StringUtils.isEmpty(string);
    }

    /**
     * 判断字符串是否不为空
     */
    public static boolean isNotEmpty(String string){
        return !isEmpty(string);
    }

    /**
     * 分割字符串
     */
    public static String[] splitString(String string, String separatorChars) {
        return StringUtils.split(string, separatorChars);
    }
}
