package cn.blackme.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        long pre = 1;
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            long cur = pre * (rowIndex - i + 1) / i;
            res.add((int)cur);
            pre = cur;
        }
        return res;
    }

}
