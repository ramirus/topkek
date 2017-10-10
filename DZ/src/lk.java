//12 Б
import java.util.Scanner;
public class lk {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int x, n=1, p=1;
        double ep=0.0001, t=1, G=0;
        System.out.println("Введите x ");
        x=sc.nextInt();
        t=x;
        while(Math.abs(t)>ep){
            G+=t;
            t*=(x*x)/((2.0*n)*(2.0*n+1.0));
            n++;
            p=-p;
        }
        System.out.println(G);
    }
}

