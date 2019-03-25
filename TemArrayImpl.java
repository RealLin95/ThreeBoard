package bittech3;

import java.util.Arrays;

public class TemArrayImpl<T> implements TemSequence<T> {

    private Object[] elementData;
    private final static int CAPACITY = 10;
    private int size = 0;
    private final static int MAX = Integer.MAX_VALUE-1;
    public TemArrayImpl(){
        this.elementData = new Object[CAPACITY];//java不支持泛型数组
    }
    public TemArrayImpl(int capacity){
        if(capacity>0){
            this.elementData = new Object[capacity];
        }else{
            throw new IndexOutOfBoundsException("不支持的数组大小！");
        }
    }

    @Override
    public void add(T data) {
        //1.判断是否越界
        ensureCapacityGoOut(size+1);
        //2.动态扩容
        //3.添加元素
        elementData[size++] = data;
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        int move = size-1-index;
        if(move!=0){
            System.arraycopy(elementData,index+1,elementData,index,move);
        }
        elementData[--size] = null;
        return true;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        T t = (T)elementData[index];
        return t;
    }

    @Override
    public boolean contains(T data) {
        if(data==null){
            for(int i = 0;i<size;i++){
                if(elementData[i]==null){
                    return true;
                }
            }
        }else{
            for(int i=0;i<size;i++){
                if(data.equals(elementData[i])){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public T set(int index, T data) {
        checkIndex(index);
        T oldData = (T)elementData[index];
        elementData[index] = data;
        return oldData;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        for(int i = 0;i<size;i++){
            elementData[i] = null;
        }
        size=0;
    }

    @Override
    public Object[] toArray() {
        return elementData;
    }

    private void ensureCapacityGoOut(int length){
        if(length>elementData.length){
            grow(length);
        }
    }
    private void grow(int length){
        int oldLength = elementData.length;
        int newLength = oldLength<<1;
        if(newLength<length){
            length = newLength;
        }else if(length>MAX){
            throw new ArrayIndexOutOfBoundsException("线性表超出最大值！");
        }
        elementData = Arrays.copyOf(elementData,newLength);
    }
    private void checkIndex(int index){
        if(index<0||index>=MAX){
            throw new ArrayIndexOutOfBoundsException("索引异常！");
        }
    }

}
