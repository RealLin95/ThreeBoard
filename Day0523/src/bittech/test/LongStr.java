package bittech.test;

import java.util.Scanner;
//一个字符串中的最长数字串
public class LongStr {
    public static String longStr(String str){
        int max = 0;
        int count = 0;
        int end = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                count++;
                if(max<count){
                    max = count;
                    end = i;
                }
            }else{
                count = 0;
            }
        }
        //subString()左闭右开
        return str.substring(end-max+1,end+1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while(scanner.hasNext()){
            str = scanner.nextLine();
            System.out.println(longStr(str));
        }
    }
}
