package bittech;

public interface Sequence {
    //添加元素
    void add(Object data);
    //删除元素
    boolean remove(int index);
    //查找元素
    Object get(int index);
    //线性表中是否包含该元素
    boolean contains(Object data);
    //修改元素
    Object change(int index,Object newData);
    //返回当前线性表元素个数
    int size();
    //清空线性表
    void clear();
    //变成数组
    Object[] toArray();
}
