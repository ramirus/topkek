package massiv;
import java.util.Scanner;
import java.util.Random;
public class _22_2_ {
    public static void main(String[]args){
        Random r= new Random();
        Scanner sc=new Scanner(System.in);
        int n,k=0;
        n=sc.nextInt();
        int[]a= new int [n];
        for(int i=0; i<=n-1; i++){
            a[i]=r.nextInt(41)-20;
            System.out.print(a[i]+" ");
        }
        for(int i=0; i<=n-2; i++){
           if((a[i]<0)&&(a[i+1]>0)) {k++;}
            if((a[i]>0)&&(a[i+1]<0)) {k++;}
        }
        System.out.println("  "+k);
    }
}
