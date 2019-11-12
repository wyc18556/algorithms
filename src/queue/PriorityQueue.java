package queue;

/**
 * @author wyc1856
 * @date 2019/11/12
 * @description 基于数组的优先队列实现（使用堆来实现会更好）
 */
public class PriorityQueue {

    private Integer[] items;
    private int capacity;
    private int head;
    private int tail;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.items = new Integer[capacity];
    }

    public boolean enqueue(Integer item){
        if (tail == 0){
            //队列为空
            items[tail++] = item;
            return true;
        }
        if (tail == capacity){
            if (head == 0){
                //队列已满，丢弃队尾优先级最低的元素
                items[--tail] = null;
            }else {
                //队列未满，依次向前迁移head位
                for (int i = 0; i < tail - head; i++){
                    items[i] = items[head + i];
                }
                tail = tail - head;
                head = 0;
            }
        }
        int j;
        for (j = tail - 1; j >= 0; j--){
            //比入队元素大的数往后排
            if (item < items[j]){
                items[j+1] = items[j];
            }else {
                //找到比入队元素小的数据则结束循环
                break;
            }
        }
        items[j+1] = item;
        tail++;
        return true;
    }

    public Integer dequeue(){
        if (head == tail){
            return null;
        }
        return items[head++];
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(4);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(4);
        for (int i = 0; i < 2; i++){
            System.out.println(queue.dequeue());
        }

        queue.enqueue(8);
        queue.enqueue(6);
        System.out.println(queue.head + "_" + queue.tail);
    }
}
