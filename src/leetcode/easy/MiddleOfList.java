package leetcode.easy;

/**
 * @author wyc1856
 * @date 2019/11/7
 * @description https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfList {

    public static void main(String[] args) {
        ListNode node = middleNode(init());
        System.out.println(node);
    }

    private static ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        //使用快慢指针，fast速度是slow的2倍
        //当链表长度为偶数时，有两个中间节点。fast最终为null，此时slow指向第二个中间节点
        //当链表长度为奇数时，有一个中间节点。fast.next最终为null，此时slow指向中间节点
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode init(){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
