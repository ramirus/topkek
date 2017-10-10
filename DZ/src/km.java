import java.util.Scanner; // 12 A
public class km {
    public  static void main(String[]args){
        Scanner sc= new Scanner(System.in);
         int  n=1, l=1;
         double G=0,x, t=1, m=1;
         double ep=0.0001;
         System.out.println("Введите x");
         x=sc.nextInt();
         while(Math.abs(t)>ep){
                G+=t;
                t*=x/n;
                n++;
         }
         System.out.println(G);
    }
}
