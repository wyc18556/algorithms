package leetcode.difficult;

import java.util.Stack;

/**
 * @author wyc1856
 * @date 2019/11/18
 * @description https://leetcode-cn.com/problems/basic-calculator/
 */
public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator solution = new BasicCalculator();
        System.out.println(solution.calculate("1 + 1"));
        System.out.println(solution.calculate(" 2-1 + 2 "));
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(solution.calculate("2147483647"));
    }

    private int calculate(String str) {
        Stack<Integer> stack = new Stack<>();
        //标记正负（1-正,-1负）
        int sign = 1;
        int res = 0;
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int cur = c - '0';
                //多位数字
                while (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))){
                    cur = cur * 10 + str.charAt(++i) - '0';
                }
                //当前结果 = 上一个结果 + (当前数字 * 上一个操作符)
                res = res + cur * sign;
            }else if (c == '+'){
                sign = 1;
            }else if (c == '-'){
                sign = -1;
            }else if (c == '('){
                //遇左括号，将之前的值和操作符入栈，并重置res和sign
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            }else if(c == ')'){
                //遇右括号，栈顶第一个元素(配对左括号之前的操作符) * 当前结果 + 栈顶第二个元素(配对左括号之前的结果)
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}
