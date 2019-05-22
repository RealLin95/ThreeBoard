package bittech.test;

import java.util.Stack;

class SingleMinStack {
    private Stack<Integer> stack;

    public SingleMinStack() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        //空栈第一次push
        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else{
            int temp = stack.peek();
            stack.push(x);
            if(x<temp){
                stack.push(x);
            }else{
                stack.push(temp);
            }
        }
    }

    public void pop() {
        //每次弹出两次，两个空间看为一块
        stack.pop();
        stack.pop();
    }

    public int top() {
        int temp = stack.pop();
        int result = stack.peek();
        stack.push(temp);
        return result;
    }

    public int getMin() {
        return stack.peek();
    }
}

public class SingleMinStackTest {
    public static void main(String[] args) {
        SingleMinStack minStack = new SingleMinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
