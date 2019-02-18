public class Day15{
    public static void main(String[] args){
        /* 1.字符串拆分 
        // 字符串全部拆分，方法名称：public String[] spilt(String regex)
        String str = "hello java hello world";
        String[] data = str.split(" ");
        for(String x:data){
            System.out.println(x);
        }
        // 将字符串部分拆分，方法名称：public String[] spilt(String regex,int limit)
        String[] data2 = str.split(" ",4);
        for(String y:data2){
            System.out.println(y);
        } 
        // 拆分IP地址，如果发现有些内容无法拆分开要用"\\"转义
        String add = "192.168.1.1";
        String[] adds = add.split("\\.");  // "."
        for(String x:adds){
            System.out.println(x);
        } 
        //多次拆分：
        String news = "yuisama:27|yui:25";
        String[] new1 = news.split("\\|");
        for(int i = 0;i<new1.length;i++){
            String[] new2 = new1[i].split("\\:");
            System.out.println(new2[0]+"="+new2[1]);
        } */

        /* 2.字符串截取 
        // 从指定索引截取到结尾，方法名称：public String substring(int beginIndex)
        String str = "hellojava";
        String data = str.substring(5);
        System.out.println(data);
        // 截取部分内容（左闭右开），方法名称：public String substring(int beginIndex,int endIndex)
        String data2 = str.substring(0, 5);
        System.out.println(data2); */

        /* 3.其他操作方法 
        // 去掉字符串左右两边的空格，保留中间的空格，方法名称：public String trim()
        String str = "  hello java  ";
        String str1 = "嘿 # Hello Java # 哈";
        String data1 = "hello";
        String data2 = "world";
        System.out.println(str.trim());
        // 字符串转大写，方法名称：public String toUpperCase()
        System.out.println(str.toUpperCase());
        // 字符串转小写,方法名称：public String toLowerCase()
        System.out.println(str1.toLowerCase());
        // 字符串连接，方法名称：public String concat(String str)
        System.out.println(data1.concat(data2));
        // 取得字符串长度，方法名称：public int length()
        System.out.println(str.length());
        System.out.println(str1.length());
        // 判断是否为空字符串(长度为0，不是null)，方法名称：public bolean isEmpty()
        System.out.println(new String().isEmpty());
        System.out.println("".isEmpty()); */

        /* 首字母大写
        System.out.println(firstUpper(""));
        System.out.println(firstUpper("a"));
        System.out.println(firstUpper("hello")); */

        /* StringBuffer类操作方法*/
        String str = "hello";
        StringBuffer srb = new StringBuffer("aabbccdd"); 
        // 通过构造方法将String变为StringBuffer类
        StringBuffer data = new StringBuffer(str); 
        System.out.println(data);
        // 字符串连接，方法名称：public synchronized StringBuffer append(各种数据类型 b)
        System.out.println(data.append("哈哈"));
        System.out.println(data.append(2333)); 
        // 字符串反转，方法名称：public synchronized StringBuffer reverse()
        System.out.println(srb.reverse());
        // 删除指定范围内的数据，方法名称：public synchronized StringBuffer delete(int start,int end)
        System.out.println(srb.delete(0,5));
        // 插入数据，方法名称：public synchronized StringBuffer insert(int offset,各种数据类型 b)
        System.out.println(srb.insert(1,"哈哈"));
        // 将StringBuffer变为String类，方法名称：public String toString()
        System.out.println(srb.toString());
    }

    /* 首字母大写
    public static String firstUpper(String str){
        if(str.isEmpty()||str==null){
            return str;
        }else if(str.length()>1){
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }return str.toUpperCase();
    } */

}