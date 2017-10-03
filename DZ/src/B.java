import java.util.Scanner;
// 10 б
public class B {
    public static int power(int a, int b){
        int result = 1;
        for(int i=b; i>0; i--){
            result *= a;
        }
        return result;}

    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int k=0, n, p=1,x, t=1;
        double S=0 ;
        System.out.println("Введите n");
        n=sc.nextInt();
        System.out.println("Введите x");
        x=sc.nextInt();
        for(k=0; k <=n; k++) {

            for(k= 2; k<=n; k++){t*=(2*k);}
            S = S + ((-1)*p*power(x,4*k+1))/(t*(4*k+1));
            p=-p;
         // те же замечания
        }
        System.out.println(S);
    }

}
