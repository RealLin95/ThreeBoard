package bittech.test;
import java.util.Scanner;

//最小公倍数
public class MaxCountTest{
    public static int minCount(int m,int n){
        return (m*n)/maxCount(m,n);
    }
    public static int maxCount(int m,int n){
        if(m%n==0){
            return n;
        }else{
            return maxCount(n,m%n);
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(minCount(m,n));
        }
    }
}
