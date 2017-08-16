package top.pengcheng789.util;

import java.io.*;

/**
 * 流操作工具类
 *
 * CreateDate:2017-07-24
 *
 * @author pen
 */
public final class StreamUtil {

    /**
     * 从输入流中获取字符串
     */
    public static String getString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();
    }

    /**
     * 将输入流复制到输出流
     */
    public static void copyStream(InputStream inputStream, OutputStream outputStream)
            throws IOException {
            int length;
            byte[] buffer = new byte[4 * 1024];

            while ((length = inputStream.read(buffer, 0, buffer.length))
                    != -1) {
                outputStream.write(buffer, 0, length);
            }

            outputStream.flush();
    }
}
