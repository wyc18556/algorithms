package leetcode.easy;

/**
 * @author wyc1856
 * @date 2019/11/7
 * @description https://leetcode-cn.com/problems/merge-two-sorted-lists/comments/
 */
public class MergeList {

    public static void main(String[] args) {
        ListNode listNode = mergeTwoList(initL(), initR());
        System.out.println(listNode);
    }

    private static ListNode mergeTwoList(ListNode l1, ListNode l2){
        //定义一个哨兵节点
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                //取较小元素拼接在cur节点后
                cur.next = l1;
                //将小元素所在链表的标记指针后移
                l1 = l1.next;
            }else{
                //和上面同理
                cur.next = l2;
                l2 = l2.next;
            }
            //当前元素指针后移
            cur = cur.next;
        }
        //任一链表为空，直接连接另外一条链表
        if (l1 == null){
            cur.next = l2;
        }else {
            cur.next = l1;
        }
        //返回哨兵节点的next节点
        return sentinel.next;
    }

    private static ListNode initL(){
        ListNode nodeL1 = new ListNode(1);
        ListNode nodeL2 = new ListNode(2);
        ListNode nodeL3 = new ListNode(5);

        nodeL1.next = nodeL2;
        nodeL2.next = nodeL3;
        return nodeL1;
    }

    private static ListNode initR(){
        ListNode nodeR1 = new ListNode(1);
        ListNode nodeR2 = new ListNode(3);
        ListNode nodeR3 = new ListNode(4);
        ListNode nodeR4 = new ListNode(8);
        ListNode nodeR5 = new ListNode(10);

        nodeR1.next = nodeR2;
        nodeR2.next = nodeR3;
        nodeR3.next = nodeR4;
        nodeR4.next = nodeR5;
        return nodeR1;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
