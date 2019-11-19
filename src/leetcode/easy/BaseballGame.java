package leetcode.easy;

import java.util.Stack;

/**
 * @author wyc1856
 * @date 2019/11/19
 * @description https://leetcode-cn.com/problems/baseball-game/
 */
public class BaseballGame {

    public static void main(String[] args) {
        BaseballGame solution = new BaseballGame();
        System.out.println(solution.calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(solution.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }

    private int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++){
            switch (ops[i]){
                case "+":
                    stack.push(stack.peek() + stack.get(stack.size() - 2));
                    break;
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(2 * stack.peek());
                    break;
                default:
                    stack.push(Integer.valueOf(ops[i]));
                    break;
            }
        }
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
