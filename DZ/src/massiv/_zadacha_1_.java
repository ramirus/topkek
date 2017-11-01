package massiv;//-
import java.util.Random;
import java.util.Scanner;
public class _zadacha_1_ {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        Random r= new Random();
        int n, k=0, c=0;
        System.out.println("введите n");
        n=sc.nextInt();
        int []a= new int [n];
        for(int i=0; i<=n-1; i++){
            a[i]=r.nextInt(n);
        }
        c=a[0];
        for(int i=1; i<=n-1; i++){
            if(a[i]<c){
                c=a[i];
            }
            if(c==a[i]) {
            k++;}   //неверно, попробуйте массив типа 5 5 5 4 4 4 3 3 3 1 1 1
        }
        System.out.println(k);
    }
}
