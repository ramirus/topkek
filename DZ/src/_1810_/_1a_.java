package _1810_;
import java.util.Scanner;
import java.util.Random;
public class _1a_ {
    public static void main(String[]args){
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("введите n");
        n=sc.nextInt();
        Random r= new Random();
        int []a=new int[n];
        int []y=new int[n];
        int []z=new int[n];
        for(int i=0; i<=n-1; i++){
            a[i]=r.nextInt(n);
        }
        for(int i=1; i<=n-1; i++){
            y[i]=a[i+1];
                    System.out.print(y[i]+ a[n-1]+" ");
        }
        for(int i=1; i<=n-1; i++){
            z[i]=a[i-1];
                    System.out.print(a[n-1]+ z[i]);
        }
    }
}
