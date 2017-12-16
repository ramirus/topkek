package испр.циклы; //-
import java.util.Scanner;
public class _32b_ {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        double a, x=1.0, x0, y, ep=0.0001;
        System.out.println("введите а");
        a=sc.nextDouble();
        x0=a;
        y=1.0+9.0*(Math.sin(x0)/2.0);
        while((Math.abs(x-x0)>=ep)&&(x!=y)){
            x=1.0+9.0*(Math.sin(x0)/2.0);
            x0=x;
        }
        System.out.println(x);
    }
}
