package bittech;

import java.util.Arrays;

public class SequenceArrayImpl implements Sequence {
    private Object[] elementData;  //定义一个数组接受数据（真正存放元素的数组）
    private final static int DEFAULT_CAPACITY = 10;  //初始化容量（默认容量）
    private int size;  //定义数组大小（存放的元素个数）
    private final static int MAX_CAPACITY = Integer.MAX_VALUE-1; //线性表的最大容量
    public SequenceArrayImpl(){
        this.elementData = new Object[DEFAULT_CAPACITY]; //默认初始化对象数组
    }
    public SequenceArrayImpl(int capacity){
        if(capacity>0){
        this.elementData = new Object[capacity];
        }
    }
    public void add(Object data){
        //1.判断是否越界
        ensureCapacityInternal(size+1);
        //2.越界扩容
        //3.添加元素
        elementData[size++] = data;
    }
    public boolean remove(int index){
        rangeIndex(index);
        int move = size-1-index;
        if(move>0){  //移除的不是最后一个元素
            System.arraycopy(elementData,index+1,elementData,index,move);
        }
        elementData[--size] = null;
        return true;
    }
    public Object get(int index){
        rangeIndex(index);
        return elementData[index];

    }
    public boolean contains(Object data){
        //判断是否为空
        if(data == null){
            for(int i = 0;i<elementData.length;i++) {
                if (elementData[i] == null) {
                    return true;
                }
            }
        }else{
            for(int i = 0;i<elementData.length;i++) {
                if (data.equals(elementData[i])) {  //避免空指针异常
                    return true;
                }
            }
        }
        return false;
    }
    public Object change(int index,Object newData){  //修改元素
        rangeIndex(index);
        Object oldData = elementData[index];
        elementData[index] = newData;
        return oldData;
    }
    public int size(){
        return this.size;
    }
    public void clear() {  //遍历为null，size变为0
        for(int i = 0;i<elementData.length;i++){
            elementData[i] = null;
        }
        this.size = 0;
    }
    public Object[] toArray(){  //直接返回对象数组
        return elementData;
    }
    private void ensureCapacityInternal(int cap){  //判断是否越界
        if(cap - elementData.length>0){
            grow(cap);  //进行扩容
        }
    }
    private void grow(int cap){
        int oldCap = elementData.length;
        int newCap = oldCap<<1;  //变为原来的2倍
        if(newCap - cap <0){  //扩大两倍还是不够
            newCap = cap;
        }else if(newCap - MAX_CAPACITY>0){
            throw new ArrayIndexOutOfBoundsException("线性表超出最大值");
        }
        //进行扩容
        elementData = Arrays.copyOf(elementData,newCap);
    }
    private void rangeIndex(int index){
        if(index<0||index>size-1){
            throw new ArrayIndexOutOfBoundsException("索引错误！");
        }
    }
}
