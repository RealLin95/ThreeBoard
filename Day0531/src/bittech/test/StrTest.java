package bittech.test;

import java.util.Scanner;

public class StrTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            int n = scanner.nextInt();
            System.out.println(solveStr(str,n,scanner));
        }
    }
    public static String solveStr(String str,int n,Scanner scanner){
        for(int i = 0;i<n;i++){
            int p = scanner.nextInt();
            int l = scanner.nextInt();
            StringBuilder str1 = new StringBuilder(str);
            String sb = str1.substring(p,p+l);
            StringBuilder sb1 = (new StringBuilder(sb)).reverse();
            str1.insert(p+l,sb1);
            str = str1.toString();
        }
        return str;
    }
}
