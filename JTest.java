package bittech;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }else if(obj==null){
            return false;
        }else if(!(obj instanceof Person)){
            return false;
        }
        // 此时传进来的对象是Person类型对象
        Person per = (Person) obj;
        return this.age ==per.age && this.name.equals(per.name);
    }

}

public class JTest {
    public static void main(String[] args) {
    //    List<Person> list = new ArrayList<>();
        List<Person> list = new Vector<>();
    //    List<Person> list = new LinkedList<>();
        list.add(new Person("lin",4));
        list.add(new Person("meng",5));
        list.add(new Person("hua",6));
        System.out.println(list);
        // 覆写equals()方法后contains()、remove()方法可以正常使用
        System.out.println(list.contains(new Person("meng",5)));
        System.out.println(list.remove(new Person("hua",6)));
        System.out.println(list.get(0));
        System.out.println(list.set(0,new Person("linda",20)));
        System.out.println(list);
    }
}
