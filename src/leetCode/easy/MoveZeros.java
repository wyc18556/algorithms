package leetCode.easy;

import java.util.Arrays;

/**
 * @Author wyc1856
 * @Date 2018/11/16 9:12
 * @Description https://leetcode-cn.com/problems/move-zeroes
 **/
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        System.out.println(Arrays.toString(move1(nums)));
        System.out.println(Arrays.toString(move2(nums)));
        System.out.println(Arrays.toString(move3(nums)));
    }

    private static int[] move1(int[] nums){
        int[] copyNums = new int[nums.length];
        int i = 0;
        for (int num : nums){
            if (num != 0){
                copyNums[i++] = num;
            }
        }
        return copyNums;
    }

    private static int[] move2(int[] nums){
        int k = 0;
        for (int num : nums){
            if (num != 0){
                nums[k++] = num;
            }
        }
        while (k < nums.length){
            nums[k++] = 0;
        }
        return nums;
    }

    private static int[] move3(int[] nums){
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                if (k != i){
                    int tmp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = tmp;
                }
                k++;
            }
        }
        return nums;
    }
}
