/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complex;

/**
 *
 * @author hp
 */
public class Complex {
     float real;
     float imag;
          public Complex()
     {
        
     }
     
     public Complex(float m,float n)
     {
         real=m;
         imag=n;
     }
     public Complex (float m)
     {
         real=imag=m;
     }
     public void setreal(float m)
     {
         real=m;
     }
          public void setimag(float m)
     {
         imag=m;
     }
          public float getimag()
          {
              return imag;
          }
        public float getreal()
          {
              return real;
          }
        public void print()
        {
            System.out.println(real);
            System.out.println(imag);
        }
        public void add(Complex comp1,Complex comp2)
      {
    float resr,resi;
    resr=comp1.real+comp2.real;
    resi=comp1.imag+comp2.imag;
System.out.println(resr + " + " + resi + " i" );
      }
      public void sub(Complex comp1,Complex comp2)
      {
float resr,resi;
    resr=comp1.real-comp2.real;
    resi=comp1.imag-comp2.imag;
System.out.println(resr + " -" + resi +" i" );

      }

    /**
     * @param args the command line arguments
     */
 
    
}
