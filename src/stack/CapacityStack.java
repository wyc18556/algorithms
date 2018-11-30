package stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author wyc1856
 *
 * 定容栈
 */
public class CapacityStack {
    private int n;
    private String[] a;

    public CapacityStack(int n) {
        a = new String[n];
    }

    private void push(String item) {
        a[n++] = item;
    }

    private int size() {
        return n;
    }

    private String pop() {
        return a[--n];
    }

    private boolean isEmpty() {
        return n ==0;
    }

    private boolean isFull() {
        return n == a.length;
    }

    public static void main(String[] args){
        CapacityStack s = new CapacityStack(5);
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!"-".equals(item)){
                if (s.isFull()){
                    StdOut.print("栈满，添加无效\n");
                }else {
                    s.push(item);
                }
            }else if(!s.isEmpty()){
                StdOut.print(s.pop() + "\n");
            }else {
                StdOut.print("栈空\n");
            }
        }
    }
}
