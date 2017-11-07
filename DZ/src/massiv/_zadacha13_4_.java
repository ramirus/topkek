package massiv;
//13 г
import java.util.Scanner;
import java.util.Random;
public class _zadacha13_4_ {
    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);
        Random ran=new Random();
        int n, k = 1, c = 0;
        System.out.println("введите n");
        n = q.nextInt();
        int[] a = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ran.nextInt();
            System.out.print(a[i]+" ");
        }
        for (int i = 0; i < n; i++) {
            v[i] = 0;
        }
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                k++;
            }
            if (a[i] != a[i - 1]) {
                v[c] = k;
                k = 1;
                c++;
            }
            if (i == n - 1) {
                v[c] = k;
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(v[i] + " ");
        }
    }
}
