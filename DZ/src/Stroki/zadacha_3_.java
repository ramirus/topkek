package Stroki;

import java.lang.String;
import java.util.Scanner;

import static java.lang.Integer.*;

public class zadacha_3_ {
    static Scanner sc = new Scanner(System.in);

    public static void poisk(String s) {
        int num = parseInt(s);
        boolean k = false;
        for (int i = 0; num > 0 && !k; i++) {
            int z = num % 10;
            if (z % 2 == 0 || z%3==0 ) {
                k = true;
            }
            num = num / 10;
        }
        if (k == true) {
            System.out.println("есть");
        } else {
            System.out.println("нет");
        }

    }

    public static void main(String[] args) {
        System.out.println("введите число");
        String s = sc.nextLine();
        poisk(s);
    }
}
