package kv;

public class kk {
    public static int compare(char a[], char b[]) {
        int leng = 0;
        if (a.length <= b.length) {
            leng = a.length;
        } else {
            leng = b.length;
        }
        int k = 0;
        for (int i = 0; i < leng; i++) {
            if (a[i] == b[i]) {
                k++;
            }
        }
        for (int i = 0; i < leng; i++) {
            if (a[i] > b[i]) {
                return 1;
            }
        }
        for(int i=0; i<leng; i++){
            if(a[i]<b[i]){
                return -1;
            }
        }
        if (k == leng) {
            return 0;
        }
        return 2;
    }

    public static void main(String[] args) {
        char[] a = new char[]{'М', 'a', 'р', 'с', 'е', 'л', 'ь'};
        char[] b = new char[]{'М', 'а', 'р', 'и', 'н', 'а'};
        System.out.println(compare(a, b));
    }
}
