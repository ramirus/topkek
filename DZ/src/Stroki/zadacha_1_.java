package Stroki;

import java.util.Scanner;
import java.lang.String;
import static java.lang.Integer.*;

public class zadacha_1_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int num = parseInt(s);
        int max = 0;
        for (int i = 0; num > 0; i++) {
            if (max < num % 10) {
                max = num % 10;
            }
            num = num / 10;
        }
        System.out.println(" Максимум=" + max);
    }
}
