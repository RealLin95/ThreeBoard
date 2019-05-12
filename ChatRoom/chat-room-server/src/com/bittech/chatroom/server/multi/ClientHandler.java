package com.bittech.chatroom.server.multi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler implements Runnable {
    private final Socket client;
    private static final Map<String,Socket> SOCKET_MAP =
            new ConcurrentHashMap<>();

    private String currentName;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        //业务实现
        try {
            InputStream in = this.client.getInputStream();
            Scanner scanner = new Scanner(in);
            while(true){
                String line = scanner.nextLine();
                String[] segments = line.split(":");
                if(segments.length==2 && segments[0].equals("register")){
                    //注册流程
                    String name = segments[1];
                    register(name);
                    continue;
                }else if(segments.length==2 && segments[0].equals("group")){
                    //群聊流程
                    String message = segments[1];
                    groupChat(message);
                    continue;
                }else if(segments.length==3 && segments[0].equals("private")){
                    //私聊流程
                    String name = segments[1];
                    String message = segments[2];
                    privateChat(name,message);
                    continue;
                }
                if(line.equals("quit")){
                    //退出流程
                    quit();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void register(String name){
        //注册
        //name --> Socket
        //key --> value
        SOCKET_MAP.put(name,this.client);
        this.currentName = name;
        this.sendMessage(this.client,"恭喜<"+name+">注册成功");
        printOnlineClient();
    }

    private void sendMessage(Socket socket,String message){
        try {
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println(message);
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printOnlineClient(){
        System.out.println("当前在线的客户端有"+SOCKET_MAP.size()+
                "名称列表如下：");
        for(String key:SOCKET_MAP.keySet()){
            System.out.println(key);
        }
    }

    private void groupChat(String message){
        for(Map.Entry<String,Socket> entry:SOCKET_MAP.entrySet()){
            Socket socket = entry.getValue();
            if(socket!=this.client){
                this.sendMessage(socket,this.currentName+"说>"+message);
            }
        }
    }

    private void privateChat(String name,String message){
        Socket socket = SOCKET_MAP.get(name);
        if(socket!=null){
            this.sendMessage(socket,this.currentName+"说>"+message);
        }
    }

    private void quit(){
        Iterator<Map.Entry<String,Socket>> iterator = SOCKET_MAP.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Socket> entry = iterator.next();
            if(entry.getValue()==this.client){
                System.out.println(entry.getKey()+"退出");
                iterator.remove();
                break;
            }
        }
        printOnlineClient();
    }

}
