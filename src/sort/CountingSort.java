package sort;

import java.util.Arrays;

/**
 * @Author wyc1856
 * @Date 2018/10/25 14:11
 * @Description 计数排序（https://mp.weixin.qq.com/s/WGqndkwLlzyVOHOdGK7X4Q）
 *
 * 局限性：1.当数列最大最小值差距过大时，并不适用计数排序;2.当数列元素不是整数，并不适用计数排序;
 **/
public class CountingSort {

    public static void main(String[] args) {
        int[] array = new int[]{6,5,6,3,5,6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array){
        //1.得到数列最大值和最小值
        int max = array[0];
        int min = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            } else if (num < min) {
                min = num;
            }
        }
        //2.创建统计数组，长度为 max - min + 1 是为了保证统计数组下标与偏移量对应
        int[] countArray = new int[max - min + 1];
        //3.遍历原始数组，填充统计数组
        for (int num : array) {
            countArray[num - min]++;
        }
        //4.遍历统计数组，输出结果
        int index = 0;
        for (int i = 0; i < countArray.length; i++){
            while (countArray[i]-- > 0){
                array[index++] = i + min;
            }
        }
    }
}
