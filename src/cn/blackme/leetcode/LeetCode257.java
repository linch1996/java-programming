package cn.blackme.leetcode;

import cn.blackme.leetcode.definition.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        getPaths(root, paths, "");
        return paths;
    }

    public void getPaths(TreeNode node, List<String> paths, String path) {
        if (node != null) {
            path += String.valueOf(node.val);
            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                path += "->";
                getPaths(node.left, paths, path);
                getPaths(node.right, paths, path);
            }
        }
    }

}
