package OOP.zadacha_12_;//-
// задача 12 ,   пассажир-перевозчик

import java.lang.String;
import java.util.Scanner;

public class Transport {   //very strange configuration
    private int time;
    private int price;

    public Transport() {
        int price = 0;
        int time = 0;
    }

    public void setPlane() {
    }

    public void setAuto() {
    }

    public void setTrain() {
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice(int price) {
        return price;
    }

    public int getTime(int time) {
        return time;
    }

    public Transport(int time, int price) {
        this.price = price;
        this.time = time;
    }


    public static void main(String[] args) {
        Plane plane = new Plane(5, 13500);
        Auto auto = new Auto(12, 6700);
        Train train = new Train(7, 9823);
    }
}
