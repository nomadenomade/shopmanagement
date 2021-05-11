package klassen;

public class Warenkob {
    private String Rechnungsnummer;
    private String Menge;
    private String Gesamtpreis;
    private String Datum;
    public Warenkob(){

    }

    public String getRechnungsnummer(){
        return Rechnungsnummer;
    }

    public String getMenge() {
        return Menge;
    }
    public String getGesamtpreis() {
        return Gesamtpreis;
    }
    public String getDatum() {
        return Datum;
    }
    public void setGesamtpreis(String gesamtpreis) {
        Gesamtpreis = gesamtpreis;
    }



    public void setDatum(String datum) {
        Datum = datum;
    }

    public void setMenge(String menge) {
        Menge = menge;
    }

    public void setRechnungsnummer(String rechnungsnummer) {
        Rechnungsnummer = rechnungsnummer;
    }


}
