package top.pengcheng789.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 类操作工具类
 *
 * CreateDate:2017-07-23
 *
 * @author pen
 */
public final class ClassUtil {

    /**
     * 获取类加载器
     */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 加载类
     */
    public static Class<?> loadClass(String className, boolean isInitializes)
            throws ClassNotFoundException {
        return Class.forName(className, isInitializes, getClassLoader());
    }

    /**
     * 加载类（默认将初始化类）
     */
    public static Class<?> loadClass(String className) throws ClassNotFoundException {
        return loadClass(className, true);
    }

    /**
     * 获取指定包名下的所有类
     */
    public static Set<Class<?>> getClassSet(String packageName)
            throws IOException, ClassNotFoundException{
        Set<Class<?>> classSet = new HashSet<Class<?>>();

        Enumeration<URL> urls = getClassLoader()
                .getResources(packageName.replace(".", "/"));
        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            if(url != null){
                String protocol = url.getProtocol();
                if(protocol.equals("file")){
                    String packagePath = url.getPath().replaceAll("%20", " ");
                    addClass(classSet, packagePath, packageName);
                } else if (protocol.equals("jar")) {
                    JarURLConnection jarURLConnection =
                            (JarURLConnection)url.openConnection();
                    if (jarURLConnection != null){
                        JarFile jarFile = jarURLConnection.getJarFile();
                        if (jarFile != null){
                            Enumeration<JarEntry> jarEntries = jarFile.entries();
                            while (jarEntries.hasMoreElements()){
                                JarEntry jarEntry = jarEntries.nextElement();
                                String jarEntryName = jarEntry.getName();
                                if (jarEntryName.endsWith(".class")) {
                                    String className = jarEntryName
                                            .substring(0, jarEntryName.lastIndexOf("."))
                                            .replaceAll("/", ".");
                                    doAddClass(classSet, className);
                                }
                            }
                        }
                    }
                }
            }
        }

        return classSet;
    }

    private static void addClass (
            Set<Class<?>> classSet, String packagePath, final String packageName)
            throws ClassNotFoundException {
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return (pathname.isFile() && pathname.getName().endsWith(".class"))
                        || pathname.isDirectory();
            }
        });

        for (File file : files){
            String fileName = file.getName();
            if(file.isFile()){
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                if(StringUtil.isNotEmpty(packageName)){
                    className = packageName + "." + className;
                    doAddClass(classSet, className);
                }

            } else {
                String subPackagePath = fileName;
                if (StringUtil.isNotEmpty(packagePath)){
                    subPackagePath = packagePath + "/" + subPackagePath;
                }

                String subPackageName = fileName;
                if (StringUtil.isNotEmpty(packageName)){
                    subPackageName = packageName + "." + subPackageName;
                }
                addClass(classSet, subPackagePath, subPackageName);
            }
        }
    }

    private static void doAddClass(Set<Class<?>> classSet, String className)
            throws ClassNotFoundException{
        Class<?> cls = loadClass(className, false);
        classSet.add(cls);
    }
}
