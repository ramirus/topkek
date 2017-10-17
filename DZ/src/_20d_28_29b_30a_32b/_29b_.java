package _20d_28_29b_30a_32b;


public class _29b_ {
    public static void main(String[]args){
        int n=1;
        double x=1, x0=0, ep=0.0001;
        while(Math.abs(x-x0)>=ep){
            x=x0;
            x0=Math.cos(x);
            n++;
        }
        System.out.println(n);
    }
}
