package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyc1856
 * @date 2019/11/14
 * @description https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    private Map<Character, Character> map = new HashMap<>(4);
    private ListNode head;

    private static class ListNode{
        private Character val;
        private ListNode next;

        public ListNode(Character val) {
            this.val = val;
        }
    }

    private void enqueue(Character item){
        ListNode node = new ListNode(item);
        node.next = head;
        head = node;
    }

    private Character dequeue(){
        if (head == null){
            return null;
        }
        Character result = head.val;
        head = head.next;
        return result;
    }

    public void mapInit(){
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public boolean isValid(String s) {
        mapInit();
        for (int i = 0; i < s.length(); i++){
            Character cur = s.charAt(i);
            if (map.get(cur) != null) {
                //cur为左括号，入栈与其匹配的右括号
                enqueue(map.get(cur));
            }else {
                //cur为右括号，栈顶元素match出栈与其对比
                Character match = dequeue();
                if (match == null || !match.equals(cur)){
                    return false;
                }
            }
        }
        return head == null;
    }
}
