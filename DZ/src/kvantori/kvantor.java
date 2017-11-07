package kvantori;
//22 г

import java.util.Scanner;
import java.util.Random;

public class kvantor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int n;
        System.out.println("введите n");
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(40);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        boolean f = false;
        for (int i = 0; i < a.length / 2 && !f; i++) {
            for (int j = 0; j < a.length && !f; j++) {
                if (a[i] == a[j] && i != j) {
                    f = true;
                }
            }
        }
        if (f) {
            System.out.println("есть");
        } else {
            System.out.println("нет");
        }
    }
}
