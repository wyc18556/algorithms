package queue;

/**
 * @author wyc1856
 * @date 2019/11/12
 * @description 双端队列是一种多功能的数据结构，能提供队列和栈两种功能。
 */
public class DoubleEndsQueue {

    private ListNode head;
    private ListNode tail;

    static class ListNode{
        String val;
        ListNode pre;
        ListNode next;

        public ListNode(ListNode pre, String val, ListNode next) {
            this.pre = pre;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 在头节点前面入队
     */
    public boolean enqueueFirst(String val){
        final ListNode first = head;
        ListNode node = new ListNode(null, val, first);
        //头节点指向新节点
        head = node;
        if (first == null){
            //最后一个节点也指向新节点
            tail = node;
        }else {
            //之前的头节点的前驱节点指向新节点
            first.pre = node;
        }
        return true;
    }

    /**
     * 在尾节点后面入队
     */
    public boolean enqueueLast(String val){
        final ListNode last = tail;
        ListNode node = new ListNode(last, val, null);
        //尾节点指向新节点
        tail = node;
        if (last == null){
            //第一个节点也指向新节点
            head = node;
        }else {
            //之前的尾节点的后继节点指向新节点
            last.next = node;
        }
        return true;
    }

    /**
     * 从头节点开始出队
     */
    public ListNode dequeueFirst(){
        if (head == null){
            System.out.println("队列为空");
            return null;
        }
        //出队节点为当前头节点
        ListNode node = head;
        if (head.next == null){
            //队列只有一个节点
            head = tail = null;
        }else {
            //头节点后移
            head = head.next;
            //头节点前驱节点置空
            head.pre = null;
            //出队节点后继节点置空
            node.next = null;
        }
        return node;
    }

    /**
     * 从尾节点开始出队
     */
    public ListNode dequeueLast(){
        if (tail == null){
            System.out.println("队列为空");
            return null;
        }
        //出队节点为当前尾节点
        ListNode node = tail;
        if (tail.pre == null){
            //队列只有一个节点
            head = tail = null;
        }else {
            //尾节点前移
            tail = tail.pre;
            //尾节点后继节点置空
            tail.next = null;
            //出队节点前驱节点置空
            node.pre = null;
        }
        return node;
    }
}
