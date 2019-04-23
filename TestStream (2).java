package bittech;

import java.io.*;

//class CloseTest implements AutoCloseable{
//
//    @Override
//    public void close() throws Exception {
//        System.out.println("自动调用close方法");
//    }
//    public void fun(){
//        System.out.println("普通方法");
//    }
//}
//public class TestStream {
//    public static void main(String[] args) throws Exception {
//        try(CloseTest closeTest = new CloseTest()){
//            closeTest.fun();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        //1.取得终端对象
//        File file = new File("E:"+ File.separator+"IO"+File.separator+"IOTest"+File.separator+"haha");
//        if(!file.getParentFile().exists()){
//            file.getParentFile().mkdirs();
//        }
//        //2.取得指定文件的输出流
//        OutputStream out = new FileOutputStream(file,true);//允许文件内容的追加
//        //3.进行数据的输出
//        String str = "hello world";
//        out.write(str.getBytes(),6,5);
//        //4.关闭流
//        out.close();
//    }
//}

public class TestStream{
    public static void main(String[] args) throws Exception{
        //1.取得终端对象
        File file = new File("E:"+ File.separator+"IO"+File.separator+"IOTest"+File.separator+"haha");
        //2.取得相应输入流
        InputStream in = new FileInputStream(file);
        //3.进行数据的读取
        byte[] data = new byte[1024];
        int len = in.read(data);
        System.out.println(new String(data,0,len));
        //4.关闭流
        in.close();
    }
}
