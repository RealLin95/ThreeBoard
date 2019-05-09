package bittech;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"GG");
        //当key值重复，再次put变为相应value的更新操作
        map.put(3,"王五");
        System.out.println(map.get(99));
        //取得所有的key值
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()){
            System.out.println(keyIterator.next());
        }
        System.out.println("----------------------------------");
        for(Integer i:keySet){
            System.out.println(map.get(i));
        }
        //输出Map集合
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
