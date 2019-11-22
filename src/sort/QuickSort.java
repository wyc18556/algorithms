package sort;

import java.util.Arrays;

/**
 * @author wyc1856
 * @date 2019/11/21
 * @description 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] array = new int[]{3,2,7,1,8,4,6,5};
        solution.quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    private void quickSort(int[] array){
        sort(array, 0, array.length -1);
    }

    private void sort(int[] array, int begin, int end){
        if (begin >= end){
            return;
        }
        int partition = partition(array, begin, end);
        sort(array, begin, partition -1);
        sort(array, partition + 1, end);
    }

    private int partition(int[] array, int begin, int end){
        int temp;
        int i = begin, j = begin;
        for (; j < end; j++){
            if (array[j] < array[end]) {
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
