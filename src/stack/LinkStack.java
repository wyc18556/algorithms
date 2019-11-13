package stack;

/**
 * @author wyc1856
 * @date 2019/11/13
 * @description 基于链表实现的链式栈
 */
public class LinkStack<T> {

    private ListNode<T> head;

    private static class ListNode<T>{
        private T val;
        private ListNode<T> next;

        public ListNode(T val) {
            this.val = val;
        }
    }

    public void push(T val){
        ListNode<T> node = new ListNode<>(val);
        node.next = head;
        head = node;
    }

    public T pop(){
        if (head == null){
            return null;
        }
        T result = head.val;
        head = head.next;
        return result;
    }
}
