package DOMAWKA;

import java.lang.String;
import java.util.Arrays;
import java.util.Scanner;

public class Dr {


    public static int[] summ(String s1, String s2) {
        int bigLength;
        int shortLength;
        if (s1.length() > s2.length()) {
            shortLength = s2.length();
            bigLength = s1.length();
        } else {
            shortLength = s1.length();
            bigLength = s2.length();
        }
        int[] int1 = new int[bigLength];
        int[] int2 = new int[shortLength];
        int[] res = new int[bigLength + 1];
        int i;
        for (i = 0; i < shortLength; i++) {
            int1[i] = Integer.parseInt(String.valueOf(s1.charAt(i)));
            int2[i] = Integer.parseInt(String.valueOf(s2.charAt(i)));
        }
        if (int1[0] + int2[0] >= 9 && int1[1] + int2[1] >= 10 || int1[1] + int2[1] >= 10) {
            res[0] = 1;
            res[1] = (int1[1] + int2[1]) % 10;
        }
        int count;
        for (i = res.length - 2; i >= 0; i--) {
            count = int1[i] + int2[i];
            if (count > 9) {
                res[i] = count % 10;
                res[i - 1] = +1;
            }
            if (count < 10) {
                res[i] = count;
            }
        }
        for (i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstNumber = sc.nextLine();
        String secondNumber = sc.nextLine();
        summ(firstNumber, secondNumber);
    }
}

