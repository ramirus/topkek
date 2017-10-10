//12 Г
import java.util.Scanner;
public class asd {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int n=1;
        double ep=0.0001,x , t=1, G=0, p=1;
        System.out.println("Введите x ");
        x=sc.nextInt();
        while(Math.abs(t)>ep){
            G+=t;
            t*=p*x*x/(2.0*n);
            n++;
            p=-p;
        }
        System.out.println(G);
    }
}
