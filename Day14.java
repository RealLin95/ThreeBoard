public class Day14{
    public static void main(String[] args){

        /* 1.将字符数组转为字符串：使用构造方法
        char[] data = new char[]{'h','e','l','l','o'};
        //将整个字符数组变为字符串,方法名称：public String(char value[])
        System.out.println(new String(data));  
        //将部分字符数组中的内容变为字符串，方法名称：public String(char value[],int offset,int count)
        System.out.println(new String(data,0,2)); */

        /* 2.将字符串转为字符数组：使用普通方法
        String str = "hellojava";
        //将整个字符串变为字符数组，方法名称：public char[] toCharArray()
        char[] data = str.toCharArray();
        for( char x : data){
            System.out.print(x+"、");
        }
        System.out.println();
        //取得字符串中的指定索引内容变为字符，方法名称：public char charAt(int index)
        System.out.println(str.charAt(4)); */

        /* 3.判断一个字符串是否由数字组成
        String str = "123456";
        System.out.println(isNumber(str)); */

        /* 4.字节数组变为字符串：采用构造方法
        byte[] data = new byte[]{'a','b','c'};
        //将整个字节数组变为字符串，方法名称：public String(byte bytes[])
        System.out.println(new String(data));
        //将部分字节数组的内容变为字符串，方法名称：public String(byte bytes[],int offset,int length)
        System.out.println(new String(data,0,2)); */

        /* 5.将字符串以字符数组的形式返回：采用普通方法
        //方法名称：public byte[] getBytes()
        String str = "hellojava";
        byte[] data = str.getBytes();
        for(byte x:data){
            System.out.print(x+"、"); //返回值为byte类型
        }
        System.out.println(); */

        /* 6.字符串比较 
        //区分大小写的比较，方法名称：public boolean equals(Object anObject)
        String str = "hello";
        String str1 = "Hello";
        String str2 = "hellO";
        System.out.println(str.equals(str1));
        //不区分大小写的比较，方法名称：public boolean equalsIgnoreCase(String anotherString)
        System.out.println(str.equalsIgnoreCase(str1));
        //区分大小写，且可以比较两个字符串的大小关系，方法名称：public int compareTo(String another String)
        System.out.println(str1.compareTo(str2)); //当碰到第一个不相等的字符时终止比较，返回两个字符的ASCII码差值
        System.out.println("天".compareTo("地")); */

        /* 7.字符串查找 
        // (1)判断子字符串是否存在，方法名称：public boolean contains(CharSequence s)
        String str = "hellojava";
        System.out.println(str.contains("java"));
        // (2)查找子字符串位置,返回子字符串的开始索引
        // 从前往后查找，方法名称：public int indexOf(String str)
        System.out.println(str.indexOf("java"));
        // 从指定位置开始，从前往后查找，方法名称：public indexOf(String str,int fromIndex)
        System.out.println(str.indexOf("java", 5));
        // 从后往前查找，方法名称：public lastIndexOf(String str)
        System.out.println(str.lastIndexOf("java"));
        //从指定位置开始，从后往前查找，方法名称：public lastIndexOf(String str,int fromIndex)
        System.out.println(str.lastIndexOf("java", 4));
        // (3)判断是否以指定字符串开头或结尾
        // 判断是否以指定字符串开头，方法名称：public boolean startsWith(String prefix)
        System.out.println(str.startsWith("hello"));
        // 从指定位置开始判断，是否以指定字符串开头，方法名称：public boolean startsWith(String prefix,int toffset)
        System.out.println(str.startsWith("java", 5));
        // 判断是否以指定字符串结尾，方法名称：public boolean endsWith(String suffix)
        System.out.println(str.endsWith("java")); */

        /* 8.字符串替换————返回替换后的字符串 
        String str = "aa-bb-cc-dd";
        String str1 = "Hellojava";
        // 替换所有的指定内容，方法名称：public String replaceAll(String regex,String replacement)
        System.out.println(str.replaceAll("-", ""));
        // 替换首个内容，方法名称：public String replaceFirst(String regex,String replacement)
        System.out.println(str1.replaceFirst("j", "J")); */

    }

    /* public static boolean isNumber(String str){
        char[] data = str.toCharArray();
        for(int i = 0;i<data.length;i++){
            if(data[i]<'0'||data[i]>'9'){
                return false;
            }
        }
        return true;
    } */
    
}