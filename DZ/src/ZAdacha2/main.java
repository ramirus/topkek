package ZAdacha2;

import java.io.BufferedReader;
import java.io.FileReader;

public class main {
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new FileReader("input.txt"));
        int count = Integer.parseInt(read.readLine());
        int sumScore=0;
        circle circles[] = new circle[count];
        for (int i = 0; i < count; i++) {
            String radiusWithPoint[] = read.readLine().split(" ");
            int radius = Integer.parseInt(radiusWithPoint[0]);
            int score = Integer.parseInt(radiusWithPoint[1]);
            circle circle = new circle(radius, score);
            circles[i] = circle;
            sumScore+=score;
        }
        int countOfShoots = Integer.parseInt(read.readLine());
        System.out.println(sumScore);
    }

}