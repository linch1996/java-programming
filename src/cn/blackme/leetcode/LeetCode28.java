package cn.blackme.leetcode;

public class LeetCode28 {

    public int strStr(String haystack, String needle) {
        int l = needle.length();
        if (l == 0)
            return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0))
                continue;
            if (i + l > haystack.length()) {
                return -1;
            }
            int p = 0, q = i;
            while (p < l) {
               if (haystack.charAt(q) == needle.charAt(p)) {
                   p++;
                   q++;
               } else {
                   break;
               }
            }
            if (p == l)
                return i;
        }
        return -1;
    }

}
