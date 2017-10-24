package massiv;
import java.util.Scanner;
import java.util.Random;
public class _22_7_ {
    public static void main(String[]args){
        Random r= new Random();
        Scanner sc=new Scanner(System.in);
        int n,k=0;
        n=sc.nextInt();
        int[]a= new int [n];
        for(int i=0; i<=n-1; i++){
            a[i]=r.nextInt(n);
            System.out.print(a[i]+" ");
        }
        for(int i=0; i<=n-1; n++){
            for(int j=2; (a[i]/j)>0; j++){
                if(j==a[i]) {
                    k++;
                }
            }
        }
        System.out.println(k);
    }

}
