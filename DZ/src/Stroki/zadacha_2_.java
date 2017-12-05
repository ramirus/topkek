package Stroki;

import java.util.Scanner;
import java.lang.String;

import static java.lang.Integer.*;

public class zadacha_2_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("введите n");
        int n = sc.nextInt();
        String s = sc.nextLine();
        String []str= s.split(" ");
        int[] a = new int[n];
        int min = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println("минимум=" + min);
    }
}
