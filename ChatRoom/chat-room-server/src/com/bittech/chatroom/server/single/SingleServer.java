package com.bittech.chatroom.server.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleServer {
    public static void main(String[] args) {
        //聊天室的服务器端
        try {
            //1.创建ServerSocket
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("服务端启动"+serverSocket.getInetAddress()
                    +":"+serverSocket.getLocalPort());
            //2.等待多个客户端连接
            //阻塞操作，直到客户端连接到服务端才会继续执行
            while(true){
                final Socket socket = serverSocket.accept();
                System.out.println("客户端连接"+socket.getRemoteSocketAddress()
                        +":"+socket.getPort());
                //3.服务端可以进行接受和发送数据
                //3.1 服务端接收数据(read)
                InputStream in = null;
                try {
                    in = socket.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scanner scanner = new Scanner(in);
                String message = scanner.next();
                System.out.println("接收到客户端发送的数据："+message);
                //3.2服务端发送数据(write)
                OutputStream out = null;
                try {
                    out = socket.getOutputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PrintStream printStream = new PrintStream(out);
                printStream.println("你好客户端");
                printStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务端发生异常"+e.getMessage());
        }
    }
}
