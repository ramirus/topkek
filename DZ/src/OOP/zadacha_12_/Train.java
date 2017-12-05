package OOP.zadacha_12_;

public class Train extends Transport {
    public Train(int time, int price) {
        super( time,price);
        System.out.println("цена поездки на поезде " + price);
        System.out.println("время поездки на поезде" + time);
    }
}
