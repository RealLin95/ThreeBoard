package bittech.test;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if(queue1.isEmpty()){
            queue2.add(x);
        }else{
            queue1.add(x);
        }
    }

    public int pop() {
        if(queue1.isEmpty()&&queue2.isEmpty()){
            System.out.println("栈为空");
            return -1;
        }
        if(queue1.isEmpty()){
            int n = queue2.size();
            for(int i = 0;i<n-1;i++){
                queue1.add(queue2.poll());
            }
            int result = queue2.poll();
            return result;
        }else {
            int n = queue1.size();
            for (int i = 0; i < n - 1; i++) {
                queue2.add(queue1.poll());
            }
            int result = queue1.poll();
            return result;
        }
    }

    public int top() {
        if(queue1.isEmpty()&&queue2.isEmpty()){
            System.out.println("栈为空！");
            return -1;
        }
        if(queue1.isEmpty()){
            int n = queue2.size();
            for(int i = 0;i<n-1;i++){
                queue1.add(queue2.poll());
            }
            int result = queue2.poll();
            queue1.add(result);
            return result;
        }else {
            int n = queue1.size();
            for (int i = 0; i < n - 1; i++) {
                queue2.add(queue1.poll());
            }
            int result = queue1.poll();
            queue2.add(result);
            return result;
        }
    }

    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}


public class MyStackTest {
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
        System.out.println(myStack.pop());
    }
}
