package com.example.chet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int k = sc.nextInt();
            System.out.println(k);
            sum+=k;
        }
        System.out.println(sum);
    }
}
