package other;

/**
 * @author wyc1856
 * @date 2019/11/27
 * @description 二分查找
 */
public class BinSearch {

    public static void main(String[] args) {
        BinSearch solution = new BinSearch();
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(solution.binSearch1(array, 8));
        System.out.println(solution.binSearch2(array, 3));
    }

    /**
     * 循环方式实现
     */
    private int binSearch1(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        int mid;
        //注意1：循环结束条件是start <= end 不是 start < end。
        while (start <= end){
            //注意2：当start和end较大时，相加的和会溢出，所以不要采用 mid = (start + end) >> 1的方式求中间节点。
            mid = start + ((end - start) >> 1);
            if (array[mid] == target){
                return mid;
            }else if (array[mid] < target){
                //注意3：当a再右半区间时，下一个开始节点是mid + 1，不是mid，如果区mid可能导致死循环。
                start = mid + 1;
            }else {
                //同注意3
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归方式实现
     */
    private int binSearch2(int[] array, int target){
        return recursiveBinSearch(array, target, 0, array.length - 1);
    }

    private int recursiveBinSearch(int[] array, int target, int start, int end){
        if (start > end){
            return -1;
        }
        int mid = start + ((end - start) >> 1);
        if (array[mid] == target){
            return mid;
        }else if (array[mid] < target){
            return recursiveBinSearch(array, target, mid + 1, end);
        }else {
            return recursiveBinSearch(array, target, start, end -1);
        }
    }
}
