package cn.blackme.leetcode;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode67 {

    public String addBinary(String a, String b) {
        int aLen = a.length(), bLen = b.length(), n = Math.max(a.length(), b.length()), carry = 0;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < n; i++) {
            carry += i < aLen ? a.charAt(aLen - 1 - i) - '0' : 0;
            carry += i < bLen ? b.charAt(bLen - 1 - i) - '0' : 0;
            res.append(carry % 2);
            carry = carry / 2;
        }

        if (carry > 0)
            res.append('1');

        return res.reverse().toString();
    }

}
