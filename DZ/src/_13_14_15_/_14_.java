package _13_14_15_;
import java.util.Scanner;
public class _14_ {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n,  k=0;
        System.out.println("введите число");
        n=sc.nextInt();
        while(n!=0){
            n=n/10;
            k++;
        }
        System.out.println(k);
    }
}
