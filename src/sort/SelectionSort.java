package sort;

import java.util.Arrays;

/**
 * @author wyc1856
 * @date 2019/11/21
 * @description 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array){
        int temp;
        int minIndex;
        //和插入排序类似，也是分为两部分，前部分有序，后部分无序。
        //每次循环找出无序数列中的最小值，与无序数列的第一个元素互换位置，然后将无序数列第一位作为有序数列的最后一位，继续下一轮循环。
        for (int i = 0; i < array.length - 1; i++){
            minIndex = i;
            for (int j = i + 1; j < array.length; j++){
                //记录无序数列最小值下标
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            //交换
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
