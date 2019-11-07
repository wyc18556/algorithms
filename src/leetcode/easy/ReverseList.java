package leetcode.easy;

/**
 * @author wyc1856
 * @date 2019/2/16 20:46
 * @description https://leetcode-cn.com/problems/reverse-linked-list/
 **/
public class ReverseList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        node4.next = new ListNode(5);
        System.out.println(node1);
        node1 = reverse(node1);
        System.out.println(node1);
    }

    private static ListNode reverse(ListNode head){
        ListNode pre = null, next;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            ListNode copy = this;
            StringBuilder result = new StringBuilder();
            result.append(copy.val);
            while (copy.next != null){
                result.append("->").append(copy.next.val);
                copy = copy.next;
            }
            result.append("->NULL");
            return result.toString();
        }
    }
}
