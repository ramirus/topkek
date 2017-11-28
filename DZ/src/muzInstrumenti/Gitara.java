package muzInstrumenti;

public class Gitara extends MuzIns {
    public Gitara(String nazv, String zvuk, int place, int price) {
        super(nazv, zvuk, place, price);
        this.zvuk = "Трууунь";
        this.price = 8000;
        this.nazv = "Гитара";
        this.place=1;
    }
}



