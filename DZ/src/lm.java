//12 В
import java.util.Scanner;
public class lm {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int n=1;
        double ep=0.0001,x , t=1, G=0, p=1;
        System.out.println("Введите x<1 ");
        x=sc.nextDouble();
        t=-x;
        while(Math.abs(t)>ep){
            G+=t;
            t*=p*x;
            t=t/n;
            n++;
            p=-p;
        }
        System.out.println(G);
    }
}
