package leetCode.mide;

/**
 * @Author wyc1856
 * @Date 2018/11/15 19:36
 * @Description https://leetcode-cn.com/problems/add-two-numbers
 **/
public class AddTwoNumber {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;

        System.out.println(compute(l1, r1));
    }

    public static ListNode compute(ListNode l, ListNode r){
        ListNode dummyHead = new ListNode(0);//假表头
        ListNode current = dummyHead;
        int carry = 0;//进位
        while (l != null || r != null){
            int x = l == null ? 0 : l.val;
            int y = r == null ? 0 : r.val;
            int eachSum = x + y + carry;
            carry = eachSum / 10;
            current.next = new ListNode(eachSum % 10);
            current = current.next;
            if (l != null) l = l.next;
            if (r != null) r = r.next;
        }
        if (carry > 0){//最高位之和存在进位
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    static class ListNode{

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(val);
            while (next != null){
                stringBuilder.append("->");
                stringBuilder.append(next.val);
                next = next.next;
            }
            return stringBuilder.toString();
        }
    }
}
