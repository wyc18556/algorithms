package sort;

import java.util.Arrays;

/**
 * @author wyc1856
 * @date 2019/11/26
 * @description 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        ShellSort solution = new ShellSort();
        int[] array = new int[]{3,5,7,1,8,4,6,2};
        solution.shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    private void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }
}
