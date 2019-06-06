package com.bittech.test;

import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Main1 main1 = new Main1();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(main1.addAB(a,b));
        }
    }
    public int addAB(int A,int B){
        int s = A^B;
        int b = (A&B)<<1;
        if(b!=0){
            return addAB(s,b);
        }else{
            return s;
        }
    }
}
