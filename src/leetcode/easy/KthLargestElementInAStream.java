package leetcode.easy;

import java.util.PriorityQueue;

/**
 * @author wyc1856
 * @date 2019/11/22
 * @description https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestElementInAStream {

    private int limit;
    private PriorityQueue<Integer> queue;

    public static void main(String[] args) {
        KthLargestElementInAStream solution = new KthLargestElementInAStream(3, new int[]{4,5,8,2});
        System.out.println(solution.add(3));
        System.out.println(solution.add(5));
        System.out.println(solution.add(10));
        System.out.println(solution.add(9));
        System.out.println(solution.add(4));
    }

    public KthLargestElementInAStream(int k, int[] nums) {
        this.limit = k;
        this.queue = new PriorityQueue<>(k);
        //借助jdk的优先队列，维护一个k个元素的最小堆
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        //队列未满，直接入队
        if (queue.size() < limit){
            queue.offer(val);
        }else if (queue.peek() < val){
            //队列已满，堆顶元素小于入队元素，堆顶元素出队，新元素入队
            queue.poll();
            queue.offer(val);
        }
        //返回堆顶元素
        return queue.peek();
    }
}
