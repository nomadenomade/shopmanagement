package klassen;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class Mycallback_table_produkt implements Callback<TableColumn.CellDataFeatures<Produkt,String>, ObservableValue<String>> {
    private String spaltenname;
    private StringProperty rueckgabe=null;
    public Mycallback_table_produkt(String spaltenname){
        this.spaltenname = spaltenname;
    }

    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<Produkt, String> param) {
        if (spaltenname.equals("name")){
            rueckgabe= param.getValue().nameProperty();
        }
        if (spaltenname.equals("marke")){
            rueckgabe= param.getValue().markeProperty();
        }
        if (spaltenname.equals("preis")){
            rueckgabe= param.getValue().preisProperty();
        }
        if (spaltenname.equals("menge")){
            rueckgabe= param.getValue().mengeProperty();
        }
        if (spaltenname.equals("beschreibung")){
            rueckgabe= param.getValue().beschreibungProperty();
        }
        if (spaltenname.equals("categorie")){
            rueckgabe= param.getValue().categoriesProperty();
        }
        if (spaltenname.equals("gewicht")){
            rueckgabe= param.getValue().gewichtProperty();
        }
        if (spaltenname.equals("date")){
            rueckgabe= param.getValue().datumProperty();
        }if (spaltenname.equals("idprodukt")){
            rueckgabe = param.getValue().idProduktProperty();
        }


        return rueckgabe;
    }
}
