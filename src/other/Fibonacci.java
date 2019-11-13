package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wyc1856
 *
 * 斐波那契数列问题
 *
 */
public class Fibonacci {
    private ThreadLocal<Map<Integer, Long>> threadLocalMap = ThreadLocal.withInitial(HashMap::new);

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        long recursiveBegin = System.currentTimeMillis();
        System.out.println(fibonacci.recursive(45));
        long recursiveEnd = System.currentTimeMillis();
        System.out.println("递归调用用时:" + (recursiveEnd - recursiveBegin));

        long recursiveWithHashBegin = System.currentTimeMillis();
        System.out.println(fibonacci.recursiveWithHash(45));
        long recursiveWithHashEnd = System.currentTimeMillis();
        System.out.println("借助hash表递归调用用时:" + (recursiveWithHashEnd - recursiveWithHashBegin));

        long notRecursiveBegin = System.currentTimeMillis();
        System.out.println(fibonacci.notRecursive(45));
        long notRecursiveEnd = System.currentTimeMillis();
        System.out.println("非递归调用用时:" + (notRecursiveEnd - notRecursiveBegin));

    }

    /**
     * 递归调用，存在重复计算，当n比较大时，效率低。
     */
    private long recursive(int n){
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
     * 使用hash表解决重复计算的问题，提高递归调用的效率
     */
    private long recursiveWithHash(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        Map<Integer, Long> map = threadLocalMap.get();
        if (map.get(n) != null){
            return map.get(n);
        }
        long result = recursiveWithHash(n - 1) + recursiveWithHash(n - 2);
        map.put(n, result);
        return result;
    }

    /**
     * 循环，当n比较大时，效率较高。
     */
    private long notRecursive(int n){
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
