package sort;

import java.util.Arrays;

/**
 * @author wyc1856
 * @date 2020/1/2
 * @description 堆排序
 * 堆顶元素在下标0处，下标为i的节点的父节点下标为(i - 1)/2，左子节点下标为2i + 1，右子节点下标为2i + 2。
 * 堆顶元素在下标1处，下标为i的节点的父节点下标为i/2，左子节点下标为2i，右子节点下标为2i + 1。
 **/
public class HeapSort {

    public static void main(String[] args) {
        HeapSort solution = new HeapSort();
        int[] array = new int[]{3,2,7,1,8,4,6,5};
        solution.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array){
        buildHeap(array, array.length);
        int k = array.length - 1;
        while (k > 0){
            int tmp = array[k];
            array[k] = array[0];
            array[0]= tmp;
            heapify(array, --k,0);
        }
    }

    /**
     * 建堆
     *
     * @param array
     * @param n
     */
    private void buildHeap(int[] array, int n){
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(array, n - 1, i);
        }
    }

    /**
     * 从上往下进行堆化
     *
     * @param array
     * @param n
     * @param i
     */
    private void heapify(int [] array, int n, int i){
        while (true){
            int maxPos = i;
            if (2 * i + 1 <= n && array[2 * i + 1] > array[maxPos]){
                maxPos = 2 * i + 1;
            }
            if (2 * i + 2 <= n && array[2 * i + 2] > array[maxPos]){
                maxPos = 2 * i + 2;
            }
            if (maxPos == i){
                break;
            }
            int tmp = array[maxPos];
            array[maxPos] = array[i];
            array[i] = tmp;
            i = maxPos;
        }
    }
}
