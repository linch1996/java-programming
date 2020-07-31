package cn.blackme.IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * RandomAccessFile java提供的对文件的内容访问，即可以读文件，也可以写文件
 * RandomAccessFile 支持随机访问文件，可以访问文件的任意位置
 *
 * 1. Java文件模型
 *  在硬盘上的文件是byte存储的，是数据的集合
 * 2. 打开文件
 *  有两种模式 rw 和 r
 *  RandomAccessFile raf = new RandomAccessFile(file, "rw");
 *  文件指针，打开文件时指针在开头 pointer = 0;
 * 3. 写方法
 *  raf.write(int) -> 只写一个字节（后8位），同时指针指向下一个位置，准备再次写入
 * 4. 读方法
 *  int b = raf.read() -> 读一个字节
 * 5. 文件读写完成要关闭
 */
public class RafDemo {

    public static void main(String[] args) throws IOException {
        File demo = new File("demo");
        if (!demo.exists())
            demo.mkdir();
        File file = new File(demo, "raf.dat");
        if (!file.exists())
            file.createNewFile();

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        // 指针的位置
        System.out.println(raf.getFilePointer());

        raf.write('A');
        System.out.println(raf.getFilePointer());
        raf.write('B');

        int i = 0x7fffffff;
        // 用write方法每次只能写一个字节，如果要把i写进去就得写4次
        raf.write(i >>> 24); // 高8位
        raf.write(i >>> 16);
        raf.write(i >>> 8);
        raf.write(i);
        System.out.println(raf.getFilePointer());

        // 可以直接写一个int
        raf.writeInt(i);

        String s = "中";
        byte[] gbk = s.getBytes("gbk");
        raf.write(gbk);
        System.out.println(raf.length());

        // 读文件，必须把指针移到头部
        raf.seek(0);
        // 一次性读取，把文件中的内容都读到字节数组中
        byte[] buf = new byte[(int)raf.length()];
        raf.read(buf);

        System.out.println(Arrays.toString(buf));
//        String str1 = new String(buf, "gbk");
//        System.out.println(str1);

        for (byte b : buf) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        raf.close();

    }

}
