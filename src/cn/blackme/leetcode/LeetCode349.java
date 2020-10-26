package cn.blackme.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1)
            set1.add(i);
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2)
            set2.add(i);

        return set1.size() > set2.size() ? intersection(set2, set1) : intersection(set1, set2);
    }

    public int[] intersection(Set<Integer> set1, Set<Integer> set2) {
        int[] res = new int[set1.size()];
        int n = 0;
        for (int i : set1) {
            if (set2.contains(i))
                res[n++] = i;
        }
        return Arrays.copyOf(res, n);
    }

}
