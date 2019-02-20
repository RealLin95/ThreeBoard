package practice;
public class Day18{
    public static void main(String[] args){

        /* 正常程序流
        System.out.println("数学计算开始前");
        System.out.println("进行数学计算:"+10/2);
        System.out.println("数学计算结束后"); */

        /* 产生异常 
        System.out.println("数学计算开始前");
        System.out.println("进行数学计算:"+10/0); //Exception in thread "main" java.lang.ArithmeticException: / by zero
        System.out.println("数学计算结束后"); */

        /* 对异常进行处理 
        System.out.println("数学计算开始前");
        try{
            System.out.println("进行数学计算："+10/0);  //有可能出现异常的语句
        }catch(ArithmeticException e){
            System.out.println("异常已经被处理了");    // 发现异常之后的操作
        }finally{
            System.out.println("数学计算结束后");
        } */

        /* try...catch 异常处理结构 
        System.out.println("数学计算开始前");
        try{
            System.out.println("进行数学计算："+10/0);  //try语句只判断，若有异常，不输出
        }catch(ArithmeticException e){
            e.printStackTrace();   //输出完整异常信息
        }
        System.out.println("数学计算结束后"); */

        /* try...finally 异常处理结构 
        System.out.println("数学计算开始前");
        try{
            System.out.println("进行数学计算："+10/0);  //try语句判断出异常，不输出
        }finally{
            System.out.println("数学计算结束后");   //出口一定输出
        }  //最后系统输出具体异常  */

        /* try...catch...finally 异常处理结构 
        System.out.println("数学计算开始前");
        try{
            return ;
           // System.out.println("进行数学计算:"+10/0);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }finally{  //无论是否有异常，finally语句都会输出
            System.out.println("数学计算结束后");
        } //若try或catch块中有return语句，在return语句之前一定先执行finally语句  */

        /* 初始化参数进行数学运算 
        System.out.println("数学计算开始前");
        try{
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.println("进行数学计算:"+x/y);
        }catch(ArithmeticException e){   //若碰到多个异常时，采用多个catch块处理每个异常
            e.printStackTrace();   //除0异常
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();  //没有输入初始化参数
        }catch(NumberFormatException e){
            e.printStackTrace();  //输入的不是数字
        }finally{
            System.out.println("不管是否有异常，都会执行此语句");
        }
        System.out.println("数学计算结束后"); */

        /* 使用throws定义方法 
        try{
            System.out.println(subNumber(10,0));  //throws声明方法
        }catch(Exception e){   // 异常类及异常类对象————不是具体对象，因为在等throws告诉我们产生了什么异常
            e.printStackTrace();
        } */

        /* 主方法抛出异常 
        public static void main(String[] args) throws Exception{
        System.out.println(subNumber(10,0)); */

        /* 使用throw产生异常类对象 
        try{
            throw new Exception("抛异常");  //抛出自定义异常
        }catch(Exception e){
            e.printStackTrace();
        } */

        /* 异常处理标准格式 
        public static void main(String[] args){
            try{
                System.out.println(jisuan(10,0));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        public static int jisuan(int x,int y) throws Exception{  //告诉用户此方法存在哪种异常
            int result = 0;
            System.out.println("****计算开始****");
            try{
                result = x/y;
            }//catch(Exception e){
                //throw e;}  //抛出异常
            finally{
                System.out.println("####计算结束####");
            }
            return result;
        } */

        /* 观察断言 
        int num = 10;
        assert num == 50 :"错误：num应当为50";  //默认不启用断言，使用java -ea启用断言
        System.out.println(num); */

    }
}

    /* 使用throws定义方法&主方法抛出异常 
    public static int subNumber(int x,int y) throws Exception{  // throws声明方法，且只找出异常但并不处理
        return x/y;
    } */

/* 实现自定义异常类 
class AddException extends Exception{   //自定义异常类
    public AddException(String s){
        super(s);
    }
}
public class Day18{
    public static void main(String[] args) throws Exception{  //throws声明主方法，告诉主方法产生了哪种异常
        int num1 = 20;
        int num2 = 30;
        if(num1+num2 == 50){
            throw new AddException("错误的相加操作");  //调用构造方法抛出异常
        }
    }
} */

