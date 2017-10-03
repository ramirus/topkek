import java.util.Scanner;
// 10 в
public class D {
    public static int power(double a, double b){
        int result = 1;
        int temp = (int)b;
        for(int i=temp; i>0; i--){
            result *= a;
        }
        return result;}

    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int n;
        double k=1, x, t=1, m=1;
        double S=0 ;
        System.out.println("Введите n");
        n=sc.nextInt();
        System.out.println("Введите х");
        x=sc.nextInt();
        for(k=1; k <=n; k++) {
            t=1;
            m=1;
            int temp=(int)k*2;
            for(int temp1=2;temp1<=temp;temp1+=2){t*=temp1; System.out.println("t" +t); }
            for(temp=1;temp<=2*k-1;temp+=2) {m*=temp; System.out.println("m" +m);}

            S=S+(power( x , 2*k)*m)/t;
            System.out.println("S" +S);


        }
        System.out.println(S);
    }

}
