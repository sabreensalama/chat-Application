/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author hp
 */
class SampleUI extends JFrame {

    JTextArea ta;
    JTextField tf;
    JButton okButton;

    public SampleUI() {

        this.setLayout(new FlowLayout());
        ta = new JTextArea(5, 50);
        JScrollPane scroll = new JScrollPane(ta);
        scroll.setViewportView(ta);
        tf = new JTextField(30);
        okButton = new JButton("Send");
        
        add(scroll);
        add(tf);
        add(okButton);
    }
}
