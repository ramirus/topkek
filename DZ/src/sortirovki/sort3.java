package sortirovki;

import java.util.Random;
import java.util.Scanner;

public class sort3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int n, c;
        int[] a = {1, 5, 1, 6, 6, 4, 6, 6, 8, 7, 2, 7, 7, 4, 8, 2};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
        int r;
        int b;
        for (int i = 0; i < a.length; i++) {
            r = i;
            c = a[i];
            for (int k = i + 1; k < a.length; k++) {
                if (a[k] > c) {
                    c = a[k];
                    r = k;
                }
            }
            b = a[r];
            a[r] = a[i];
            a[i] = b;

            System.out.print(a[i] + " ");
        }
    }
}

