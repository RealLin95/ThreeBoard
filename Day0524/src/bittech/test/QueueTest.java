package bittech.test;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() throws Exception {
        if(stack1.isEmpty()&&stack2.isEmpty()){
            throw new Exception("空栈异常！");
        }else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek1() throws Exception {
        if(stack1.isEmpty()){
            if(stack2.isEmpty()){
                throw new Exception("空栈异常！");
            }else{
                return stack2.peek();
            }
        }else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }else{
            Stack<Integer> temp = new Stack<>();
            while(!stack1.isEmpty()){
                temp.push(stack1.pop());
            }
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            while(!temp.isEmpty()){
                stack1.push(temp.pop());
            }
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }
    public int peek(){
        if(stack2.empty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        if(stack1.isEmpty()&&stack2.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}

public class QueueTest{
    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.peek());
        myQueue.push(5);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}