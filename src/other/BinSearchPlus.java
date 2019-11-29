package other;

/**
 * @author wyc1856
 * @date 2019/11/29
 * @decription 二分查找变体
 */
public class BinSearchPlus {

    public static void main(String[] args) {
        BinSearchPlus solution = new BinSearchPlus();
        int[] array = new int[]{1,1,2,3,3,3,5,6,6,9};
        int equalFirstIndex = solution.binSearchEqualFirst(array, 1);
        System.out.println(equalFirstIndex);
        int equalLastIndex = solution.binSearchEqualLast(array, 3);
        System.out.println(equalLastIndex);
        int lessOrEqualLastIndex = solution.binSearchLessOrEqualLast(array, 10);
        System.out.println(lessOrEqualLastIndex);
        int greaterOrEqualFirstIndex = solution.binSearchGreaterOrEqualFirst(array, 0);
        System.out.println(greaterOrEqualFirstIndex);
    }

    /**
     * 查找指定元素的第一个下标
     */
    private int binSearchEqualFirst(int[] array, int target){
        int start = 0;
        int end =  array.length - 1;
        int mid;
        while (start <= end){
            mid = start + ((end - start) >> 1);
            if (array[mid] == target){
                //找到目标元素，判断是否是第一个
                if (mid == start || array[mid - 1] != array[mid]){
                    //下标为区间左边界肯定是第一个，和前一位元素不相等也代表是第一个
                    return mid;
                }else {
                    end = mid - 1;
                }
            }else if (array[mid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找指定元素的最后一个下标
     */
    private int binSearchEqualLast(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end){
            mid = start + ((end - start) >> 1);
            if (array[mid] == target){
                //找到目标元素，判断是否是最后一个
                if (mid == end || array[mid + 1] != array[mid]){
                    //下标为区间右边界肯定是最后一个，和后一位元素不相等也代表是最后一个
                    return mid;
                }else {
                    start = mid + 1;
                }
            }else if (array[mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于指定元素的下标
     */
    private int binSearchLessOrEqualLast(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end){
            mid = start + ((end - start) >> 1);
            if (array[mid] <= target){
                //区间中间元素小于等于目标元素，那么最后一个小于等于目标元素的下标一定在[mid, end]区间内
                if (mid == end || array[mid + 1] > target){
                    //中间元素下标为区间右边界肯定是最后一个了，中间元素的后一位元素如果大于目标元素，那么中间元素就是最后一个小于等于目标元素的元素
                    return mid;
                }else {
                    start = mid + 1;
                }
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于指定元素的下标
     */
    private int binSearchGreaterOrEqualFirst(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end){
            mid = start + ((end - start) >> 1);
            if (array[mid] >= target){
                //区间中间元素大于等于目标元素，那么第一个大于等于目标元素的下标一定在[start, mid]区间内
                if (mid == start || array[mid - 1] < target){
                    //中间元素下标为区间左边界肯定是第一个了，中间元素的前一位元素如果小于目标元素，那么中间元素就是第一个大于等于目标元素的元素
                    return mid;
                }else {
                    end = mid - 1;
                }
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
