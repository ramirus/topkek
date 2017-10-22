package _13_14_15_;
import java.util.Scanner;
public class _13_ {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int n, p=1, k, S=0;
        System.out.println("введите число");
        n=sc.nextInt();
        while(n!=0){
            k=n%10;
            S=S+p*k;
            p=-p;
            n=n/10;
            System.out.println(n);
        }
    System.out.println(S);
    }
}
