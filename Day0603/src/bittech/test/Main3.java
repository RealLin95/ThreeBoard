package bittech.test;
import java.util.Scanner;
public class Main3 {
    public static String minNumber(int[] a) {
        StringBuffer str = new StringBuffer();
        for(int j = 1;j<a.length;j++){
            if(a[j]!=0){
                str.append(j);
                a[j] -= 1;
                break;
            }
        }
        for (int i = 0; i < a.length; i++) {
            int count = a[i];
            while(count!=0){
                str.append(i);
                count--;
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int[] a = new int[10];
            for(int i = 0;i<10;i++){
                a[i] = scanner.nextInt();
            }
            System.out.println(minNumber(a));
        }
    }
}
