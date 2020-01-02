package other;

import java.util.Random;

/**
 * @author wyc1856
 * @date 2020/1/2
 **/
public class Heap {

    /**
     * 数组，从下标1开始存储数据
     */
    private int[] data;
    /**
     * 堆的容量
     */
    private int capacity;
    /**
     * 堆内已有元素数量
     */
    private int count;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity + 1];
        this.count = 0;
    }


    public static void main(String[] args) {
        Heap heap = new Heap(5);
        Random random = new Random();
        while (true) {
            int value = random.nextInt(10);
            if (!heap.insert(value)) {
                System.out.println(value + "入堆失败");
                break;
            } else {
                System.out.println(value + "入堆成功");
            }
        }
        System.out.println("删除堆顶元素");
        heap.removeHead();
        int last = 15;
        if (heap.insert(last)) {
            System.out.println(last + "入堆成功");
        } else {
            System.out.println(last + "入堆失败");
        }
    }

    /**
     * 插入新元素
     *
     * @param value
     * @return
     */
    public boolean insert(int value) {
        if (count == capacity) {
            System.out.println("堆已满，无法插入新元素");
            return false;
        }

        data[++count] = value;
        int i = count;
        while (i / 2 > 0 && data[i / 2] < data[i]) {
            int tmp = data[i];
            data[i] = data[i / 2];
            data[i / 2] = tmp;
            i = i / 2;
        }
        return true;
    }

    /**
     * 删除堆顶元素
     */
    public void removeHead() {
        if (count == 0) {
            return;
        }
        int i = 1;
        data[i] = data[count--];
        while (true) {
            int maxPos = i;
            if (2 * i <= capacity && data[2 * i] > data[maxPos]) {
                maxPos = 2 * i;
            }
            if (2 * i + 1 <= capacity && data[2 * i + 1] > data[maxPos]) {
                maxPos = 2 * i + 1;
            }
            if (maxPos == i) {
                break;
            }
            int tmp = data[i];
            data[i] = data[maxPos];
            data[maxPos] = tmp;
            i = maxPos;
        }
    }
}
