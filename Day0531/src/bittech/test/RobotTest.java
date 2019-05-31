package bittech.test;

import java.util.Scanner;

public class RobotTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(waysCount(x,y));
        }
    }
    public static int waysCount(int x,int y){
        if(x==1||y==1){
            return 1;
        }else{
            return waysCount(x-1,y)+waysCount(x,y-1);
        }
    }
}
