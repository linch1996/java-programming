package cn.blackme.IO;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) throws IOException {
        /**
         * Java的class文件采用utf8的编码方式，JVM运行时采用utf16。
         * Java的字符串是unicode编码的。
         * utf-8编码中文占用3个字节，英文占用1个字节
         * gbk编码中文占用2个字节，英文占用1个字节
         */
        String s = "测试test";
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        byte[] bytes1 = s.getBytes("gbk");
        for (byte b : bytes1) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        // 乱码
        String str1 = new String(bytes1);
        System.out.println(str1);

        // 使用正确的编码
        String str2 = new String(bytes1, "gbk");
        System.out.println(str2);

        /**
         * java.io.File类用于表示文件（目录）
         * File类只用于表示文件（目录）的信息（名称、大小等），不能用于文件内容的访问
         * 常用API
         * System.out.println(file); // 打印file.toString()的内容
         * System.out.println(file.getAbsolutePath());
         * System.out.println(file.getName());
         * System.out.println(file.getParent());
         * file.mkdirs();
         */
        File file = new File("D://code/Idea/java_programming/src/cn/blackme/IO/demo.txt");
        // File file1 = new File("D:", File.separator); // 设置分隔符
        System.out.println("是否存在：" + file.exists());
        System.out.println("是否文件：" + file.isFile());
//        if (file.isDirectory() && !file.exists()) {
//            file.mkdir();
//        } else if (file.exists()) {
//            file.delete();
//        } else {
//            file.createNewFile();
//        }





    }

}
