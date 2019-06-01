package bittech.test;

import java.util.Scanner;
public class NumberTest {
    public static void count(String n){
        for(int i = 0; i<10; i++){
            int count = 0;
            String s = String.valueOf(i);
            for(int j = 0;j<n.length();j++){
                if(s.equals(String.valueOf(n.charAt(j)))){
                    count++;
                }
            }
            if(count>0){
                System.out.print(i+":"+count+" ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String n = scanner.nextLine();
            count(n);
        }
    }
}
