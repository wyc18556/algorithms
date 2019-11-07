package leetcode.easy;

import java.util.Random;

/**
 * @author wyc1856
 * @date 2019/11/7
 * @description https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveEndOfList {

    public static void main(String[] args) {
        ListNode head = init();
        //计算链表长度
        int length = length(head);
        //随机生成一个数n
        int n = new Random().nextInt(length) + 1;
        //删除倒数第n位等价于删除正数第（length - n + 1）位元素
        ListNode result = delete(head, length - n + 1);
        System.out.println(result);
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

    /**
     * 删除第n位元素
     *
     * @param head
     * @param n
     * @return
     */
    private static ListNode delete(ListNode head, int n){
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode cur = sentinel;
        //定位到待删除节点的前驱节点
        while (n > 1 && cur != null){
            --n;
            cur = cur.next;
        }
        if (cur != null && cur.next != null){
            //删除节点
            cur.next = cur.next.next;
        }
        return sentinel.next;
    }

    /**
     * 计算链表长度
     *
     * @param head
     * @return
     */
    private static int length(ListNode head){
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        int length = 0;
        ListNode cur = sentinel;
        while (cur.next != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
