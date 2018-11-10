package sort;


import java.util.*;

/**
 * @Author wyc1856
 * @Date 2018/11/10 10:48
 * @Description 桶排序（https://mp.weixin.qq.com/s/qrboxA5SwN7AbAcpZ_dpNQ）
 * 类似于计数排序，也属于线性排序算法。常用来对小数数组进行排序。
 * 当桶内元素分布均匀时，时间复杂度低。但是当桶内元素分布极不均衡时，时间复杂度高。
 **/
public class BucketSort {

    public static void main(String[] args) {
        double[] array = new double[]{3.58,1.79,8.88,6.66,2.58,4.09,7.26,5.38};
        System.out.println(Arrays.toString(sort(array)));
    }

    private static double[] sort(double[] array){

        double max = array[0];
        double min = array[0];
        for (double d : array){
            if (d > max){
                max = d;
            }
            if (d < min){
                min = d;
            }
        }
        double scope = max - min;
        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++){
            bucketList.add(new LinkedList<>());
        }
        //将元素数组元素依次放入对应的桶内
        for (double d : array){
            int bucketOrder = (int) ((d - min)/scope) * (bucketNum - 1);
            bucketList.get(bucketOrder).add(d);
        }
        //桶内元素排序
        for (List<Double> bucket : bucketList){
            Collections.sort(bucket);
        }
        //输出排序后数据至新数组
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> bucket : bucketList) {
            for (Double d : bucket){
                sortedArray[index ++ ] = d;
            }
        }
        return sortedArray;
    }
}
