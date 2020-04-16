/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import complex.Complex;

/**
 *
 * @author hp
 */
public class main {
       public static void main(String[] args) {
        // TODO code application logic here
        Complex s1=new Complex(3,5);
        Complex s2=new Complex(4,6);
        Complex s3=new Complex();
        s3.add(s1, s2);
       s3.sub(s1, s2);
        //s3.print();
        
        
        
        
        
    }
    
}
