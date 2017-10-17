package _20d_28_29b_30a_32b;

import java.util.Scanner;
public class _28_ {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        double x, a=0.0, ep=0.001, a0, b0, b=0.0;
        int k=1;
        System.out.println("введите х от 0 до 2");
        x=sc.nextDouble();
        a0=x;
        b0=1.0-x;
        while((b<=ep)&&(a<=Math.sqrt(x))){
        a=a0*(1.0+b0/2.0);
        b=b0*b0*(3.0+b0);
        a0=a;
        b=b0;
        }
        System.out.println(a);
    }
}
