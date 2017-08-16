package top.pengcheng789.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 *
 * CreateDate:2017-07-23
 *
 * @author pen
 */
public final class ReflectionUtil {

    /**
     * 创建实例
     */
    public static Object newInstance(Class<?> cls)
            throws InstantiationException, IllegalAccessException {

        return cls.newInstance();
    }

    /**
     * 创建实例（根据类名）
     */
    public static Object newInstance(String className)
            throws InstantiationException, IllegalAccessException {
        Class<?> cls = ClassUtil.loadClass(className);
        return newInstance(cls);
    }

    /**
     * 调用方法
     */
    public static Object invokeMethod(Object obj, Method method, Object... args)
            throws IllegalAccessException, InvocationTargetException {
        method.setAccessible(true);
        Object result = method.invoke(obj, args);

        return result;
    }

    /**
     * 设置成员变量
     */
    public static void setField(Object obj, Field field, Object value)
            throws IllegalAccessException {
        field.setAccessible(true);
        field.set(obj, value);
    }
}
