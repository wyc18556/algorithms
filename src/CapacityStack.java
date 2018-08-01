import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 定容栈
 */
public class CapacityStack {
    private int N;
    private String[] a;

    public CapacityStack(int n) {
        a = new String[n];
    }

    private void push(String item) {
        a[N++] = item;
    }

    private int size() {
        return N;
    }

    private String pop() {
        return a[--N];
    }

    private boolean isEmpty() {
        return N ==0;
    }

    private boolean isFull() {
        return N == a.length;
    }

    public static void main(String[] args){
        CapacityStack s = new CapacityStack(5);
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
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
