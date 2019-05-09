package bittech;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("bit");
        list.add("hello");
        list.add("java");*/

        /*取得ArrayList的迭代器
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());*/

        /*取得ArrayList的双向迭代器
        ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        System.out.println("---------------------------------------");
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }*/
        Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("java");
        vector.add("hello");
        vector.add("world");
        Enumeration<String> enumeration = vector.elements();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
        for(String str:vector){
            System.out.println(str);
        }
    }
}
