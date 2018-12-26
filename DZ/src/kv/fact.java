package kv;

import java.util.Scanner;
import java.util.Arrays;

public class fact {
    public static int fact(int x) {
        if (x <= 1) {
            return 1;
        }
        return x * fact(x - 1);
    }

    public static int[] Array(int n) {
        int count = 0;
        int result[] = new int[10];
        while (n != 0) {
            result[count] = n % 10;
            n = n / 10;
            count++;
        }
        int copy[] = new int[count];
        for (int i = 0; i < count; i++) {
            copy[i] = result[i];
        }
        return copy;
    }

    public static void reverse(int array[]) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;

        }
    }

    public static int countOfNumber(int number[]) {
        int result = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                if (number[i] < number[j]) {
                    result = result + fact(number.length - 1 - i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 4627;
        int numberAsArray[] = Array(n);
        reverse(numberAsArray);
        int result = countOfNumber(numberAsArray);
        System.out.println(result);
    }
}