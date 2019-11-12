package queue;

/**
 * @author wyc1856
 * @date 2019/11/12
 * @description 基于链表的队列实现
 */
public class LinkQueue {

    private ListNode head;
    private ListNode tail;

    public boolean enqueue(String val){
        ListNode node = new ListNode(val);
        if (head == null){
            head = tail = node;
        }else {
            tail.next = node;
            tail = tail.next;
        }
        return true;
    }

    public ListNode dequeue(){
        if (head == null){
            System.out.println("队列为空");
            return null;
        }
        ListNode node = head;
        //其实当出队元素为最后一个元素时，也可不把tail置空，因为入队时判断队列是否为空是通过head是否为空判断的。
        /*if (head.next == null){
            tail = null;
        }*/
        head = head.next;
        return node;
    }

    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
        int size = 5;
        //入队
        for (int i = 0; i < size; i++){
            queue.enqueue(String.valueOf(i));
            System.out.println(String.format("元素%s入队成功", i));
        }

        //出队
        for (int i = 0; i < size + 1; i++){
            ListNode node = queue.dequeue();
            if (node != null){
                System.out.println(String.format("元素%s出队成功", node.val));
            }else {
                System.out.println("队列已空");
            }
        }

        //空队列重新入队
        queue.enqueue("ONE");
        System.out.println(String.format("空队列重新入队一个元素后，队头元素为%s，队尾元素为%s", queue.head.val, queue.tail.val));
    }

    static class ListNode{
        String val;
        ListNode next;

        public ListNode(String val) {
            this.val = val;
        }
    }
}
