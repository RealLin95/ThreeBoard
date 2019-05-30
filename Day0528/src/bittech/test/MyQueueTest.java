package bittech.test;

class MyCircularQueue {
    private Object[] elementData;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        //为tail开辟一块不存储数据的空间
        this.elementData = new Object[k+1];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            System.out.println("队列已满！");
            return false;
        }else{
            elementData[tail] = value;
            tail = (tail+1)%elementData.length;
            size++;
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            System.out.println("队列为空！");
            return false;
        }else{
            int result = (int)elementData[head];
            head = (head+1)%elementData.length;
            size--;
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }else{
            int result = (int)elementData[head];
            return result;
        }
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }else{
            int index;
            if(tail==0){
                index = elementData.length-1;
            }else{
                index = tail-1;
            }
            int result = (int)elementData[index];
            return result;
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(head==tail){
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if((tail+1)%elementData.length==head){
            return true;
        }
        return false;
    }
}

public class MyQueueTest {
    public static void main(String[] args) {
        MyCircularQueue myQueue = new MyCircularQueue(3);
        System.out.println(myQueue.enQueue(1));
        System.out.println(myQueue.enQueue(2));
        System.out.println(myQueue.enQueue(3));
        System.out.println(myQueue.enQueue(4));
        System.out.println(myQueue.isFull());
        System.out.println(myQueue.Front());
        System.out.println(myQueue.Rear());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.deQueue());
    }
}
