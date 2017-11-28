package muzInstrumenti;

public class Baraban extends MuzIns {
    public Baraban(String nazv, String zvuk, int place, int price) {
        super(nazv, zvuk, place, price);

        this.zvuk = "Бада-бум-тссс";
        this.price = 13410;
        this.nazv = "Барабан";
        this.place = 2;
    }
}
