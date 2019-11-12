package queue;

/**
 * @author wyc1856
 * @date 2019/11/12
 * @description 基于数组的环形队列实现，相比于一般队列无需迁移数据，但是最多只能存储capacity-1个元素
 */
public class CycleQueue {

    private String[] items;
    private int capacity;
    private int head;
    private int tail;

    public CycleQueue(int capacity) {
        this.capacity = capacity;
        this.items = new String[capacity];
    }

    public boolean enqueue(String item){
        //由于是环形队列，下一个为
        int next = (tail + 1) % capacity;
        if (next == head){
            System.out.println("队列已满");
            return false;
        }
        items[tail] = item;
        tail = next;
        return true;
    }

    public String dequeue(){
        if (head == tail){
            System.out.println("队列为空");
            return null;
        }
        String result = items[head];
        head = (head + 1) % capacity;
        return result;
    }

    public static void main(String[] args) {
        CycleQueue queue = new CycleQueue(5);
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
