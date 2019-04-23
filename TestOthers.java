package bittech;

import java.io.*;

//自行实现打印流
class PrintUtil{
    private OutputStream out;

    public PrintUtil(OutputStream out) {
        this.out = out;
    }

    public void print(String str){
        try {
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String str){
        this.print(str+"\r\n");
    }

    public void print(int data){
        this.print(String.valueOf(data));
    }

    public void println(int data){
        this.print(data+"\r\n");
    }

    public void print(double data){
        this.print(String.valueOf(data));
    }

    public void println(double data){
        this.print(data+"\r\n");
    }

    public void close(){
        try {
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class TestOthers {
    public static void main(String[] args) throws Exception {
        File file = new File("E:"+ File.separator+"IO"+File.separator+"IOTest"+File.separator+"haha");
        //PrintUtil printUtil = new PrintUtil(new FileOutputStream(file,true));
        PrintStream printUtil = new PrintStream(new FileOutputStream(file,true));
        printUtil.println(100);
        printUtil.println("haha");
        printUtil.println(111.222);
        printUtil.close();
        //使用内存流
        /*String str = "hello";
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len = 0;
        while((len = in.read())!=-1){
            out.write(Character.toUpperCase(len));
        }
        System.out.println(out);
        in.close();
        out.close();*/
    }
}
