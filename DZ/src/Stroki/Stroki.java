package Stroki;

import java.io.IOException;
import java.lang.String;
import  java.io.File;
import java.util.Scanner;
public class Stroki {
    public static void main(String[] args) throws IOException {
       /* String s1 = "xyz";
        String s2 = "xyz";
        String s3 = new String("xyz");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(" ");

        char[] charArrays = {'a', 'b', 'c'};
        String string=new String(charArrays);
        System.out.println(string);
        System.out.println(" ");

        String zero= "\u0000\u0000";
        String hello= "Hello";
        String specialChars="\r\n\t\\";
        String unicode= "\u0101\u0234\u03ff";
        System.out.println(zero);
        System.out.println(hello);
        System.out.println(specialChars);
        System.out.println(unicode);

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));

        System.out.println(s1.compareTo(s2));




        String  str="Gaoasd asdasda...";
        System.out.println(str.length());
        System.out.println(str.charAt(4));
        System.out.println(str.contains("..."));
        System.out.println(str.substring(3,8));
        System.out.println(str.toUpperCase());
        System.out.println(str.toCharArray()[4]);


        String helloWorld="hello"+"World";
        System.out.println(helloWorld);

       String  s= new String("ssssss");
        System.out.println(s);
        s.concat("-aaa");
        String a=s.concat("-aaa");

        System.out.println(s);
        System.out.println(a);

       String s="lesson";
       for(int i=1; i<=s.length();i++){
           System.out.print(s.charAt(s.length()-i));
       }
       */
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        System.out.println(t);

        try {
            Scanner sco = new Scanner(new File("file.txt"));
            while (sco.hasNext()) {
                String p = sco.next();
                System.out.println(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
