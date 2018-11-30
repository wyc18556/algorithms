package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wyc1856
 * @Date 2018/11/16 9:55
 * @Description https://leetcode-cn.com/problems/two-sum
 **/
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum1(nums, target)));
        System.out.println(Arrays.toString(twoSum2(nums, target)));
        System.out.println(Arrays.toString(twoSum3(nums, target)));
    }

    private static int[] twoSum1(int[] nums, int target){
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>(10);
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return null;
    }

    private static int[] twoSum3(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>(10);
        for (int i = 0; i < nums.length; i++){
            //下标在i之前的元素中包含目标元素
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            //此操作放在后面，可以省略判断当前元素不能等于目标元素
            map.put(nums[i], i);
        }
        return null;
    }
}
