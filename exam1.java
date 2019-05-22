package bittech.test;

import java.util.Scanner;

public class exam1 {
    public static boolean isHuiWen(StringBuilder str){
        int l = 0;
        int r = str.length()-1;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串...");
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        for(int i = 0;i<=str1.length();i++){
            StringBuilder str = new StringBuilder(str1);
            str.insert(i,str2);
            if(isHuiWen(str)){
                count++;
            }
        }
        System.out.println(count);
    }
}
