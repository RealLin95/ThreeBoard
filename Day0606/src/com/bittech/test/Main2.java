package com.bittech.test;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            if(n==0){
                return;
            }
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scanner.nextInt();
            }
            int score = scanner.nextInt();
            System.out.println(count(arr,score));
        }
    }
    public static int count(int[] a,int s){
        int num = 0;
        for(int i = 0;i<a.length;i++){
            if(a[i]==s){
                num++;
            }
        }
        return num;
    }
}
