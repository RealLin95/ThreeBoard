package bittech.test;

import java.util.Scanner;

public class zeroNumberTest {
    public static int zeroNumber(int n){
        long result = number(n);
        String str = String.valueOf(result);
        int l = str.length()-1;
        int count = 0;
        if(str.charAt(l)!='0'){
            return 0;
        }
        while(str.charAt(l)=='0'&&(l>0)){
            count++;
            l--;
        }
        return count;
    }
    private static long number(int n){
        if(n==1){
            return 1L;
        }else{
            return n*number(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            if(n>0&&n<1001){
                System.out.println(zeroNumber(n));
            }
        }
    }
}
