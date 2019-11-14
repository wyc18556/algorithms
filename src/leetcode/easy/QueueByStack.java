package leetcode.easy;

import java.util.Stack;

/**
 * @author wyc1856
 * @date 2019/11/14
 * @description https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class QueueByStack {

    // 方法一 出队操作并未从栈中清除数据，而是通过popCount标记队头元素的位置。数据量大时，内存空间占用大

    private Stack<Integer> stack;
    /** 出队次数 */
    private int popCount;

    public QueueByStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        return stack.get(popCount++);
    }

    public int peek() {
        return stack.get(popCount);
    }

    public boolean empty() {
        return stack.size() == popCount;
    }

    /*
    // 方法二：倾倒发
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private Integer front;

    public QueueByStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            return front;
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    */
}
