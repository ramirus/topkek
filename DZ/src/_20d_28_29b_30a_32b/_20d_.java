package _20d_28_29b_30a_32b;
 import java.util.Scanner;
public class _20d_ {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int a, b, c, d, f, g, h, e, n, k=3;
        int x=0, y=0, x0, x1, x2, y2, y1;
        System.out.println("введите а");
        a=sc.nextInt();
        System.out.println("введите b");
        b=sc.nextInt();
        System.out.println("введите c");
        c=sc.nextInt();
        System.out.println("введите d");
        d=sc.nextInt();
        System.out.println("введите e");
        e=sc.nextInt();
        System.out.println("введите f");
        f=sc.nextInt();
        System.out.println("введите g");
        g=sc.nextInt();
        System.out.println("введите h");
        h=sc.nextInt();
        System.out.println("введите n");
        n=sc.nextInt();
        x0=a;
        x1=b;
        x2=c;
        y1=x1;
        y2=x2;
        while(k<=n){
            x=d*x2+e*y1+f*x0;
            y=g*x2+h*y1;
            x0=x1;
            x1=x2;
            x2=x;
            y1=y2;
            y2=y;
            k++;
        }
        System.out.println("x="+x);
        System.out.println("y="+y);
    }
}
