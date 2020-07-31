package cn.blackme.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int start = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (start < n && !occ.contains(s.charAt(start))) {
                occ.add(s.charAt(start));
                start++;
            }
            res = Math.max(res, start - i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabca"));
    }

}
