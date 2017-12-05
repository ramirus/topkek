package Stroki;

import java.util.Scanner;
import java.lang.String;

public class zadacha_50 {
    public static void main(String[] args) {
        String s1;
        String s2;
        Scanner sc=new Scanner(System.in);
        s1=sc.nextLine();
        s2=sc.nextLine();
        boolean f=false;
        if(s1.length()==s2.length() && s1.equals(s2)){
            f=true;
            System.out.println(f);
        }
        else System.out.println(f);
    }
}
