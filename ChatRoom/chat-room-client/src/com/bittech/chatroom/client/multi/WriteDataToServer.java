package com.bittech.chatroom.client.multi;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class WriteDataToServer extends Thread{
    private final Socket client;

    public WriteDataToServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run(){
        try {
            Scanner scanner = new Scanner(System.in);
            OutputStream out = this.client.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            while(true){
                System.out.print("请输入>");
                String message = scanner.nextLine();
                printStream.println(message);
                if(message.equals("quit")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                this.client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
