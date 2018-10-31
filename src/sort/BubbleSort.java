package sort;

import java.util.Arrays;

/**
 * 优化后的冒泡排序
 * 1.添加有序标识，如果已经有序则直接跳出排序。
 * 2.记录无序边界，减少不必要的比较。
 */
public class BubbleSort {

    //此次提交是为了进行git测试，和项目无关。

    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    //在test分支提交,测试master分支的修改会不会服务。

    private static void sort(int[] params){
        int tmp = 0;
        //无序序列边界
        int sortBorder = params.length - 1;
        //最后一次交换的位置
        int lastChangedIndex = 0;
        for (int i = 0; i < params.length; i++){
            //有序标识，每一轮的初始是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++){
                if (params[j] > params[j + 1]){
                    tmp = params[j];
                    params[j] = params[j + 1];
                    params[j + 1] = tmp;
                    //有元素交换，所以不是有序
                    isSorted = false;
                    //记录无序序列边界
                    lastChangedIndex = j;
                }
            }
            sortBorder = lastChangedIndex;
            if (isSorted){
                break;
            }
        }
    }
}
