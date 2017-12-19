package avtomat;//-

import java.lang.String;
public class zadacha_1_ {
    public static boolean Srav(String text){
        int i = 0;
        char array[] = text.toCharArray();
        int state = 0;
        boolean f = true;
        int l = text.length();
        if (l < 2) {
            System.out.println("не принимается");
        }
        while (f) {
            switch (state) {
                case 0:
                    if (array[i] == 0 || array[i]==1) {
                        i++;
                    state++;}
                    break;
                case 1:
                    if(array[i-1]==1 && array[i]==0){
                        System.out.println("принимается");
                    }
                    else{
                        i++;
                        state++;
                    }
                case 2:
            }
        }
        return f;
    }

    public static void main(String[] args) {
     String m[]={"1001001","101001","1111001","00","01","111"};
     for(int i=0; i<m.length;i++){
         Srav(m[i]);
         System.out.println(" ");
     }
    }
}
