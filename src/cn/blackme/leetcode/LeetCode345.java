package cn.blackme.leetcode;

/**
 * 反转字符串中的元音字母
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *  
 *
 * 提示：
 *
 * 元音字母不包含字母 "y" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode345 {

    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        int left = 0, rigth = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < rigth) {
            while (left < rigth && !vowels.contains(chars[left] + ""))
                left++;
            while (left < rigth && !vowels.contains(chars[rigth] + ""))
                rigth--;
            if (left > rigth)
                break;
            char tmp = chars[left];
            chars[left] = chars[rigth];
            chars[rigth] = tmp;
            left++;
            rigth--;
        }
        return new String(chars);
    }

}
