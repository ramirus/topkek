package massiv;
import java.util.Random;
import java.util.Scanner;
public class _zadacha_3_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int n, m = 0, g=0,  S=1 ;
        System.out.println("введите n");
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i <= n - 1; i++) {
            a[i] = r.nextInt(n);
        }
        m=a[0];
        for(int i=0; i<=n-1; i++){
            if(a[i]>m){
                m=a[i];
                i=g;
            }
        }
        for(int i=g; i<=n-1; i++){
            if(a[i]!=0){
            S*=a[i];
            }
        }
        System.out.println(S);
    }
}