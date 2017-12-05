package OOP.zadacha_12_;

public class Plane extends Transport {
    public Plane(int time, int price) {
        super(time,price);
        System.out.println("время полета "+time);
        System.out.println("цена полета "+price);
    }
}
