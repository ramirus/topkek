package massiv;
import java.util.Random;
import java.util.Scanner;
public class _zadacha_2_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int n, c = 0, g = 0, m = 0, l = 0, S=0;
        System.out.println("введите n");
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i <= n - 1; i++) {
            a[i] = r.nextInt(n);
        }
        c=a[0];
        m=a[0];
        for(int i=0; i<=n-1; i++){
            if(a[i]<c){c=a[i]; i=g;}
        }
        for(int i=0; i<=n-1; i++){
            if(a[i]>m){m=a[i]; i=l;}
        }
        for(int i=g; i<=m ;i++){
            S+=a[i];
        }
        System.out.println(S);
    }
}