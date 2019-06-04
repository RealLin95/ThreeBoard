package bittech.test;
import java.util.Scanner;

public class Main {
    public static void print(int n,char c){
        int row = (int) Math.round(n/2.0);
        for(int i = 1;i<=row;i++){
            if(i==1||i==row){
                for(int j = 0;j<n;j++){
                    System.out.print(c);
                }
            }else{
                System.out.print(c);
                for(int j = 0;j<n-2;j++){
                    System.out.print(" ");
                }
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            char c = scanner.next().charAt(0);
            print(n,c);
        }
    }
}
