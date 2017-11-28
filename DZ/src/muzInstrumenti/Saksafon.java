package muzInstrumenti;

public class Saksafon extends MuzIns {
    public Saksafon(String nazv, String zvuk, int place, int price) {
        super(nazv, zvuk, place, price);
        this.zvuk = "*Звук саксафона*";
        this.price = 27133;
        this.nazv = "Саксафон";
        this.place=3;
    }
}
