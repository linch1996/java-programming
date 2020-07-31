package cn.blackme.leetcode;

public class LeetCode38 {

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String str = countAndSay(n - 1);
        StringBuffer sb = new StringBuffer();
        int count = 1, length = str.length();
        for (int i = 0; i < length; i++) {
            if (i < length - 1 && (str.charAt(i) == str.charAt(i + 1))) {
                count++;
            } else {
                sb.append(count).append(str.charAt(i));
                count = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode38 l = new LeetCode38();
        System.out.println(l.countAndSay(1));
        System.out.println(l.countAndSay(2));
        System.out.println(l.countAndSay(3));
        System.out.println(l.countAndSay(4));
        System.out.println(l.countAndSay(5));
    }
}
