package bittech;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//1.自定义类实现Comparable接口
class Student implements Comparable<Student>{
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
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
    public int compareTo(Student o) {
        if(this.age>o.age){
            return 1;
        }else if(this.age<o.age){
            return -1;
        }else{
            //age相等，此时比较name属性
            return this.name.compareTo(o.name);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

public class SetTest {
    public static void main(String[] args) {
        // 有序存储，若想对自定义类进行排序比较，
        // 自定义类必须实现Comparable接口并覆写compareTo()方法
        Set<Student> set = new TreeSet<>();
        set.add(new Student("lin",4));
        set.add(new Student("meng",5));
        System.out.println(set);
    }
}
