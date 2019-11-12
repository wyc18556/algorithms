package queue;

/**
 * @author wyc1856
 * @date 2019/11/12
 * @description 基于数组的普通队列实现
 */
public class ArrayQueue {

    private String[] items;
    private int capacity;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(String item){
        if (tail == capacity){
            if (head == 0){
                System.out.println("队列已满");
                return false;
            }
            //数组元素依次向前迁移head位
            for (int i = head; i < tail; i++){
                items[i - head] = items[i];
            }
            tail = tail - head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue(){
        if (head == tail){
            System.out.println("队列为空");
            return null;
        }
        return items[head++];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        String item1 = queue.dequeue();
        System.out.println("空队列出队元素:" + item1);

        //入队
        for (int i = 0; i < 6; i++){
            if (queue.enqueue(String.valueOf(i))) {
                System.out.println(String.format("元素%s入队成功", i));
            }else {
                System.out.println(String.format("元素%s入队失败", i));
            }
        }

        //队满后出队
        for (int i = 0; i < 3; i++){
            String item = queue.dequeue();
            System.out.println(String.format("第%d位元素%s出队", i + 1, item));
        }

        //出队后重新入队
        boolean enqueue = queue.enqueue("100");
        System.out.println("出队后重新入队" + (enqueue ? "成功" : "失败"));
    }
}
