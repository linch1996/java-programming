package cn.blackme.IO;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * IO流（输入流、输出流）
 * 字节流
 * 1. InputStream、OutputStream
 * 2. EOF = End 读到-1就读到结尾
 * 3. 基本方法
 *   int b = in.read(); 读取一个字节无符号填充到int的低8位。-1是EOF
 *   int read(byte[] buf)
 *   int read(byte[] buf, int start, int size)
 *   out.write(int b) 写出一个byte到流，b的低8位
 *   out.wirte(byte[] buf)
 *   out.wirte(byte[] buf, int start, int size)
 *
 * 4. FileInputStream -> 具体实现了在文件上的读取数据
 *
 */
public class IOUtil {

    /**
     * 读取指定文件内容，按照16进制输出到控制台
     * 并且每输出10个byte换行
     *
     * @param fileName
     */
    public static void printHex(String fileName) throws IOException {
        // 把文件作为字节流进行读操作
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while ((b = in.read()) != -1) {
            if (b <= 0xff) {
                // 单位数前面补0
                System.out.print("0");
            }
            System.out.println(Integer.toHexString(b) + " ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        in.close();
    }

}
