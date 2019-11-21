package sort;

import java.util.Arrays;

/**
 * @author wyc1856
 * @date 2019/11/21
 * @description 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8};
        sort(array);
        System.out.println(Arrays.toString(array));

    }

    private static void sort(int[] array){
        //将数组分为两部分，前一部分有序，后一部分无序。
        //刚开始前一部分就一个下标为0的元素，则后一部分重下标为1的元素开始，依次插入到前一部分中去。
        for (int i = 1; i < array.length; i++){
            int value = array[i];
            int j = i - 1;
            //当前值value依次与前一部分的元素进行比较
            for (; j >= 0; j--){
                //大于当前值的元素后移
                if (array[j] > value){
                    array[j + 1] = array[j];
                }else {
                    break;
                }
            }
            //插入当前值
            array[j + 1] = value;
        }
    }
}
