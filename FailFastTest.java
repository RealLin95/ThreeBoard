package bittech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FailFastTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"hello","java","hello","world");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            //调用next()之前先调用checkForComodification()判断当前集合是否被修改
            String str = iterator.next();
            if(str.equals("hello")){
                //list.remove("hello");//抛出异常ConcurrentModificationException
                iterator.remove();
                continue;
            }
            System.out.println(str);
        }
    }
}
