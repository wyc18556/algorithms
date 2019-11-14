package leetcode.easy;

import java.util.Stack;

/**
 * @author wyc1856
 * @date 2019/11/14
 * @description https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {
    /**
     * 数据栈（用于存放正常的数据）
     */
    private Stack<Integer> dataStack;
    /**
     * 辅助栈（用于存放当前最小值数据）
     */
    private Stack<Integer> assistantStack;

    public MinStack() {
        dataStack = new Stack<>();
        assistantStack = new Stack<>();
    }

    public void push(int x) {
        //首先入数据栈
        dataStack.push(x);
        //判断是否为第一个元素
        if (assistantStack.isEmpty()) {
            //是第一个则也直接进负责栈
            assistantStack.push(x);
        }else {
            //非第一个，与之前入栈元素的最小值（即辅助栈栈顶元素）比较，小于等于最小元素则入辅助栈
            Integer min = assistantStack.peek();
            if (x <= min){
                assistantStack.push(x);
            }
        }
    }

    public void pop() {
        //数据栈栈顶元素出栈
        Integer pop = dataStack.pop();
        //当前数据栈栈顶元素为当前栈内最小值（即等于辅助栈栈顶元素），则辅助栈栈顶元素出栈
        if (assistantStack.peek().equals(pop)) {
            assistantStack.pop();
        }
    }

    public int top() {
        //数据栈栈顶元素
        return dataStack.peek();
    }

    public int getMin() {
        //辅助栈栈顶元素
        return assistantStack.peek();
    }
}
