package _14_23_24;
//14 a
import java.util.Scanner;
public class O {
    public static void main (String[]args){
        double S=0, ep=0.0001,x, t=1;
        int k=1, p=-1;
        Scanner sc =new Scanner(System.in);
        System.out.println("введите х");
        x=sc.nextDouble();
        while(t>=ep){
            S+=p*t*(Math.sin(t*x)*Math.sin(t*x));
            k++;
            t*=1.0/k;
            p=-p;

        }
            System.out.println(S);
    }
}
