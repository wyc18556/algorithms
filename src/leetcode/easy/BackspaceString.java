package leetcode.easy;

import java.util.Stack;

/**
 * @author wyc1856
 * @date 2019/11/15
 * @description https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class BackspaceString {
    private Stack<Character> stack = new Stack<>();

    public boolean backspaceCompare(String s, String t) {
        String converts = convert(s);
        String convertt = convert(t);
        return converts.equals(convertt);
    }

    public String convert(String before){
        for (int i = 0; i < before.length(); i++){
            Character character = before.charAt(i);
            if (!character.equals('#')){
                stack.push(character);
                continue;
            }
            if (!stack.isEmpty()){
                stack.pop();
            }
        }
        char[] chars = new char[stack.size()];
        int i = 0;
        while (!stack.isEmpty()){
            chars[i++] = stack.pop();
        }
        return new String(chars);
    }
}
