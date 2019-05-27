package bittech.test;

import java.util.*;

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        if(queue1.isEmpty()&&queue2.isEmpty()){
            throw new RuntimeException("队列为空！");
        }else if(queue2.isEmpty()){
            while(!queue1.isEmpty()){
                queue2.add(queue1.poll());
            }
        }
        return queue2.poll();
    }

    public int top() {
        if(queue2.isEmpty()){
            while(!queue1.isEmpty()){
                queue2.add(queue1.poll());
            }
        }
        return queue2.peek();
    }

    public boolean empty() {
        if(queue1.isEmpty()&&queue2.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}

public class StackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.top());
        myStack.push(5);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
