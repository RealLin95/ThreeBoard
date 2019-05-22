package bittech.test;

public class ArrayQueue<E> implements Queue<E> {
    private Object[] elementData;
    private int maxSize;
    private int head;
    private int tail;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        elementData = new Object[maxSize];
    }

    @Override
    public void enQueue(E e) {
        if(tail==elementData.length){
            if(head==0){
                //队列已满
                System.out.println("队列已满");
            }else{
                for(int i = head;i<tail;i++){
                    elementData[i-head] = elementData[i];
                }
                //重新赋值头尾指针
                tail = tail-head;
                head = 0;
            }
        }else{
            elementData[tail++] = e;
        }
    }

    @Override
    public E deQueue() {
        if(isEmpty()){
            return null;
        }else{
            return (E) elementData[head++];
        }
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }else{
            return (E) elementData[head];
        }
    }

    @Override
    public int getSize() {
        return tail-head;
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }
}
