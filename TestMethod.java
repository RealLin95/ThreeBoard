package bittech;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMethod {
    public static void main(String[] args) {
        //1.取得File对象
        File file = new File("D:"+File.separator+"软件");
        //2.判断父路径是否存在，不存在则创建多级父路径
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        //3.判断文件是否存在，不存在则创建文件
//        if(file.exists()){
//            System.out.println("文件存在");
//        }else{
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        //将IO操作放在子线程中去执行
       new Thread(()->
       {listAllFile(file);},"目录输出"
       ).start();
        System.out.println("开始进行文件输出");
//        System.out.println(file.isFile());//是否是文件
//        System.out.println(file.isDirectory());//是否是文件夹
//        System.out.println(file.getParentFile().isDirectory());
//        System.out.println("文件大小"+file.length()+"个字节");
//        Date date = new Date(file.lastModified());
//        System.out.println("上次修改时间"+date);
//        SimpleDateFormat simpleDateFormat =
//                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat.format(date));
    }
    public static void listAllFile(File file){
        if(file.isFile()){
            System.out.println(file);
        }else{
            //file文件存在并且是一个文件夹
            if(file.exists()&&file.isDirectory()){
                File[] files = file.listFiles();
                for(File file1:files){
                    listAllFile(file1);
                }
            }
        }
    }
}
