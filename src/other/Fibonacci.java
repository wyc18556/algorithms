package other;

/**
 * 斐波那契数列问题
 *
 */
public class Fibonacci {

    public static void main(String[] args) {
        long recursiveBegin = System.currentTimeMillis();
        System.out.println(recursive(45));
        long recursiveEnd = System.currentTimeMillis();
        System.out.println("递归调用用时:" + (recursiveEnd - recursiveBegin));
        long notRecursiveBegin = System.currentTimeMillis();
        System.out.println(notRecursive(45));
        long notRecursiveEnd = System.currentTimeMillis();
        System.out.println("非递归调用用时:" + (notRecursiveEnd - notRecursiveBegin));

    }

    /**
     * 递归调用，存在重复计算，当n比较大时，效率低。
     * @param n
     * @return
     */
    private static long recursive(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    /**
     * 循环，当n比较大时，效率较高。
     * @param n
     * @return
     */
    private static long notRecursive(int n){
        long before = 1;
        long after = 2;
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return before;
        }
        if (n == 2){
            return after;
        }
        for (int i = 3; i <= n; i ++){
            long template = after;
            after = before + after;
            before = template;
        }
        return after;
    }
}
