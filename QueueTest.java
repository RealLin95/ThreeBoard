package bittech.test;

public class QueueTest {
    public static void main(String[] args) {
        //Queue<Integer> queue = new LinkedQueue<>();
        Queue<Integer> queue = new ArrayQueue<>(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println(queue.peek());
        System.out.println(queue.deQueue());
        System.out.println(queue.getSize());
        System.out.println(queue.peek());
    }
}
