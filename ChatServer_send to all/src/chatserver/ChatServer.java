/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class ChatServer {

    ServerSocket serverSocket;
    static Vector<ChatHandler> clients = new Vector<ChatHandler>();

    class ChatHandler extends Thread {

        DataInputStream datainput;
        PrintStream printstream;
        //s1 socket server

        public ChatHandler(Socket s1) {
            try {
                datainput = new DataInputStream(s1.getInputStream());
                printstream = new PrintStream(s1.getOutputStream());
                clients.add(this);
                //to start this thread
                start();

            } catch (IOException ex) {
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        @Override
        public void run() {
            //to listen to a socket server
            String str;
            try {

                str = datainput.readLine();
                SendToAll(str);

            } catch (IOException ex) {
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        private void SendToAll(String str) {
            for(ChatHandler ch:clients)
                ch.printstream.println(str);
        }

    }

    public ChatServer() {

        try {
            serverSocket = new ServerSocket(5006);
            Socket s;
            while (true) {
                s = serverSocket.accept();
                new ChatHandler(s);

            }
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new ChatServer();
    }

}
