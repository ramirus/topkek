package DOMAWKA;

import java.util.Scanner;

public class lexSort {
    public static String[] Sort(String str[]) {
        for (int i = 1; i < str.length; i++) {
            String rep = str[i];
            int j = i - 1;
            while (j >= 0 && (rep.compareTo(str[j]) < 0)) {
                str[j + 1] = str[j];
                j--;
            }
            str[j + 1] = rep;
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        return str;
    }

    public static void main(String[] args) {
        String[] str = new String[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("введите слова");
        for (int i = 0; i < str.length; i++) {
            str[i] = sc.nextLine();
        }
        Sort(str);
    }
}