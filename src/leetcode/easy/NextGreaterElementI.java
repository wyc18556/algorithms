package leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author wyc1856
 * @date 2019/11/19
 * @description https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class NextGreaterElementI {

    public static void main(String[] args) {
        NextGreaterElementI solution = new NextGreaterElementI();
        int[] ints = solution.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    private int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++){
            while (!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
