package top.pengcheng789.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

/**
 * 文件操作工具类
 *
 * CreateDate:2017-07-26
 *
 * @author pen
 */
public final class FileUtil {

    /**
     * 获取真实文件名
     */
    public static String getRealFileName(String fileName) {
        return FilenameUtils.getName(fileName);
    }

    /**
     * 创建文件
     */
    public static File createFile(String filePath) {
        File file;

        try {
            file = new File(filePath);
            File parentDir = file.getParentFile();

            if (!parentDir.exists()) {
                FileUtils.forceMkdir(parentDir);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return file;
    }
}
