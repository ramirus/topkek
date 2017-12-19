package испр.массивы;//-
import java.util.Scanner;
import java.util.Random;
public class _8_2_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, g, schet = 0;
        System.out.println("введите n");
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] b1 = new int[n];
        int[] b2 = new int[n];
        Random R = new Random();
        for (int k = 0; k < n; k++) {
            a[k] = R.nextInt(10);
            System.out.print(a[k] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            b[i] = R.nextInt(10);
            System.out.print(b[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            g = a[i];
            for (int j = 0; j < n; j++) {
                if (g == b[j]) {
                    b1[i] = 1;
                }
            }
            if (b1[i] == 1) {
                schet++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (b1[i] == b2[i] && b2[i] == 1) {
                schet++;
            }
        }
        System.out.println(" ");
        System.out.println(schet);
    }
}
