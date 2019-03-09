package bittech;

public class DoubleLinkImpl implements Sequence {

    private Node head;
    private Node tail;
    private  int size;

    private class Node{
        Node prev;
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

    }

    @Override
    public void add(Object data) {
        Node newNode = new Node(tail,data,null);//产生新节点尾插入链表中
        if(head==null){
            head = newNode;//链表中只有一个节点
        }else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    @Override
    public boolean remove(int index) {//分情况判断，先看左边！！！
        rangeIndex(index);
        Node cur = node(index);
        if(cur.prev==null){//要删除的是头节点
            head = cur.next;
        }else if(cur.next==null){//要删除的是尾节点
            tail = cur.prev;
        }else{//要删除的是中间节点
            Node prev = cur.prev;
            Node next = cur.next;
            prev.next = cur.next;
            next.prev = cur.prev;
        }
        size--;
        return false;
    }

    @Override
    public Object get(int index) {
        rangeIndex(index);
        return node(index).data;
    }

    @Override
    public boolean contains(Object data) {
        Object[] datas = toArray();
        if(data==null){
            for(int i = 0;i<size;i++){
                if(datas[i]==null){
                    return true;
                }
            }
        }else{
            for(Node node = head;node!=null;node = node.next){
                if(data.equals(node.data)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object change(int index, Object newData) {
        rangeIndex(index);
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
        for(Node node = head;node!=null;){
            Node temp = node.next;
            node.data = null;
            node.prev = node.next = null;
            node = temp;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] data = new Object[size];
        for(int i = 0;i<size;i++){
            data[i] = head.data;
            head = head.next;
        }
        return data;
    }

    private void rangeIndex(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("索引非法!");
        }
    }
    //取得对应索引的位置(优化！！！)
    private Node node(int index){
        if(index<(size>>1)) { // 除2
            Node temp = head;
            for(int i = 0;i<index;i++){
                temp = temp.next;
            }
            return temp;
        }else{
            Node temp = tail;
            for(int i = size-1;i>index;i--){
                temp = temp.prev;
            }
            return temp;
        }
    }
}
