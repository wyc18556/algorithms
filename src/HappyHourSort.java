import java.util.Arrays;

/**
 * 快乐小时排序，又叫鸡尾酒排序，是对冒泡排序的扩展。
 * 当序列中有序段较长时，能提高排序效率。
 */
public class HappyHourSort {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,5,6,7,8,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array){
        int tmp = 0;
        int leftSortBorder = 0;
        int rightSortBorder = array.length - 1;
        int leftLastChangeIndex = 0;
        int rightLastChangeIndex = 0;
        for (int i = 0; i < array.length / 2; i++){

            //初始化有序标识
            boolean isSorted = true;
            for (int j = leftSortBorder; j < rightSortBorder; j++){
                if (array[j] > array[j + 1]){
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //有元素交换，当前序列无序，修改标识
                    isSorted = false;
                    //记录右边最后一次更新的index
                    rightLastChangeIndex = j;
                }
            }
            //更新无序序列右边界
            rightSortBorder = rightLastChangeIndex;
            if (isSorted) break;

            //重新初始化标识
            isSorted = true;
            for (int j = rightSortBorder; j > leftSortBorder; j--){
                if (array[j] < array[j - 1]){
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    //有元素交换，当前序列无序，修改标识
                    isSorted = false;
                    //记录边最后一次更新的index
                    leftLastChangeIndex = j;
                }
            }
            //更新无序序列左边界
            leftSortBorder = leftLastChangeIndex;
            if (isSorted) break;
        }
    }
}
