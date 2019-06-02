package bittech.test;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main2 {
    public static String[] grayNum(int n){
        if(n==1){
            String[] temp = new String[2];
            temp[0] = "0";
            temp[1] = "1";
            return temp;
        }else{
            String[] add = grayNum(n-1);
            int len = (int) pow(2,n);
            String[] num = new String[len];
            for(int i = 0;i<len/2;i++){
                num[i] = "0"+add[i];
            }
            for(int j = len/2;j<len;j++){
                num[j] = "1"+add[len-j-1];
            }
            return num;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            String[] num = grayNum(n);
            for(String i:num){
                System.out.println(i);
            }
        }
    }
}
