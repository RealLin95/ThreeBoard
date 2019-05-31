package bittech.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(steps(n));
        }
    }
    public static int steps(int n){
        int a = 0,b = 1,c = 1;
        while(c<n){
            a = b;
            b = c;
            c = a+b;
        }
        int step1 = c-n;
        int step2 = n-b;
        return step1>step2?step2:step1;
    }
}
