package com.bittech.chatroom.server.multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class MutilThreadServer {
    //线程池调度器
    private static ExecutorService excutor;
    public static void main(String[] args) {
        //通过参数得到端口号
        int defaultPort = 6666;
        int defaultThread = 10;
        int port = defaultPort;
        int thread = 10;
        for(String arg:args){
            if(arg.startsWith("--port=")) {
                String portStr = arg.substring("--port=".length());
                try {
                    port = Integer.parseInt(portStr);
                } catch (NumberFormatException e) {
                    port = defaultPort;
                }
            }
            if(arg.startsWith("--thread=")){
                String threadStr = arg.substring("--thread=".length());
                try{
                    thread = Integer.parseInt(threadStr);
                }catch(NumberFormatException e){
                    thread = defaultThread;
                }
            }
        }

        try {
            excutor = Executors.newFixedThreadPool(10, new ThreadFactory() {
                //原子变量表示下标
                private final AtomicInteger id = new AtomicInteger(0);
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setName("Thread-Client-Handler-"+id.getAndIncrement());
                    return thread;
                }
            });
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动"+serverSocket.getInetAddress()
                    +":"+serverSocket.getLocalPort());
            while(true){
                final Socket client = serverSocket.accept();
                //使用线程池进行业务处理
                excutor.execute(new ClientHandler(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
