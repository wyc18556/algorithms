package stack;

/**
 * @author wyc1856
 * @date 2019/11/13
 * @description 基于数组实现的顺序栈
 */
public class ArrayStack<T> {
    private static final int DEFAULT_CAPACITY = 5;

    private T[] items;
    private int size;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(Integer capacity) {
        items = (T[]) new Object[capacity];
    }

    private void resize(){
        T[] dummy = (T[]) new Object[size * 2];
        for (int i = 0; i < size; i++){
            dummy[i] = items[i];
        }
        items = dummy;
    }

    public void push(T item){
        if (size == items.length) {
            resize();
        }
        items[size++] = item;
    }

    public T pop(){
        if (size == 0){
            return null;
        }
        return items[--size];
    }

}
