package klassen;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class callback_function_fuer_rechnung_anzeige implements Callback<TableColumn.CellDataFeatures<Rechnung,String>, ObservableValue<String>> {
           String spaltename;
            public callback_function_fuer_rechnung_anzeige(String spaltename){
                this.spaltename = spaltename;
            }

    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<Rechnung, String> param) {
                if(spaltename.equals("idRechnung")){
                    return param.getValue().idRechnung;
                }else if(spaltename.equals("Rechnungsnummer")){
                    return param.getValue().Rechnungsnummer;
                }else if(spaltename.equals("Gesamtpreis")){
                    return param.getValue().Gesamtpreis;
                }else if(spaltename.equals("Gesamtmenge")){
                    return  param.getValue().Gesamtmenge;
                }else if(spaltename.equals("Datum")){
                    return param.getValue().Date;
                }
        return null;
    }
}
