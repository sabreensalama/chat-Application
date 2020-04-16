/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author hp
 */


public class ChatClient {

    SampleUI ui;
    DataInputStream datainput;
    PrintStream printstream;
    String str;

    /**
     * @param args the command line arguments
     */
    
    public ChatClient() {
    
        ui = new SampleUI();
        ui.setVisible(true);
        ui.setSize(500,500);
        
        try {
           Socket s1 = new Socket("127.0.0.1", 5006);
            datainput = new DataInputStream(s1.getInputStream());
            printstream = new PrintStream(s1.getOutputStream());

        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ui.okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                str = ui.tf.getText();
                //to send it
                printstream.println(str);
                ui.tf.setText(" ");
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {        
                    try {
                        while (true) {
                        str = datainput.readLine();
                        ui.ta.append(str+ " \n");
                    }
                    } catch (IOException ex) {
                        Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            
        }).start();
        

    }

    public static void main(String[] args) {
        // TODO code application logic here
        ChatClient chatClient = new ChatClient();
    }
}
