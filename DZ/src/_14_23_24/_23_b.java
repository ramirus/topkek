package _14_23_24;
//23 Б
import java.util.Scanner;
public class _23_b {
    public static  void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int k=2,b,a,x, p=1;
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
            S+=p*(v/2)*(Math.cos(v*x)*Math.cos(v*x));
            v0=v1;
            v1=v;
            v=v0+v1;
        }
        System.out.println(S);
    }
}
