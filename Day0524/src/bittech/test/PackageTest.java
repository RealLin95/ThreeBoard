package bittech.test;

import java.util.Scanner;

//神奇的袋子
public class PackageTest {
    public static int method(int arr[],int n,int s){
        //arr存放总的重量以及每个物品的重量
        //n为物品总数量
        //s为当前剩余容量
        if(s==0){
            return 1;
        }else if(n==1){
            if(arr[n]==s){
                return 1;
            }else{
                return 0;
            }
        }else if(s<arr[n]){
            return method(arr,n-1,s);
        }else{
            return method(arr,n-1,s-arr[n])+method(arr,n-1,s);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int arr[] = new int[n+1];
            arr[0] = 40;
            for(int i = 1;i<=n;i++){
                arr[i] = scanner.nextInt();
            }
            System.out.println(method(arr,n,arr[0]));
        }
    }
}
