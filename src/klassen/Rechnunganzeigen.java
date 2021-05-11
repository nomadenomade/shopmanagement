package klassen;


import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class Rechnunganzeigen {

    public void anzeige(ScrollPane scrollPane, List<Rechnung> rechnungList){

        TableView<Rechnung> rechnungTableView = new TableView<>();
        for (Rechnung rechnung: rechnungList) {
            rechnungTableView.getItems().add(rechnung);
        }
        TableColumn<Rechnung,String> col1 = new TableColumn<>("idRechnung");
        TableColumn<Rechnung,String> col2 = new TableColumn<>("Rechnungsnummer");
        TableColumn<Rechnung,String> col3 = new TableColumn<>("Gesamtmenge");
        TableColumn<Rechnung,String> col4 = new TableColumn<>("Gesamtpreis");
        TableColumn<Rechnung,String> col5 = new TableColumn<>("Datum");

        col1.setCellValueFactory(new callback_function_fuer_rechnung_anzeige("idRechnung"));
        col2.setCellValueFactory(new callback_function_fuer_rechnung_anzeige("Rechnungsnummer"));
        col3.setCellValueFactory(new callback_function_fuer_rechnung_anzeige("Gesamtmenge"));
        col4.setCellValueFactory(new callback_function_fuer_rechnung_anzeige("Gesamtpreis"));
        col5.setCellValueFactory(new callback_function_fuer_rechnung_anzeige("Datum"));



        rechnungTableView.getColumns().addAll(col1,col2,col3,col4,col5);
        rechnungTableView.setMinWidth(700);
       
        scrollPane.setContent(rechnungTableView);


    }
}
