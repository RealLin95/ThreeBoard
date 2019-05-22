package bittech.test;

public interface Queue<E> {
    //入队，队尾插入
    void enQueue(E e);
    //出队，队首元素
    E deQueue();
    //返回队首元素
    E peek();
    //队列长度
    int getSize();
    //判断是否为空
    boolean isEmpty();
}
