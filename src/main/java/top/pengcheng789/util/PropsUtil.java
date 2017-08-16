package top.pengcheng789.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties 文件操作工具类
 *
 * Created by pen on 17-7-2.
 */
public final class PropsUtil {

    /**
     * 加载 Properties 文件
     */
    public static Properties loadProps(String filename){
        Properties properties = null;
        InputStream inputStream = null;

        try{
            inputStream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(filename);
            if (inputStream == null){
                throw new FileNotFoundException(filename + "file is not found.");
            }

            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try{
                inputStream.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        return properties;
    }

    /**
     * 根据 key 返回字符串类型的值，当　key 不存在时返回空值
     */
    public static String getString(Properties properties, String key){
        return getString(properties, key, "");
    }

    /**
     * 根据 key 返回字符串类型的值，并设置 key 不存在时的返回值
     */
    public static String getString(Properties properties, String key, String defaultValue){
        String value = defaultValue;
        if(properties.containsKey(key)){
            value = properties.getProperty(key);
        }
        return value;
    }

    /**
     * 获取 int 类型的值（默认值为 0 ）
     */
    public static int getInt(Properties properties, String key){
        return getInt(properties, key, 0);
    }

    /**
     * 获取 int 类型的值（可指定默认值）
     */
    public static int getInt(Properties properties, String key, int defaultValue){
        int value = defaultValue;
        if(properties.containsKey(key)){
            value = CastUtil.castInt(properties.getProperty(key));
        }

        return value;
    }

    /**
     * 获取 boolean 类型属性（默认值为 false）
     */
    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }

    /**
     * 获取 boolean 类型属性（可指定默认值）
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }
}
