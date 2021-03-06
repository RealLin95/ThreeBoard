package com.bittech.chatroom.client.multi;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadDataFromServer extends Thread {
    private final Socket client;

    public ReadDataFromServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run(){
        try {
            InputStream in = client.getInputStream();
            Scanner scanner = new Scanner(in);
            while(true){
                try{
                    String message = scanner.nextLine();
                    System.out.println(message);
                }catch(NoSuchElementException e){

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
