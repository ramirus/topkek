package OOP.zadacha_12_;

public class Auto extends  Transport{
    public Auto(int time, int price) {
        super(time, price);
        System.out.println("время поездки на машине "+time);
        System.out.println("цена поездки на машине "+price);
    }
}
