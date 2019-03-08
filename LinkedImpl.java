package bittech;

public class LinkedImpl {
    private Node head;
    private int size;
    private Node dummyHead;

    public LinkedImpl(){
    head = null;
    size = 0;
    }

    private class Node{
        Object data;
        Node next;

        public Node(Object data){
            this.data = data;
        }
        public Node(Object data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    //将节点头插进入火车(类比入栈出栈，先插入的后输出，每次都在第一个位置插入)
    public void addFirst(Object data){
//        Node newNode = new Node(data);//创建新节点
//        newNode.next = head;//将当前节点的指向原来火车的头节点
//        head = newNode;
        head = new Node(data,head);
        size++;
    }
    //在任意位置插入节点
    public void add(int index,Object data){
        rangeCheck(index);
        if(index==0){
            addFirst(data);
        }
        Node prev = head;
        for(int i = 0;i<index-1;i++){
            prev = prev.next;
        }
//        Node newNode = new Node(data);
//        newNode.next = prev.next;
//        prev.next = newNode;
        prev.next = new Node(data,prev.next);
        size++;
    }
    public void addLast(Object data){
        add(size,data);
        size++;
    }
    private void rangeCheck(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("索引异常！");
        }
    }
}