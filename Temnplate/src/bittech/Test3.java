package bittech;

import java.lang.reflect.Method;

class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class Test3 {
    public static void main(String[] args) throws Exception{
        Class<Person> cls = Person.class;
        //组装方法名称
        String setMethodName = "set"+initCap(args[0]);//通过数组写名字
        String getMethodName = "get"+initCap(args[0]);
        //取得Method对象
        Method setMethod = cls.getMethod(setMethodName,String.class);
        Method getMethod = cls.getMethod(getMethodName);
        //调用方法，首先产生实例化对象
        Person per = cls.newInstance();
        setMethod.invoke(per,"lin");
        System.out.println(getMethod.invoke(per));
    }
    private static String initCap(String str){
        return str.substring(0,1).toUpperCase()+
                str.substring(1);
    }
}
