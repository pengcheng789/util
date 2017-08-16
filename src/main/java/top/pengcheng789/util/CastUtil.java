package top.pengcheng789.util;

/**
 * 对象转换常用类型工具类
 *
 * Created by pen on 17-7-2.
 */
public final class CastUtil {

    /**
     * 对象转化为字符串（默认值为控空字符串）
     */
    public static String castString(Object object){
        return CastUtil.castString(object, "");
    }

    /**
     * 对象转化为字符串（可指定默认值）
     */
    public static String castString(Object object, String defaultValue){
        return object != null ? String.valueOf(object) : defaultValue;
    }

    /**
     * 对象转化为整型（默认值为 0 ）
     */
    public static int castInt(Object object){
        return CastUtil.castInt(object, 0);
    }

    /**
     * 对象转化为整型（可指定默认值 ）
     */
    public static int castInt(Object object, int defaultValue){
        int intValue = defaultValue;
        if(object != null){
            String strValue = castString(object);
            if(StringUtil.isNotEmpty(strValue)){
                try{
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e){
                    intValue = defaultValue;
                }
            }
        }

        return intValue;
    }

    /**
     * 对象转化为布尔类型（默认值为 false ）
     */
    public static boolean castBoolean(Object object){
        return CastUtil.castBoolean(object, false);
    }

    /**
     * 对象转化为布尔类型（可指定默认值）
     */
    public static boolean castBoolean(Object object, boolean defaultValue){
        boolean booleanValue = defaultValue;
        if(object != null){
            booleanValue = Boolean.parseBoolean(castString(object));
        }
        return booleanValue;
    }
}
