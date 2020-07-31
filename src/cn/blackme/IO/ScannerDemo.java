package cn.blackme.IO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        sort();
    }

    /**
     * 从键盘读入10个整数，然后从大到小输出。
     */
    public static void sort() {
        Scanner in = new Scanner(System.in);
        // 不是int的
        Integer[] arr = new Integer[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) return -1;
                if (o1 < o2) return 1;
                return 0;
            }

        });
        System.err.println(Arrays.toString(arr));
    }
}
