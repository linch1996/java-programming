package cn.blackme.IO;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    /**
     * 列出指定目录下（包括子目录的所有文件）
     *
     * @param dir
     * @throws IOException
     */
    public static void listDirectory(File dir) throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录不存在：" + dir);
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录");
        }

        // String[] fileNames = dir.list(); // 返回的是字符串数组
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listDirectory(file);
                } else {
                    System.out.println(file);
                }
            }
        }

    }

}
