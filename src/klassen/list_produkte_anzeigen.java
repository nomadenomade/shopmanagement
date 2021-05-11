package klassen;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.Map;

public class list_produkte_anzeigen {
    private List<Produkt> List_produkte;
    public list_produkte_anzeigen(){

    }
    public list_produkte_anzeigen(List<Produkt> list_produkt){
        this.List_produkte = list_produkt;
    }
    public List<Produkt> list_produkte_anzeige(ScrollPane scrollpane, String suchbegriff, String type, String suchmittel, Map<String,String> map){
        DAO dao = new DAO();
        List<Produkt> list_produkte =null ;
        if(suchmittel.equals("string")){
            list_produkte= dao.Produkt_suche(suchbegriff,type);
        }else if(suchmittel.equals("map")){
            list_produkte = dao.such_produkt_fuer_bestand_änderung(map);
        }else if(suchmittel.equals("list")){
            list_produkte = List_produkte;
        }

        TableView<Produkt> table_info = new TableView<>();
        for (Produkt p: list_produkte) {
            table_info.getItems().add(p);
        }
        TableColumn<Produkt,String> colid = new TableColumn<>("idProdukt");
        TableColumn<Produkt,String> colname = new TableColumn<>("Name");
        TableColumn<Produkt,String> colmarke = new TableColumn<>("Marke");
        TableColumn<Produkt,String> colpreis = new TableColumn<>("Preis");
        TableColumn<Produkt,String> colmenge = new TableColumn<>("Menge");
        TableColumn<Produkt,String> colbeschreibung = new TableColumn<>("Beschreibung");
        TableColumn<Produkt,String> colcategorie = new TableColumn<>("Categorie");
        TableColumn<Produkt,String> colgewicht = new TableColumn<>("Gewicht");
        TableColumn<Produkt,String> coldate = new TableColumn<>("Registrierung am");

        colid.setCellValueFactory(new Mycallback_table_produkt("idprodukt"));
        colname.setCellValueFactory(new Mycallback_table_produkt("name"));
        colmarke.setCellValueFactory(new Mycallback_table_produkt("marke"));
        colpreis.setCellValueFactory(new Mycallback_table_produkt("preis"));
        colmenge.setCellValueFactory(new Mycallback_table_produkt("menge"));
        colbeschreibung.setCellValueFactory(new Mycallback_table_produkt("beschreibung"));
        colcategorie.setCellValueFactory(new Mycallback_table_produkt("categorie"));
        colgewicht.setCellValueFactory(new Mycallback_table_produkt("gewicht"));
        coldate.setCellValueFactory(new Mycallback_table_produkt("date"));


        table_info.getColumns().addAll(colid,colname,colmarke,colpreis,colmenge,colbeschreibung,colcategorie,colgewicht,coldate);
        scrollpane.setContent(table_info);
        return  list_produkte;
    }

}
