package bittech.test;
import java.util.Scanner;

public class Main4 {
    public static String Niko(int m){
        StringBuffer str = new StringBuffer();
        if(m==1){
            return "1";
        }
        int num = m*(m-1)-1;
        for(int i = 1;i<=m;i++){
            num += 2;
            str.append(num);
            if(i!=m){
                str.append("+");
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            System.out.println(Niko(m));
        }
    }
}
