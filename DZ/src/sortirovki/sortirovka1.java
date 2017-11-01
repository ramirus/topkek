package sortirovki;

import java.util.Random;
import java.util.Scanner;

public class sortirovka1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int n, c;
        n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<a.length; i++){
            a[i]=r.nextInt(10);
            System.out.print(a[i]+" ");
        }

        System.out.println(" ");
        for (int i = 0; i < a.length; i++) {
            for (int k = i + 1; k < a.length; k++) {
                if (a[i] < a[k]) {
                    c = a[i];
                    a[i] = a[k];
                    a[k] = c;
                }
            }
            System.out.print(a[i]);
        }
    }
}
