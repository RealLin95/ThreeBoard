package bittech;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
    public static void main(String[] args) throws Exception{
        /*Stack stack = new Stack();
        stack.push("111");
        stack.push("222");
        stack.push("333");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());*/
        /*Queue<String> queue = new LinkedList<>();
        queue.add("hello");
        queue.add("Java");
        queue.add("world");
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());*/
        /*Properties属性文件操作
        Properties properties = new Properties();
        properties.setProperty("User","Lin");
        properties.setProperty("Password","112233");
        System.out.println(properties.getProperty("User"));
        System.out.println(properties.getProperty("Password"));
        System.out.println(properties.getProperty("Habit"));
        System.out.println(properties.getProperty("Habit","singing"));*/
        //将资源的内容输出到文件中
        File file = new File("C:\\Users\\Administrator\\Desktop\\Test.properties");
        Properties properties = new Properties();
        /*将内容写入文件中
        properties.setProperty("User","Lin");
        properties.setProperty("Password","112233");
        properties.store(new FileOutputStream(file),"User and Password");*/
        //将内容从文件中读取出来
        properties.load(new FileInputStream(file));
        System.out.println(properties.getProperty("User"));
        System.out.println(properties.getProperty("Password"));
    }
}
