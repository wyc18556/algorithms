package leetcode.mide;

/**
 * @author wyc1856
 * @date 2019/11/28
 * @description https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int[] array = new int[]{11,13,14,15,16,17,20,1,3};
        int index = solution.search(array, 20);
        System.out.println(index);
    }

    private int search(int[] array, int target){
        return recursiveSearch(array, 0, array.length -1 , target);
    }

    private int recursiveSearch(int[] array, int start, int end, int target){
        if (start > end){
            return -1;
        }
        int mid = start + ((end - start) >> 1);
        if (array[mid] > array[start]){
            //前半部分有序
            if (target >= array[start] && target <= array[mid]){
                //目标元素在有序区间内
                return binSearch(array, target, start, mid);
            }else {
                //继续在后半部分递归搜索
                return recursiveSearch(array, mid + 1, end, target);
            }
        }else if (array[mid] < array[start]){
            //后半部分有序
            if (target >= array[mid] && target <= array[end]){
                //目标元素在有序区间内
                return binSearch(array, target, mid, end);
            }else {
                //继续在前半部分递归搜索
                return recursiveSearch(array, start, mid - 1, target);
            }
        }else if (array[start] == target){
            //此时 mid = start，代表 start + 1 = end
            //如果target在数组中，也只能是下标start或end对应的元素
            //下标start对应的元素等于target
            return start;
        }else if (array[end] == target){
            //下标end对应的元素等于target
            return end;
        }else {
            //下标start和end对应的元素都不等于target
            return -1;
        }
    }

    private int binSearch(int[] array, int target, int start, int end){
        int mid;
        while (start <= end){
            mid = start + ((end - start) >> 1);
            if (array[mid] == target){
                return mid;
            }else if (target > array[mid]){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
