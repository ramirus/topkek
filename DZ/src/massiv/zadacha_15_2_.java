package massiv;

import java.util.Scanner;
import java.util.Random;

public class zadacha_15_2_ {
    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);
        Random ran = new Random();
        int n, k = 1, c = 0, min, max;
        System.out.println("введите n");
        n = q.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ran.nextInt(30);
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < n; i++) {
            b[i] = 0;
        }
        for (int i = 1; i < n; i++) {
            if (a[i] >= a[i - 1]) {
                k++;
            }
            b[k]++;
            if (a[i] < a[i - 1]) {
                b[c] = k;
                k = 1;
                c++;
            }
            if (i == n - 1) {
                b[c] = k;
            }

        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
