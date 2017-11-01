package sortirovki;

import java.util.Random;
import java.util.Scanner;

public class sortirovka1 {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        Random ran = new Random();

        int n = sc.nextInt(), max = 0, r = 0, b = 0;
        int[] a = new int[n];


        for (int i = 0; i < n; i++) {
            a[i] = ran.nextInt(10);
            System.out.print(a[i] + " ");
        }

        System.out.println(" ");


        for (int i = 0; i < n; i++) {
            max = a[i];
            r = i;
            for (int j = i+1; j < n; j++) {
                if (a[j] >= max) {
                    max = a[j];
                    r = j;
                }
            }
            b = a[r];
            a[r] = a[i];
            a[i] = b;

        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}