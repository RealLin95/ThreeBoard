package bittech.test;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int[] AB = new int[2];
            AB[0] = scanner.nextInt();
            AB[1] = scanner.nextInt();
            AB[0] = AB[0]^AB[1];
            AB[1] = AB[0]^AB[1];
            AB[0] = AB[0]^AB[1];
            System.out.println(AB[0]);
            System.out.println(AB[1]);
        }
    }
}
