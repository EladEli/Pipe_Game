package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try{
            Socket clientSocket = new Socket("127.0.0.1", 6666);
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(),true);

            String toSend = "String to send";

            printWriter.print(toSend);
            clientSocket.getOutputStream().close();
            clientSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
