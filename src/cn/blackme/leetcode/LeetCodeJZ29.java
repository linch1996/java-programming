package cn.blackme.leetcode;

import java.util.Arrays;

/**
 * 顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCodeJZ29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int rows = matrix[0].length, columns = matrix.length;
        int x = 0, y = 0, index = 0;
        int[] res = new int[rows * columns];
        while (x < rows && y < columns) {
            for (int i = x; i < rows; i++)
                res[index++] = matrix[x][i];
            for (int i = y + 1; i < columns; i++)
                res[index++] = matrix[i][rows - 1];
            if (x < rows - 1 && y < columns - 1) {
                for (int i = rows - 2; i > x; i--)
                    res[index++] = matrix[columns - 1][i];
                for (int i = columns - 1; i > y; i--)
                    res[index++] = matrix[i][y];
            }
            x++;
            y++;
            rows--;
            columns--;
        }
        return res;
    }

}
