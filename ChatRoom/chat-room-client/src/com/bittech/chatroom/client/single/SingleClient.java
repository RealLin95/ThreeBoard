package com.bittech.chatroom.client.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleClient {
    public static void main(String[] args) {
        //客户端
        String host = "127.0.0.1";
        int port = 6666;
        try {
            //1.创建客户端Socket对象和服务器建立连接
            Socket socket = new Socket(host,port);
            //2.客户端进行发送和接收数据
            //2.1发送数据(write)
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println("服务器我来了...");
            printStream.flush();
            //2.2接收数据(read)
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            String message = scanner.next();
            System.out.println("从服务端接收的数据:"+message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
