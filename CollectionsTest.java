package bittech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class CollectionsTest {
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        Collections.addAll(list,"d","B","a","C","a","c","D");
        //将线程不安全集合包装为线程安全集合
        Collections.synchronizedList(list);
        //集合排序 --> B-C-D-a-a-c-d
        Collections.sort(list);
        //集合反转 --> d-c-a-a-D-C-B
        Collections.reverse(list);
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print("、");
        }*/
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9);
        //list.forEach(System.out::println);
        //要操作Stream流，先取得Stream对象
        Stream<Integer> stream = list.stream();
        //统计出集合中所有偶数的个数
        System.out.println(stream.filter(e -> e%2==0).count());
        System.out.println(stream.max(Integer::compareTo).get());
    }
}
