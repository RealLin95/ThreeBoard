package bittech;

import java.lang.String;
import java.io.File;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

interface TestSer{

}

class Person implements Serializable{

    private String name;
    private Integer age;

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
}

public class TestSystem {
    public static void main(String[] args) throws Exception{
        Person per = new Person();
        per.setName("lin");
        per.setAge(4);
        File file = new File("C:\\Users\\Administrator\\Desktop\\xixi.txt");



        //java.util.Scanner支持正则表达式
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("please input age...");
        scanner.useDelimiter("\n");
        if(scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")){
            System.out.println(scanner.next());
        }*/

        //通过Scanner替换BufferedReader
        //String->File->FileInputStream->Scanner
//        Scanner scanner = new Scanner(new FileInputStream(new File(
//                "E:\\IO\\IOTest\\haha"
//        )));
//        Scanner scanner = new Scanner(Paths.get("E:\\IO\\IOTest\\haha"));
//        scanner.useDelimiter("\n");
//        while(scanner.hasNext()){
//            System.out.println(scanner.next());
//        }
//        scanner.close();
    }
}
