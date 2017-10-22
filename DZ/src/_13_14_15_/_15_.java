package _13_14_15_;
import java.util.Scanner;
public class _15_ {
    public static void main (String[]args){
        Scanner sc=new Scanner(System.in);
        int n,k=0;
        System.out.println("введите n");
        n=sc.nextInt();
        while(n!=0){
            if(((n%10)%2)==1){
               k=n%10;
                System.out.print(k);
                n=n/10;
            }
            else {
                n=n/10;

            }
        }

    }

}
