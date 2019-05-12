package com.bittech.chatroom.client.multi;

import java.io.IOException;
import java.net.Socket;

public class MultiThreadClient {
    public static void main(String[] args) {
        String defaultHost = "127.0.0.1";
        String host = defaultHost;
        int defaultPort = 6666;
        int port = defaultPort;
        for(String arg:args){
            if(arg.startsWith("--port=")){
                try{
                    String portStr = arg.substring("--port=".length());
                    port = Integer.parseInt(portStr);
                }catch(NumberFormatException e){
                    port = defaultPort;
                }
            }
            if(arg.startsWith("--host=")){
                    host = arg.substring("--host=".length());
            }
        }

        try {
            Socket socket = new Socket(host,port);
            Thread read = new ReadDataFromServer(socket);
            read.setName("Thread-Client-Read");
            read.start();
            Thread write = new WriteDataToServer(socket);
            write.setName("Thread-Client-Write");
            write.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
