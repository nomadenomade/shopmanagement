package klassen;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Rechnung {
    StringProperty idRechnung;
    StringProperty Rechnungsnummer;
    StringProperty Gesamtpreis;
    StringProperty Gesamtmenge;
    StringProperty Date;
    public Rechnung(){
        idRechnung = new SimpleStringProperty();
        Rechnungsnummer = new SimpleStringProperty();
        Gesamtpreis = new SimpleStringProperty();
        Gesamtmenge= new SimpleStringProperty();
        Date = new SimpleStringProperty();
        Date.set(new Date().toString());
    }

    public StringProperty gesamtmengeProperty() {
        return Gesamtmenge;
    }

    public StringProperty dateProperty() {
        return Date;
    }

    public StringProperty gesamtpreisProperty() {
        return Gesamtpreis;
    }

    public StringProperty idRechnungProperty() {
        return idRechnung;
    }

    public StringProperty rechnungsnummerProperty() {
        return Rechnungsnummer;
    }

    public String getGesamtmenge() {
        return Gesamtmenge.get();
    }

    public void setDate(String date) {
        this.Date.set(date);
    }

    public String getDate() {
        return Date.get();
    }

    public String getRechnungsnummer() {
        return Rechnungsnummer.get();
    }

    public String getGesamtpreis() {
        return Gesamtpreis.get();
    }

    public String getIdRechnung() {
        return idRechnung.get();
    }

    public void setRechnungsnummer(String rechnungsnummer) {
        this.Rechnungsnummer.set(rechnungsnummer);
    }

    public void setGesamtpreis(String gesamtpreis) {
        this.Gesamtpreis.set(gesamtpreis);
    }

    public void setIdRechnung(String idRechnung) {
        this.idRechnung.set(idRechnung);
    }

    public void setGesamtmenge(String gesamtmenge) {
        this.Gesamtmenge.set(gesamtmenge);
    }

}
