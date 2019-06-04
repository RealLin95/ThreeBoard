package bittech.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Test0604 {
    public static void main(String[] args) {
        String a = "abc"+"def";
        String b = new String(a);
        if(a.equals(b)){
            System.out.println("atrue");
        }
        if(a==b){
            System.out.println("btrue");
        }
    }
}
