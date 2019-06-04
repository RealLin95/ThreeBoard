package bittech.test;
import java.util.Scanner;

public class Main2 {
    public String AddLongInteger(String addend,String augend){
        StringBuffer a = new StringBuffer(addend);
        a.reverse();
        StringBuffer b = new StringBuffer(augend);
        b.reverse();
        int len = a.length()>b.length()?a.length():b.length();
        int[] result = new int[len+1];
        StringBuffer str = new StringBuffer();
        int[] A = new int[len];
        int[] B = new int[len];
        for(int i = 0;i<len;i++){
            if(i<a.length()){
                A[i] = Integer.parseInt(a.substring(i,i+1));
            }else{
                A[i] = 0;
            }
        }
        for (int i = 0; i < len; i++) {
            if(i<b.length()){
                B[i] = Integer.parseInt(b.substring(i,i+1));
            }else{
                B[i] = 0;
            }
        }
        for(int i = 0;i<len;i++){
            result[i] = A[i]+B[i];
        }
        for(int i = 0;i<len;i++){
            if(result[i]>9){
                result[i] -= 10;
                result[i+1] += 1;
            }
            str.append(result[i]);
        }
        if(result[len]==0){
            return str.reverse().substring(1);
        }
        str.append(1);
        return str.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main2 main2 = new Main2();
        while(scanner.hasNext()){
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            System.out.println(main2.AddLongInteger(a,b));
        }
    }
}
