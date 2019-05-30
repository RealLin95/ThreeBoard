package bittech.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteNumberTest {
    public static int delete(int n){
        List<Integer> list = new ArrayList<>();
        int index = 0;
        if(n>1000){
            return 999;
        }
        for(int i = 0;i<n;i++){
            list.add(i);
        }
        while(list.size()>1){
            index = (index+2)%list.size();
            list.remove(index);
        }
        return list.get(0);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(delete(n));
        }
    }
}
