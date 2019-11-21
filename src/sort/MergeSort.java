package sort;

import java.util.Arrays;

/**
 * @author wyc1856
 * @date 2019/11/21
 * @description 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort solution = new MergeSort();
        int[] array = new int[]{3,5,7,1,8,4,6,2};
        solution.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private void mergeSort(int[] array){
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int begin, int end){
        System.out.println(String.format("区间排序开始---区间左下标:%d---区间右下标:%d", begin, end));
        if (end - begin <= 1) {
            //区间元素个数小于等于2时，比较-交换
            if (array[begin] > array[end]){
                int tem = array[end];
                array[end] = array[begin];
                array[begin] = tem;
            }
        }else {
            //区间元素个数大于2，继续分治
            int mid = (begin + end) / 2;
            //递归分治的前半部分元素
            sort(array, begin, mid);
            //递归分治的前半部分元素
            sort(array, mid + 1, end);
            //合并分治的结果
            merge(array, begin, end);
        }
    }

    private void merge(int[] array, int begin, int end){
        System.out.println(String.format("区间合并开始---区间左下标:%d---区间右下标:%d", begin, end));
        int mid = (begin + end) / 2;
        //定义双指针，i用来遍历前半部分区间元素，j用来遍历后半部分区间元素
        int i = begin, j = mid + 1;
        //定义一个临时数组
        int[] ephemeralArray = new int[end - begin + 1];
        int k = 0;
        //双指针遍历前后两部分区间，比较元素大小，将合并结果存放在临时数组中
        while (i <= mid && j <= end){
            ephemeralArray[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        //后半部分区间先遍历结束，将前半部区间剩余元素追加在临时数组中
        while (i <= mid){
            ephemeralArray[k++] = array[i++];
        }
        //前半部分区间先遍历结束，将后半部区间剩余元素追加在临时数组中
        while (j <= end){
            ephemeralArray[k++] = array[j++];
        }
        //将临时数组元素拷贝至原数组中
        while (begin <= end){
            array[end--] = ephemeralArray[--k];
        }
    }
}
