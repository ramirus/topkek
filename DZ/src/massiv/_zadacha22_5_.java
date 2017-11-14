package massiv;//+-
import java.util.Scanner;
import java.util.Random;
public class _zadacha22_5_ {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        Random ran=new Random();
        int n,t=0;
        System.out.println("введите n");
        n=sc.nextInt();
        int []a=new int[n];
        for(int i=0; i<a.length; i++){
            a[i]=ran.nextInt(20);
            System.out.print(a[i]+" ");
        }
        boolean l;
        for(int i=0; i<a.length; i++){  //плохо, что циклы не зависят от булевской переменной
            l=true;
            for(int j=0; j<a.length; j++){//плохо, что циклы не зависят от булевской переменной
                if(a[i]==a[j]&&i!=j){
                    l=false;
                }
            }
            if(l==true){   //  if(l)
                t++;
            }
        }
        System.out.println(" ");
        System.out.println(t);
    }
}
