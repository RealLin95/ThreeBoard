package bittech.test;

import java.util.Scanner;

public class bottleTest {
    public static int bottle(int n){
        int total = n;
        int result = n/3;
        if(n<2){
            return 0;
        }
        while(total>2){
            total = total/3+total%3;
            result = result+total/3;
        }
        if(total==2){
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            if(n!=0){
                System.out.println(bottle(n));
            }
        }
    }
}
