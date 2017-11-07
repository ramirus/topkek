package kvantori;

import java.util.Random;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int n;
        System.out.println("введите n");
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(2);
            System.out.print(a[i] + " ");
        }*/
        int []a={0,0,0,0,0,};
        System.out.println();
        boolean f = true;
        for (int i = 0; i < a.length && f; i++) {
            if (a[i] != 0) {
                f = false;
            }

        }


    }
}
