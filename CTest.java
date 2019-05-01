package bittech;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

//2.比较器实现Compator接口，进行类的排序

//2.1 Person类比较器 --> 比较年龄（升序）
class AscAgeComparator implements Comparator<Men>{

    @Override
    public int compare(Men o1, Men o2) {
        return o1.getAge()-o2.getAge();
    }

}

//2.2 Person类比较器 -->
class DescAgeComparator implements Comparator<Men>{

    @Override
    public int compare(Men o1, Men o2) {
        return o2.getAge()-o1.getAge();
    }

}

// 类本身不支持排序
class Men{
    private String name;
    private Integer age;

    public Men(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Men{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

public class CTest {
    public static void main(String[] args) {
        // 根据TreeSet的构造方法重载
        // public TreeSet(Comparator<? super E> comparator)
        // 传入一个Men类的比较器对象即可实现Men类对象的比较
//        Set<Men> set = new TreeSet<>(new AscAgeComparator());
        Set<Men> set = new TreeSet<>(new DescAgeComparator());
        set.add(new Men("lee",21));
        set.add(new Men("wang",20));
        System.out.println(set);
    }
}
