package испр.массивы;

import java.util.Random;
import java.util.Scanner;

public class _8_3_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g, n;
        System.out.print("введите n");
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] b1 = new int[n];
        int[] b2 = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10);
            System.out.print(a[i] + " ");
        }

        System.out.println(' ');

        for (int i = 0; i < n; i++) {
            b[i] = r.nextInt(10);
            System.out.print(b[i] + " ");
        }
        System.out.println(' ');

        for (int k = 0; k < n; k++) {
            b2[k] = r.nextInt(2);
            System.out.print(b2[k] + " ");
        }
        System.out.println(' ');
        for (int i = 0; i < n; i++) {
            g = a[i];
            for (int j = 0; j < n; j++) {
                if (g == b[j]) {
                    b1[i] = 1;
                }
            }
            if (b1[i] == 1) ;
            System.out.print(b1[i] + " ");
        }
        for (int i = 0; i < n; i++) {
            if (b1[i] == b2[i] && b1[i] == 1) {
                System.out.print(b1[i] + " ");
            } else {
                System.out.print("0" + " ");
            }
        }
        System.out.println(" ");
        for (int k = 0; k < n; k++) {
            if (b1[k] == 1 || b2[k] == 1) {
                System.out.print("1 ");
            } else {
                System.out.print("0" + " ");
            }
        }
        System.out.println(" ");
        for (int i = 0; i < n; i++) {
            if (b1[i] == b2[i] && b1[i] == 1) {
                System.out.print("0" + " ");
            }
        }
    }
}