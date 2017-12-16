package avtomat;

import java.lang.String;

public class be {
    public static boolean Slovo(String text) {
        int i = 0;
        char array[] = text.toCharArray();
        int state = 0;
        int[][] m = {{1, 4, 4},
                {4, 2, 4},
                {4, 2, 3},
                {4, 4, 4},
                {4, 4, 4}};
        boolean f = true;
        int l = text.length();
        if (l < 3) {
            System.out.println("плохо");
        }
        while (i < l && f) {
            int t = array[i] - '0';
            state = m[state][t];
            i++;
            if (state == 4) {
                f = false;
            }
        }
        if (state == 3) {
            System.out.println("все норм");
        }
        return f;
    }

    public static void main(String[] args) {
        String words[] = {"0112", "0", "", "0111112", "01", "3"};
        for (int i = 0; i < words.length; i++) {
            Slovo(words[i]);
        }
    }
}

