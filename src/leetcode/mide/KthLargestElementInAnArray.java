package leetcode.mide;

/**
 * @author wyc1856
 * @date 2019/11/22
 * @description https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        int kthLargest = solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        return find(k, nums, 0, nums.length - 1);
    }

    private int find(int k, int[] array, int begin, int end){
        int partition = partition(array, begin, end);
        if (partition == k - 1){
            return array[partition];
        }
        if (partition < k -1){
            return find(k, array, partition + 1, end);
        }
        return find(k, array, begin, partition - 1);
    }

    private int partition(int[] array, int begin, int end){
        int i = begin, j = begin;
        int temp;
        for (; j < end; j++){
            if (array[j] > array[end]){
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;
            }
        }
        temp = array[end];
        array[end] = array[i];
        array[i] = temp;
        return i;
    }
}
