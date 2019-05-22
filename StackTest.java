package com.bittech.test;

//简单实现栈

import java.util.Arrays;

interface Stack<T>{
    //入栈
    boolean push(T t);
    //出栈
    T pop();
    //返回栈顶元素，不出栈
    T peek();
    //当前栈的元素个数
    int size();
    //当前栈是否为空
    boolean isEmpty();
}

class ArrayStack<T> implements Stack<T>{
    //存放数据
    private Object[] elementData;
    //最多存放的元素个数
    private int maxSize;
    //当前栈中的元素个数
    private int currentSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        elementData = new Object[maxSize];
    }

    @Override
    public boolean push(T t) {
        if(currentSize==maxSize){
            //动态扩容
            int oldSize = maxSize;
            int newSize = oldSize<<1;
            if(newSize+8>Integer.MAX_VALUE){
                System.out.println("栈太大！");
                return false;
            }
            maxSize = newSize;
            elementData = Arrays.copyOf(elementData,maxSize);
        }
        elementData[currentSize++] = t;
        return true;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            return null;
        }
        return (T) elementData[--currentSize];
    }

    @Override
    public T peek() {
        if(isEmpty()){
            return null;
        }
        return (T) elementData[currentSize-1];
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize==0;
    }
}

class LinkedStack<T> implements Stack<T>{
    //定义节点
    private class Node{
        private T t;
        private Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }
    }
    //栈顶元素
    private Node top;
    private int currentSize;

    @Override
    public boolean push(T t) {
        //头插法
        //创建新节点
        Node newNode = new Node(t,null);
        if(top==null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        currentSize++;
        return true;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("当前栈为空");
            return null;
        }
        T result = top.t;
        top = top.next;
        currentSize--;
        //返回栈顶元素
        return result;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.out.println("当前栈为空");
            return null;
        }
        return top.t;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize==0;
    }
}

public class StackTest {
    public static void arrayTest(){
        Stack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
    }
    public static void linkedTest(){
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
    }
    public static void main(String[] args) {
        //顺序栈
        arrayTest();
        //链式栈
        //linkedTest();
    }
}
