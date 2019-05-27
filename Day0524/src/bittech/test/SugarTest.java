package bittech.test;

import java.util.Scanner;

public class SugarTest {
    public static String sugerNumber(int arr[]){
        float a,b,c;
        a = (arr[0]+arr[2])/2F;
        b = (arr[1]+arr[3])/2F;
        c = b-arr[1];
        if(a>0&&b>0&&c>0){
            if((a-b)==arr[0]&&(b-c)==arr[1]&&(a+b)==arr[2]&&(b+c)==arr[3]){
                return (int)a+" "+(int)b+" "+(int)c;
            }else{
                return "No";
            }
        }else{
            return "No";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int arr[] = new int[4];
            for(int i = 0;i<4;i++){
                arr[i] = scanner.nextInt();
            }
            System.out.println(sugerNumber(arr));
        }
        //1 -2 3 4 --> 2 1 3
    }
}
