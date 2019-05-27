package bittech.test;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
//    String str = "good";
//    char[] ch = {'a','b','c'};
    public static void main(String[] args) throws InterruptedException {
//        int x,y;
//        x = 5>>2;
//        y= x>>>2;
//        System.out.println(x);
//        System.out.println(y);

//        StringBuffer str1 = new StringBuffer("A");
//        StringBuffer str2 = new StringBuffer("B");
//        fun(str1,str2);
//        System.out.println(str1+" "+str2);

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("2");
//            }
//        });
//        thread.start();
//        thread.join();
//        System.out.println("1");

//        Test test = new Test();
//        test.swap(test.str, test.ch);
//        System.out.println(test.str + "and");
//        System.out.println(test.ch);

//        Map<Integer,String> map = new HashMap<>();
//        map.put(null,null);
        int num = 10;
        System.out.println(temp(num));

    }
    public static int temp(int b){
        try{
            b+=10;
            return b;
        }catch(Exception e){

        }finally {
            b+=10;
            return b;
        }
    }

    public void swap(String str,char[] ch){
        str = "test ok";
        ch[0] = 'g';
    }

//    public static void fun(StringBuffer str1,StringBuffer str2){
//        str1.append(str2);
//        str2 = str1;
//    }

}
