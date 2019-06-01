package bittech.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

public class Test {
    public static void main(String[] args) {
//        java.util.HashMap map = new java.util.HashMap();
//        map.put("name",null);
//        map.put("name","jack");
//        System.out.println(map.size());
//        Thread t = new Thread(){
//            public void run(){
//                pong();
//            }
//        };
//        t.run();
//        System.out.println("ping");
//        String str1 = "hello";
//        String str2 = "he"+new String("llo");
//        System.out.println(str1==str2);
        Test test  = new Test();
        byte a = 127;
        byte b = 127;
        test.add(++a);
        System.out.println(a);
        test.add(b);
        System.out.println(b);
    }
    public void add(byte a){
        a = a++;
    }
    public static void pong(){
        System.out.println("pong");
    }
}
