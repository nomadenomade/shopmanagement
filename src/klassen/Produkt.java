package klassen;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produkt implements Cloneable{
    private StringProperty idProdukt;
    private StringProperty Name ;
    private StringProperty Marke;
    private StringProperty Preis;
    private StringProperty Menge;
    private StringProperty Beschreibung;
    private  StringProperty Categories;
    private StringProperty Datum;
    private StringProperty Gewicht;
    private StringProperty link;
    public Produkt(){
        idProdukt = new SimpleStringProperty("");
        Name = new SimpleStringProperty("");
        Marke = new SimpleStringProperty("");
        Preis = new SimpleStringProperty("");
        Menge = new SimpleStringProperty("");
        Beschreibung = new SimpleStringProperty("");
        Categories = new SimpleStringProperty("");
        Datum= new SimpleStringProperty("");
        Gewicht = new SimpleStringProperty("");
        link = new SimpleStringProperty("");

    }
    //getter fuer property
    public StringProperty nameProperty() {
        return Name;
    }

    public StringProperty markeProperty() {
        return Marke;
    }

    public StringProperty preisProperty() {
        return Preis;
    }

    public StringProperty beschreibungProperty() {
        return Beschreibung;
    }

    public StringProperty categoriesProperty() {
        return Categories;
    }

    public StringProperty gewichtProperty() {
        return Gewicht;
    }

    public StringProperty datumProperty() {
        return Datum;
    }

    public StringProperty linkProperty() {
        return link;
    }

    public String getLink(){
        return link.get();
    }

    public void setLink(String link) {
        this.link.set(link);
    }

    public StringProperty idProduktProperty() {
        return idProdukt;
    }
    public StringProperty mengeProperty(){
        return Menge;
    }

    //getter und setter fuer werte
    public String getIdProdukt (){
        return  idProdukt.get();
    }

    public String getName() {
        return Name.get();
    }

    public String getMarke() {
        return Marke.get();
    }

    public String getPreis() {
        return Preis.get();
    }

    public String getMenge() {
        return Menge.get();
    }

    public String getBeschreibung() {
        return Beschreibung.get();
    }

    public String getCategories() {
        return Categories.get();
    }

    public String getDatum() {
        return Datum.get();
    }

    public String getGewicht() {
        return Gewicht.get();
    }

    public void setName(String name) {
        Name.set(name);
    }

    public void setBeschreibung(String beschreibung) {
        Beschreibung.set(beschreibung);
    }

    public void setCategories(String categories) {
        Categories.set(categories);
    }

    public void setMarke(String marke) {
        Marke.set(marke);
    }

    public void setMenge(String menge) {
        Menge.set(menge);
    }

    public void setPreis(String preis) {
        Preis.set(preis);
    }

    public void setDatum(String datum) {
        Datum.set(datum);
    }

    public void setGewicht(String gewicht) {
        Gewicht.set(gewicht);
    }

    public void setIdProdukt(String idprodukt) {
        this.idProdukt.set(idprodukt);
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
