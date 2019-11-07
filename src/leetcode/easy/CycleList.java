package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wyc1856
 * @date 2019/11/7
 * @description https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class CycleList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        //形成环
        node4.next = node2;
        System.out.println(hasCycle(node1));
    }

    private static boolean hasCycle(ListNode head) {
        //快慢指针发
        /*
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
        */

        //set集合发
//        /*
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
//        */
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
