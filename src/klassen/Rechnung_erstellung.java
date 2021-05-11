package klassen;

import java.util.List;
import java.util.Random;

public class Rechnung_erstellung {
    private List<Produkt> list_produkt;
    private Rechnung rechnung;

    public Rechnung_erstellung(List<Produkt> list_produkte){
        this.list_produkt = list_produkte;

    }

    public void Rechnungserstellung(){
        String Rechnungsnummer =String.valueOf(new Random().nextInt(1000000000));
        double Gesampreis=0;
        int Anzahl_produkt=0;
        for (Produkt produkte :list_produkt){
            Anzahl_produkt++;
            Gesampreis = Gesampreis + Double.valueOf(produkte.getPreis());
        }
        rechnung = new Rechnung();
        rechnung.setGesamtmenge(String.valueOf(Anzahl_produkt));
        rechnung.setRechnungsnummer(Rechnungsnummer);
        rechnung.setGesamtpreis(String.valueOf(Gesampreis));




    }

    public Rechnung getRechnung(){
        return rechnung;
    }

    public List<Produkt> getList_produkt() {
        return list_produkt;
    }
}
