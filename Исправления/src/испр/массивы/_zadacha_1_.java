package испр.массивы;//-

import java.util.Random;
import java.util.Scanner;

public class _zadacha_1_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int n, k = 0, c;
        System.out.println("введите n");
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n ; i++) {
            a[i] = r.nextInt(10);
            System.out.print(a[i]+" ");
        }
        System.out.println(" ");
        c = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] < c) {
                c = a[i];
                k=0;
            }
            if (c == a[i]) {
                k++;
            }
        }
        System.out.println(k);
    }
}
