package bittech.test;
import java.util.Scanner;
public class DeleteTest{
    public static String deleteStr(String str1,String str2){
        StringBuilder str = new StringBuilder("");
        if(str1==null||str2==null){
            return null;
        }
        if(str2==""){
            return str1;
        }
        for(int i=0;i<str1.length();i++){
            int count = 0;
            for(int j=0;j<str2.length();j++){
                if(str1.charAt(i)!=str2.charAt(j)){
                    count++;
                }else{
                    break;
                }
            }
            if(count==str2.length()){
                str.append(str1.charAt(i));
            }
        }
        return str.toString();
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(deleteStr(str1,str2));
        }
    }
}