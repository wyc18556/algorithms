package leetcode.easy;

import java.util.Arrays;

/**
 * @author wyc1856
 * @date 2019/2/20 10:15
 * @description leetCode-查询后的偶数之和
 * @href https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries/
 **/
public class SumOfEvenNumbersAfterQueries {

    static int[] result;

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4};
        int[][] queries = new int[][]{{1,0},{-3,1},{-4,0},{2,3}};
        final int[] result = test(A, queries);
        System.out.println(Arrays.toString(result));

    }

    static boolean isEven(int i){
        return i % 2 == 0;
    }


    static int[] test(int[] A, int[][] queries){

        result = new int[queries.length];
        int sum = 0;

        //首先计算出原始数组偶数之和
        for (int i = 0; i < A.length; i++){
            if (isEven(A[i])){
                sum += A[i];
            }
        }

        //循环查询数组
        for (int i = 0; i < queries.length; i++){
            int val = queries[i][0];
            int index = queries[i][1];
            if (isEven(A[index])){
                if (isEven(val)){
                    //偶偶
                    sum += val;
                }else {
                    //偶奇
                    sum -= A[index];
                }

            }else {
                if (!isEven(val)){
                    //奇奇
                    sum = sum + A[index] + val;
                }
            }
            //更新原始数组
            A[index] = A[index] + val;
            result[i] = sum;
        }
        return result;
    }
}
