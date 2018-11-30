package other;

/**
 * @Author wyc1856
 *
 * 回溯算法。
 * 题目：有一个二维矩阵，里面的数字代表高度，有一个小球随机落在一个位置，可以向数字比它小的位置滚过去，请写一个程序判断小球能否滚到矩阵的边缘。
 */
public class Recall {
    private static boolean onSide = false;
    private static boolean canBeFlow(int[] array, int x, int y, int column, int row){
        System.out.println("当前坐标（"+ x + "," + y +"）数值为" + array[column * x + y]);
        if (x == 0 || x == row - 1 || y == 0 || y == column - 1){
            onSide = true;
        }
        //能往上边滚
        if (!onSide && (array[column * x + y] > array[column * (x - 1) + y])){
            System.out.println("往上边滚");
            canBeFlow(array, x - 1, y, column, row);
        }
        //能往右边滚
        if (!onSide && (array[column * x + y] > array[column * x + (y + 1)])) {
            System.out.println("往右边滚");
            canBeFlow(array, x, y + 1, column, row);
        }
        //能往下边滚
        if (!onSide && (array[column * x + y] > array[column * (x + 1) + y])){
            System.out.println("往下边滚");
            canBeFlow(array, x + 1, y, column, row);
        }
        //能往左边滚
        if (!onSide && (array[column * x + y] > array[column * x + (y - 1)])){
            System.out.println("往左边滚");
            canBeFlow(array, x, y - 1, column, row);
        }
        return onSide;
    }

    public static void main(String[] args) {
        int[] array = {
                100, 100, 100, 100, 100, 100,
                100, 99, 100, 97, 100, 100,
                100, 98, 97, 100, 93, 100,
                100, 92, 96, 95, 94, 93,
                100, 100, 100, 100, 100, 100};
        int x = 1;
        int y = 1;
        int rows = 5;
        int cols = 6;
        boolean flag = canBeFlow(array, x, y, cols, rows);
        System.out.println(flag);
    }
}
