//String类扩展功能实现
public class StrUtils{
    public static void main(String[] args){
        System.out.println(repeat('a',5));
        System.out.println(repeat('a',-1));
        System.out.println(fillBefore("abc",'A',5));
        System.out.println(fillBefore("abc",'A',2));
        System.out.println(fillAfter("abc",'A',5));
        System.out.println(fillAfter("abc",'A',3));
        System.out.println(removeAll("aa-bb-cc-dd", "-"));
        System.out.println(reverse("abcd"));
    }
    /**
    * 重复某个字符
    * 
    * 例如： 
    * 'a' 5   => "aaaaa"  
    * 'a' -1  => ""
    * 
    * @param c     被重复的字符
    * @param count 重复的数目，如果小于等于0则返回""
    * @return 重复字符字符串
    */
    public static String repeat(char c, int count) {
        char[] str = new char[100];
        if(count>0){
            for(int i = 0;i<count;i++){
                str[i] = c;
            }
            return new String(str);
        }
        return " ";
    }
   
   
    /**
    * 将已有字符串填充为规定长度，如果已有字符串大于等于这个长度则返回这个字符串
    * 字符填充于字符串前
    *
    * 例如： 
    * "abc" 'A' 5  => "AAabc"
    * "abc" 'A' 2  => "abc"
    *
    * @param str        被填充的字符串
    * @param filledChar 填充的字符
    * @param len        填充长度
    * @return 填充后的字符串
    */
    public static String fillBefore(String str, char filledChar, int len) {
        char[] str1 = str.toCharArray();
        char[] data = new char[len];
        if(str1.length<len){
            for(int i = 0;i<len-str1.length;i++){
                data[i] = filledChar;
            }
            for(int i = len-str1.length;i<len;i++){
                data[i] = str1[i-len+str1.length];
            }
          return new String(data);
        }
        return str;
    }
   
   /**
    * 将已有字符串填充为规定长度，如果已有字符串大于等于这个长度则返回这个字符串<br>
    * 字符填充于字符串后
    * 例如： 
    * "abc" 'A' 5  => "abcAA"
    * "abc" 'A' 3  => "abc"
    *
    * @param str        被填充的字符串
    * @param filledChar 填充的字符
    * @param len        填充长度
    * @return 填充后的字符串
    */
    public static String fillAfter(String str, char filledChar, int len) {
        char[] str1 = str.toCharArray();
        char[] data = new char[len];
        if(str1.length<len){
            for(int i = 0;i<str1.length;i++){
                data[i] = str1[i];
            }
            for(int i = str1.length;i<len;i++){
                data[i] = filledChar;
            }
            return new String(data);
        }
        return str;
    }

    /**
    * 移除字符串中所有给定字符串
    * 例：removeAll("aa-bb-cc-dd", "-") => aabbccdd
    *
    * @param str         字符串
    * @param strToRemove 被移除的字符串
    * @return 移除后的字符串
    */
    public static String removeAll(String str, String strToRemove) {
        if(!str.contains(strToRemove)){
            return str;
        }
        return str.replaceAll(strToRemove, "");
    }
    
    /**
    * 反转字符串
    * 例如：abcd => dcba
    *
    * @param str 被反转的字符串
    * @return 反转后的字符串
    */
    public static String reverse(String str) {
        char[] str1 = str.toCharArray();
        char[] data = new char[str1.length];
        for(int i = 0;i<str1.length;i++){
            data[i] = str1[str1.length-1-i];
        }
        return new String(data);
    }
}
