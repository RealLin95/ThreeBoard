package bittech;

public class SequenceLinkImpl implements Sequence {
    //虚拟头节点，不存储元素，专门作为头节点使用
    private Node dummyHead;
    private int size;

    public SequenceLinkImpl(){
        this.dummyHead = new Node(null,null);
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

    @Override
    public void add(Object data) {
        addLast(data);
    }

    @Override
    public boolean remove(int index) {
        rangCheck(index);
        Node prev = dummyHead;
        for(int i = 0;i<index;i++){
            prev = prev.next;
        }
        Node cur = node(index);
        prev.next = cur.next;
        cur.next = cur = null;
        size--;
        return true;
    }

    @Override
    public Object get(int index) {
        rangCheck(index);
        Node cur = node(index);
        return cur.data;
    }

    @Override
    public boolean contains(Object data) {//将数据以数组形式呈现并判断
        Object[] datas = toArray();
        Node node = dummyHead.next;
        if(data==null){
            for(int i = 0;i<datas.length;i++){
                if(datas[i]==null){
                    return true;
                }
            }
        }else{
            while(node!=null){
                if(data.equals(node.data)){
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public Object change(int index, Object newData) {
        rangCheck(index);
        //取得相应index的Node节点
        Node cur = node(index);
        Object oldData = cur.data;
        cur.data = newData;
        return oldData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(Node node = dummyHead.next;node!=null;){
            node.data = null;
            Node temp = node.next;//把当前节点保存的下一个节点的地址保存起来
            node.next = null;
            node = temp;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] data = new Object[size];
        int i = 0;
        for(Node node = dummyHead.next;node!=null;node = node.next){
            data[i++] = node.data;
        }
        return data;
    }
    //在任意位置插入元素
    public void add(int index,Object data){
        rangCheck(index);
        Node prev = dummyHead;
        for(int i = 0;i<index;i++){
            prev = prev.next;
        }
        Node newNode = new Node(data);
        newNode.next = prev.next;
        prev.next = newNode;
        //prev.next = new Node(data,prev.next);
        size++;
    }
    private void addFirst(Object data){
        add(0,data);
    }
    private void addLast(Object data){
        add(size,data);
    }
    private void rangCheck(int index){
        if(index<0||index>size){
            throw  new IndexOutOfBoundsException("索引非法!");
        }
    }
    private Node node(int index){
        Node cur = dummyHead.next;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        return cur;
    }
}