package bittech.test;

import java.util.Scanner;

public class FruitTest {

    public static int fruitNumber(int n){
        if(n%2!=0||n==0||n<6){
            return -1;
        }
        if(n%8==0){
            return n/8;
        }else{
            return n/8+1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int number = fruitNumber(n);
            System.out.println(number);
        }
    }
}
