package bittech.test;

import java.util.Scanner;

public class MoreTest {
    public static int number(int[] arr){
        int count = 0;
        int max = 1;
        int number = 0;
        for(int i = 0;i<arr.length;i++){
            number = arr[i];
            for(int j = 1;j<arr.length;j++){
                if(number==arr[j]){
                    count++;
                    continue;
                }
            }
            if(count>max&&count>=(arr.length)/2){
                max = count;
                number = arr[i];
            }
        }
        return number;
    }

    public static int number1(int[] arr){
        int count = 0;
        int number = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(arr[i]==number){
                count++;
            }else if(count>0){
                //count>0 && arr[i]!=number
                count--;
            }else{
                //count<0 --> 当前arr[i]的次数大于上一个arr[i]的次数
                number = arr[i];
            }
        }
        return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            String[] s = str.split(" ");
            int[] arr = new int[s.length];
            for(int i = 0;i<arr.length;i++){
                arr[i] = Integer.valueOf(s[i]);
            }
            System.out.println(number(arr));
        }
    }
}
