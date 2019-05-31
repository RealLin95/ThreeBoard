package bittech.test;
import  java.util.Scanner;

public class zeroTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(count(n));
        }
    }
    public static int count(int n){
        int count = 0;
        while(n>=5){
            count += n/5;
            n /=5;
        }
        return count;
    }
}
