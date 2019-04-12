package bittech;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Men{
    private String name;
    private int age;
    private double weight;

    public Men(int age){
        this.age = age;
    }

    public Men(String name) {
        this.name = name;
    }

    public Men(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Men{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
public class Test2 {
    public static void main(String[] args) throws Exception{
        Class<Men> cls = Men.class;
//        Men men = cls.newInstance();//此方法默认调用类中的无参构造方法
        Constructor<?> constructor = cls.getConstructor(String.class);//调用指定类型参数的构造方法
        Men men = (Men) constructor.newInstance("lin");        //若类中没有无参构造，就调用Constructor类提供的newInstance(参数)方法
        Field field = cls.getDeclaredField("age");
        //调用Field类的方法动态破坏封装，从而操作私有属性，仅在一次JVM进程中
        field.setAccessible(true);
        field.set(men,4);
        System.out.println(field.get(men));
        //取得指定参数名称的方法
        Method setMethod = cls.getMethod("setWeight", double.class);
        //通过调用Method类提供的invoke方法调用此方法
        setMethod.invoke(men,88.0);
        System.out.println(men);
    }
}