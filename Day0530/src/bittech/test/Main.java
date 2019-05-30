package bittech.test;

import java.util.Scanner;

public class Main {
    //寻找n！的末尾0的个数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int res = 0;
            for(int i = n;i>=5;i--){
                int tmp = i;
                while(tmp%5==0){
                    res++;
                    tmp/=5;
                }
            }
            System.out.println(res);
        }
    }
}
