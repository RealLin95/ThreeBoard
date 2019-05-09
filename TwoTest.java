package bittech;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Male{
    private String name;
    private Integer age;

    public Male(String name, Integer age) {
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
        return "Male{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode(){
        return Objects.hash(age,name);
    }

    @Override
    public boolean equals(Object obj){
        //自反性
        if(obj==this){
            return true;
        }
        //非空性
        else if(obj==null){
            return false;
        }
        //对称性、传递性、一致性
        else if(!(obj instanceof Male)){
            return false;
        }
        Male male = (Male) obj;
        return male.age.equals(this.age)&&male.name.equals(this.name);
    }
}

public class TwoTest {
    public static void main(String[] args) {
        Set<Male> set = new HashSet<>();
        set.add(new Male("张三",18));
        set.add(new Male("李四",20));
        set.add(new Male("李四",20));
        System.out.println(set);
    }
}
