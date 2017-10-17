package _14_23_24;//23 a
import java.util.Scanner;
public class u {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int k=2,b,a,x;
        System.out.println("введите а");
        a=sc.nextInt();
        System.out.println("введите b");
        b=sc.nextInt();
        System.out.println("введите x");
        x=sc.nextInt();
        double v, v0, v1,S;
        v0=v1=a;
        v=v0+v1;
        S=Math.log10(v0*x)+Math.log10(v1*x);
        while(v<=b){
            S+=Math.log10(v*x);
            v0=v1;
            v1=v;
            v=v0+v1;
        }
        System.out.println(S);
    }
}
