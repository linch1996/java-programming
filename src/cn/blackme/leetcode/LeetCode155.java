package cn.blackme.leetcode;

import java.util.Stack;

/**
 * 最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode155 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public LeetCode155() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.add(x);
        } else {
            minStack.add(minStack.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty())
            return stack.peek();
        throw new RuntimeException("stack no element");
    }

    public int getMin() {
        if (!stack.isEmpty())
            return minStack.peek();
        throw new RuntimeException("stack no element");
    }

}
