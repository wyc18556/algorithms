package other;

import java.math.BigInteger;
import java.time.Instant;

/**
 * @author wyc1856
 * @date 2019/1/18 9:29
 * @description compute tow big int sum
 **/
public class SumBigInt {
    private static final int EACH_SIZE = 9;
    private static final String BIG_ONE = "78934579252952465345356768666744535246467893457925295246534535676866674453524646356345221234";
    private static final String BIG_TWO = "2143267481225353678865750456043778934579252952465345356768666744535246462314354351134";

    public static void main(String[] args) {
        final long l1 = Instant.now().toEpochMilli();
        System.out.println(sum(BIG_ONE, BIG_TWO));
        final long l2 = Instant.now().toEpochMilli();
        System.out.println("spend:" + (l2 - l1));

        final long l3 = Instant.now().toEpochMilli();
        final BigInteger bigOne = new BigInteger(BIG_ONE);
        final BigInteger bigTwo = new BigInteger(BIG_TWO);
        System.out.println(bigOne.add(bigTwo));
        final long l4 = Instant.now().toEpochMilli();
        System.out.println("spend:" + (l4 - l3));
    }

    private static String sum(String bigOne, String bigTwo){
        //大于此数需进位1
        int carryBit = carryBit(10, EACH_SIZE);
        //小于此数需补0
        int degradeBit = carryBit(10, EACH_SIZE - 1);
        //计算大整数拆分至目标数组长度
        int maxOne = bigOne.length() / EACH_SIZE + 1;
        int maxTwo = bigTwo.length() / EACH_SIZE + 1;
        int maxResult = maxOne > maxTwo ? maxOne + 1 : maxTwo + 1;
        //初始化大整数数组
        int[] arrayOne = new int[maxResult];
        int[] arrayTwo = new int[maxResult];
        int[] arrayResult = new int[maxResult];
        //大整数（倒序）拆分至目标数组
        cutToArray(arrayOne, maxOne, bigOne);
        cutToArray(arrayTwo, maxTwo, bigTwo);
        //计算结果目标数组
        for (int i = 0; i < maxResult; i++) {
            int tmp = arrayResult[i];
            tmp += arrayOne[i];
            tmp += arrayTwo[i];
            if (tmp >= carryBit){
                tmp = tmp - carryBit;
                arrayResult[i + 1] = 1;
            }
            arrayResult[i] = tmp;
        }
        //结果数组倒序拼装
        StringBuilder sb = new StringBuilder();
        //是否找到结果数组最高有效位
        boolean findFirst = false;
        for (int i = maxResult - 1; i >= 0; i--) {
            if (!findFirst){
                //找到最高有效位，拼接，并标记为找到
                if (arrayResult[i] != 0){
                    findFirst = true;
                    sb.append(arrayResult[i]);
                }
                continue;
            }
            //元素长度 < EACH_SIZE 则补零
            if (arrayResult[i] < degradeBit){
                String str = String.valueOf(arrayResult[i]);
                int lessSize = EACH_SIZE - str.length();
                for (int j = 0; j < lessSize; j++) {
                    sb.append("0");
                }
            }
            sb.append(arrayResult[i]);
        }
        return sb.toString();
    }

    /**
     * 计算m的n次幂
     *
     * @param m
     * @param n
     * @return
     */
    private static int carryBit(int m, int n){
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= m;
        }
        return result;
    }

    /**
     * 大整数拆分
     *
     * @param array
     * @param max
     * @param num
     */
    private static void cutToArray(int[] array, int max, String num){
        for (int i = 0; i < max; i++) {
            if (i == max - 1){
                if (num.length() != EACH_SIZE * i){
                    array[i] = Integer.valueOf(num.substring(0, num.length() - EACH_SIZE * i));
                }
            }else {
                array[i] = Integer.valueOf(num.substring(num.length() - EACH_SIZE * (i + 1), num.length() - EACH_SIZE * i));
            }
        }
    }
}
