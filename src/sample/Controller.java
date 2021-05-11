package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import javafx.util.StringConverter;
import klassen.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;


public class Controller {

    @FXML
    private StackPane produkt_auf_pane;

    @FXML
    private StackPane produkt_reg_pane;

    @FXML
    private TextField name;

    @FXML
    private TextField marke;

    @FXML
    private TextField preis;

    @FXML
    private TextField menge;

    @FXML
    private ChoiceBox categorie;

    @FXML
    private TextArea beschreibung;

    @FXML
    private TextField gewicht;

    @FXML
    private Button reg_button;

    @FXML
    private TextField db_such_feld;

    @FXML
    private ScrollPane db_scroll_pane;

    @FXML
    private Label produktbildsname;
    @FXML
    private MenuItem leere_bestaende;
    @FXML
    private MenuItem alle_produkte;


    @FXML
    private TextField name_bestand_ändern;

    @FXML
    private TextField marke_bestand_ändern;

    @FXML
    private TextField preis_bestand_ändern;

    @FXML
    private Button bestand_ändern_such_button;

    @FXML
    private ScrollPane bestand_ändern_scrollpane;
    @FXML
    private Button bestand_ändern_button;
    @FXML
    private MenuButton neubestand_auswahl;


    @FXML
    private MenuItem bestand_genug;

    @FXML
    private MenuItem bestand_leer;

    @FXML
    private TextField neubestand;
    private List<Produkt> list;

    @FXML
    private RadioButton produck_löschen_wahl;

    @FXML
    private RadioButton bestand_auffüllen_wahl;



    @FXML
    private TextField vorname_person;

    @FXML
    private TextField telephone_person;

    @FXML
    private TextField nachname_person;

    @FXML
    private TextField passwort_person;

    @FXML
    private TextField email_person;

    @FXML
    private MenuItem reg_person_menuitem1;

    @FXML
    private MenuItem reg_person_menuitem2;

    @FXML
    private Label auswahl_reg_person_label;
    @FXML
    private StackPane produkt_verwaltung_stackpane;



    @FXML
    private ScrollPane verkauf_produkt_scrollpane;

    @FXML
    private TextField verkauf_produkt_name;

    @FXML
    private TextField verkauf_produkt_preis;

    @FXML
    private TextField verkauf_produkt_marke;

    @FXML
    private RadioButton verkauf_zählbar;

    @FXML
    private RadioButton verkauf_unzählbar;
    @FXML
    private TextField verkauf_produkt_menge;

    @FXML
    private Button verkauf_hinzufugen_button;
    @FXML
    private Pane verkauf_pane;
    @FXML
    private Label verkauf_menge_auswählen_info;
    @FXML
    private ImageView verkauf_imageview_produkt;

    @FXML
    private ScrollPane verkauf_scrollpane_rollback;

    @FXML
    private ScrollPane bestellung_ende_scrollpane1;

    @FXML
    private ScrollPane bestellung_ende_scrollpane2;
    @FXML
    private Button bestellung_drucken_button;
    @FXML
    private Button verkauf_rollback_button;



    @FXML
    private TextField homepage_email;

    @FXML
    private TextField homepage_passwort;

    @FXML
    private Label homepage_fehlermeldung_label;

    @FXML
    private StackPane registrierung_stackpane;
    @FXML
    private StackPane verkaufboard_stackpane;
    @FXML
    private StackPane homepage_stackpane;

    @FXML
    private Label verkauf_name_mitarbeiter_label;
    @FXML
    private Label verkauf_funktion_mitarbeiter_label;
    @FXML
    private Pane Pane_bestand_ändern;
    @FXML
    private StackPane statistik_stackpane;

    @FXML
    private DatePicker statistik_datenpicker_verkaufe;

    @FXML
    private Pane statistik_pane1;
    @FXML
    private Button statistik_zur_Pverwaltung;



    @FXML
    void db_such_function(KeyEvent event) {

         new list_produkte_anzeigen().list_produkte_anzeige(db_scroll_pane,db_such_feld.getText(),"allgemeinesuche","string",null);

    }
    @FXML
    void db_such_function_pressed(KeyEvent event){
    }

    @FXML
    void produckt_registieren(ActionEvent event) {
        produkt_reg_pane.toFront();
    }

    private String bildpfad;
    private String Auswahl;
    private Map<String,String> angaben_stock_ändern = new HashMap<>();
    private String bestand_genug_oder_leer;
    private String reg_person_function_option;
    private String verkauf_produkt_zählbar_oder_unzählbar;
    private List <Produkt> warenkob = new ArrayList<>();
    private Rechnung_erstellung rechnung_erstellung;
    private ListView<String> rollback_list;
    List<Produkt> zwischen_list;
    private Mitarbeiter mitarbeiter=null;
    private Map<String, Object> maprodukt ;

    @FXML
    void produckt_speichern(ActionEvent event) {
    //Produkterstellung
        Produkt produkt = new Produkt();
        produkt.setName(name.getText());
        produkt.setDatum(String.valueOf(new Date()));
        produkt.setMarke(marke.getText());
        produkt.setPreis(preis.getText());
        produkt.setMenge(menge.getText());
        produkt.setBeschreibung(beschreibung.getText());
        produkt.setCategories(Auswahl);
        produkt.setGewicht(gewicht.getText());
    //bilderstellung
        Bild bild = new Bild(produkt,bildpfad);


        Person p = new Person();
        p.setNachname("Guewou");
        p.setVorname("Blaise");
        p.setEmail("blaise@gmail.com");
        p.setTelephone("12344566");
        p.setPasswort("nomadeguewou");
        p.setDatum(String.valueOf(new Date()));
        p.setIdPerson("1");

        DAO dao = new DAO();
        String ruekgabe = dao.Produktregistrierung(p,produkt,bild);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Produktregistrierung");
        alert.setContentText(ruekgabe);
        alert.show();



    }


    @FXML
    void stock_auffüllen(ActionEvent event) {
        produkt_auf_pane.toFront();
    }

    @FXML
    void bild_function(ActionEvent event){
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(null);
        bildpfad = f.getAbsolutePath();
        produktbildsname.setText(f.getName());

    }

    @FXML
    void nahrung_auswahl(ActionEvent event) {

        Auswahl="Nahrung";
    }
    @FXML
    void gegenstand_auswahl(ActionEvent event) {
        Auswahl= "Gegenstand";
    }

    @FXML
    void leere_bestaende(ActionEvent event){
        new list_produkte_anzeigen().list_produkte_anzeige(db_scroll_pane,leere_bestaende.getText(),"leerebestaende","string",null);

    }
    @FXML
    void alle_produkte(ActionEvent event){
        new list_produkte_anzeigen().list_produkte_anzeige(db_scroll_pane,alle_produkte.getText(),"alleprodukte","string",null);
    }

    @FXML
    void bestand_genug(ActionEvent event) {
        bestand_genug_oder_leer = bestand_genug.getText();
    }

    @FXML
    void bestand_leer(ActionEvent event) {
        bestand_genug_oder_leer= bestand_leer.getText();
    }

    @FXML
    void bestand_ändern_button(ActionEvent event) {
        DAO dao = new DAO();
        String ruekgabe="";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bestätigung");
        if (bestand_auffüllen_wahl.isSelected()){
            if(bestand_genug_oder_leer==null){
                ruekgabe= dao.bestand_ändern(list.get(0).getIdProdukt(),neubestand.getText());
            }else{
                ruekgabe= dao.bestand_ändern(list.get(0).getIdProdukt(),bestand_genug_oder_leer);
            }


            bestand_genug_oder_leer= null;
            neubestand.setText(null);
            bestand_genug.setText(null);
            name_bestand_ändern.setText(null);
            preis_bestand_ändern.setText(null);
            marke_bestand_ändern.setText(null);
            list=null;
        }else if(produck_löschen_wahl.isSelected()){
           ruekgabe= dao.Produkte_löschen(list);
        }
        alert.setContentText(ruekgabe);
        alert.show();


    }

    @FXML
    void bestand_ändern_such_function(ActionEvent event) {

        angaben_stock_ändern.put("name",name_bestand_ändern.getText());
        angaben_stock_ändern.put("marke",marke_bestand_ändern.getText());
        angaben_stock_ändern.put("preis",preis_bestand_ändern.getText());
        list = new list_produkte_anzeigen().list_produkte_anzeige(bestand_ändern_scrollpane,null,null,"map",angaben_stock_ändern);
        if (!list.isEmpty()){
            bestand_ändern_button.disableProperty().set(false);
        }else {
            bestand_ändern_button.disableProperty().set(true);
        }


    }
    @FXML
    void neubestandzahl(KeyEvent event) {
        bestand_genug_oder_leer=null;
    }
    @FXML
    void produkt_löschen_wahl_function(ActionEvent event) {
        if (bestand_auffüllen_wahl.isSelected()){
            bestand_auffüllen_wahl.setSelected(false);

        }
        neubestand_auswahl.disableProperty().set(true);
        neubestand.disableProperty().set(true);
        bestand_ändern_such_button.disableProperty().set(false);
        if(list!=null&&!list.isEmpty()){
            bestand_ändern_button.disableProperty().set(false);
        }else {
            bestand_ändern_button.disableProperty().set(true);
        }
    }
    @FXML
    void bestand_auffüllen_wahl_function(ActionEvent event) {
        if (produck_löschen_wahl.isSelected()){
            produck_löschen_wahl.setSelected(false);

        }
        bestand_ändern_such_button.disableProperty().set(false);
        neubestand.disableProperty().set(false);
        neubestand_auswahl.disableProperty().set(false);

        if(list!=null&& !list.isEmpty()){
            bestand_ändern_button.disableProperty().set(false);
        }else {
            bestand_ändern_button.disableProperty().set(true);
        }
    }



    @FXML
    void person_registrieren_function(ActionEvent event) {
        DAO dao = new DAO();
        Person person = new Person();
        person.setNachname(nachname_person.getText());
        person.setVorname(vorname_person.getText());
        person.setEmail(email_person.getText());
        person.setTelephone(telephone_person.getText());
        person.setPasswort(passwort_person.getText());
        person.setDatum(new Date().toString());
        dao.Userspeicher(person);
        String rueckgabe =dao.Mitarbeiter_registrieren(person,reg_person_function_option);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bestätigung");
        alert.setContentText(rueckgabe);
        alert.show();
    }
    @FXML
    void reg_logistik_button_function(ActionEvent event){
        produkt_verwaltung_stackpane.toFront();
    }

    @FXML
    void reg_person_menuitem1(ActionEvent event) {
        reg_person_function_option = reg_person_menuitem1.getText();
        auswahl_reg_person_label.setText(reg_person_function_option);

    }

    @FXML
    void reg_person_menuitem2(ActionEvent event) {
        reg_person_function_option = reg_person_menuitem2.getText();
        auswahl_reg_person_label.setText(reg_person_function_option);
    }


    @FXML
    void bestellung_drucken_function(ActionEvent event) {
        DAO dao = new DAO();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bestätigung");
        alert.setContentText(dao.Rechnungerstellung(rechnung_erstellung,mitarbeiter));
        alert.show();
    }
    @FXML
    void verkauf_produkt_such_funktion(ActionEvent event) {
        Map<String,String> map = new HashMap<>();
        map.put("name",verkauf_produkt_name.getText());
        map.put("preis",verkauf_produkt_preis.getText());
        map.put("marke",verkauf_produkt_marke.getText());
        if(verkauf_imageview_produkt!=null && verkauf_imageview_produkt.getImage()!=null){
            verkauf_imageview_produkt.setImage(null);
        }

        list = new list_produkte_anzeigen().list_produkte_anzeige(verkauf_produkt_scrollpane,null,null,"map",map);

        if(!list.isEmpty()&&list.size()==1){
            verkauf_menge_auswählen_info.setText("Menge auswählen");
            verkauf_hinzufugen_button.setDisable(false);
            verkauf_produkt_menge.setDisable(false);

            try {
                if(list.get(0).getLink()!=null){
                    File file = new File(list.get(0).getLink());
                    Image image = new Image(new FileInputStream(file));
                    image.widthProperty().add(200);
                    image.heightProperty().add(200);
                    verkauf_imageview_produkt.setImage(image);

                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }else{
            verkauf_menge_auswählen_info.setText("");
            verkauf_hinzufugen_button.setDisable(true);
            verkauf_produkt_menge.setDisable(true);
        }

    }


    @FXML
    void Warenkob_hinzufügen_button_function(ActionEvent event){
        DAO dao = new DAO();
        for (Produkt p: list) {
            Produkt copy = new Produkt();
            copy.setIdProdukt(p.getIdProdukt());
            copy.setName(p.getName());
            copy.setMarke(p.getMarke());
            copy.setCategories(p.getCategories());
            copy.setGewicht(p.getGewicht());
            copy.setBeschreibung(p.getBeschreibung());
            copy.setDatum(new Date().toString());
            copy.setMenge(verkauf_produkt_menge.getText());
            copy.setPreis(String.valueOf(Double.valueOf(p.getPreis())*Double.valueOf(verkauf_produkt_menge.getText())));
            warenkob.add(copy);
        }
        new list_produkte_anzeigen(warenkob).list_produkte_anzeige(bestellung_ende_scrollpane1,null,null,"list",null);
        // rechnungerstellung
        List <Rechnung>l1 = new ArrayList<>();
        rechnung_erstellung= new Rechnung_erstellung(warenkob);
        rechnung_erstellung.Rechnungserstellung();
        l1.add(rechnung_erstellung.getRechnung());
        Rechnunganzeigen rechnunganzeigen = new Rechnunganzeigen();
        rechnunganzeigen.anzeige(bestellung_ende_scrollpane2,l1);


        rollback_list = new ListView<>();

        for(Produkt produkt: warenkob){
            rollback_list.getItems().add(produkt.getIdProdukt());
        }

        if(rollback_list.getItems()!=null){
            verkauf_rollback_button.setDisable(false);
        }else{
            verkauf_rollback_button.setDisable(true);
        }
        verkauf_scrollpane_rollback.setContent(rollback_list);
        bestellung_drucken_button.setDisable(false);
        //konflikt vermeidung
        zwischen_list = new ArrayList<>() ;
        for (Produkt produkt:warenkob) {
            try {
                zwischen_list.add((Produkt) produkt.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }


        SelectionModel<String>model = rollback_list.getSelectionModel();
        model.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {


                for (Produkt produkt: zwischen_list) {

                    if (produkt.getIdProdukt().equals(newValue)){
                        warenkob.remove(warenkob.size()-1);
                        new list_produkte_anzeigen(warenkob).list_produkte_anzeige(bestellung_ende_scrollpane1,null,null,"list",null);
                        rechnung_erstellung= new Rechnung_erstellung(warenkob);
                        rechnung_erstellung.Rechnungserstellung();
                        l1.clear();
                        l1.add(rechnung_erstellung.getRechnung());
                        Rechnunganzeigen rechnunganzeigen = new Rechnunganzeigen();
                        rechnunganzeigen.anzeige(bestellung_ende_scrollpane2,l1);



                    }
                }

                zwischen_list = new ArrayList<>() ;
                for (Produkt produkt:warenkob) {
                    try {
                        zwischen_list.add((Produkt) produkt.clone());
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        rollback_list.getItems().clear();
        for(Produkt Produkt: warenkob){
            rollback_list.getItems().add(Produkt.getIdProdukt());
        }

        if(rollback_list.getItems()!=null){
            verkauf_rollback_button.setDisable(false);
        }else{
            verkauf_rollback_button.setDisable(true);
        }
        verkauf_scrollpane_rollback.setContent(rollback_list);

    }

    @FXML
    void verkauf_rollback_function(ActionEvent event) {

    }



    @FXML
    void homepage_einloggen_button_function(ActionEvent event) {
        DAO dao = new DAO();
        mitarbeiter = dao.Mitarbeiter_suchen(homepage_email.getText(),homepage_passwort.getText(),"simple");
        if (mitarbeiter!=null && mitarbeiter.getIdMitarbeiter()!=null){
            verkaufboard_stackpane.toFront();
            verkauf_name_mitarbeiter_label.setText(mitarbeiter.getPerson_daten().getNachname());
            verkauf_funktion_mitarbeiter_label.setText(mitarbeiter.getFunktion());


        }else{
            homepage_fehlermeldung_label.setText("Sie sind kein Mitarbeiter");
            homepage_fehlermeldung_label.setTextFill(Paint.valueOf("red"));
        }


    }

    @FXML
    void homepage_produktverwaltung_function(ActionEvent event) {
        DAO dao = new DAO();
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("Passwort Administrator");
        inputDialog.setContentText("Passwort :");
        Optional<String> wert = inputDialog.showAndWait();
        mitarbeiter = dao.Mitarbeiter_suchen(null,wert.get(),"admin");
        if(mitarbeiter!=null&&wert.isPresent()&&wert.get().equals(mitarbeiter.getPerson_daten().getPasswort())&&mitarbeiter.getFunktion().equals("verkäufer_logistiker")){
            produkt_verwaltung_stackpane.toFront();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Passwort falsch");
            alert.show();
        }
    }

    @FXML
    void homepage_registrierung_button_function(ActionEvent event) {
        DAO dao = new DAO();
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("Passwort Administrator");
        inputDialog.setContentText("Passwort :");
        Optional<String> wert = inputDialog.showAndWait();
        mitarbeiter = dao.Mitarbeiter_suchen(null,wert.get(),"admin");
        if(mitarbeiter!=null&&wert.isPresent()&&wert.get().equals(mitarbeiter.getPerson_daten().getPasswort())&&mitarbeiter.getFunktion().equals("verkäufer_logistiker")){
            registrierung_stackpane.toFront();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Passwort falsch");
            alert.show();
        }
    }

    @FXML
    void verkauf_abmelden_button(ActionEvent event){
        homepage_stackpane.toFront();
        Pane_bestand_ändern.toFront();
        homepage_email.setText("");
        homepage_passwort.setText("");
        homepage_fehlermeldung_label.setText("");

    }
    @FXML
    void bestand_zur_person_rg(ActionEvent event){
        registrierung_stackpane.toFront();
        Pane_bestand_ändern.toFront();

    }
    @FXML
    void bestand_abmelden_function(ActionEvent event){
         homepage_stackpane.toFront();
         Pane_bestand_ändern.toFront();
         homepage_email.setText("");
         homepage_passwort.setText("");
         homepage_fehlermeldung_label.setText("");
    }
    @FXML
    void reg_abmelden_button_function(ActionEvent event){
        homepage_stackpane.toFront();
        homepage_email.setText("");
        homepage_passwort.setText("");
        homepage_fehlermeldung_label.setText("");
    }
    @FXML
    void reg_verkaufboard_button_function(ActionEvent event){
        verkaufboard_stackpane.toFront();
        if(mitarbeiter!=null){
            verkauf_name_mitarbeiter_label.setText(mitarbeiter.getPerson_daten().getNachname());
            verkauf_funktion_mitarbeiter_label.setText(mitarbeiter.getFunktion());
        }

    }

    @FXML
    void statistik_barchart(ActionEvent event){
        DAO dao = new DAO();
        maprodukt = dao.statistik_anzeigen(statistik_datenpicker_verkaufe.getValue().getMonth().name(),String.valueOf(statistik_datenpicker_verkaufe.getValue().getYear()));
        for (String id:(List<String>)maprodukt.get("id")) {
            System.out.println(id);
        }

        CategoryAxis Xaxis = new CategoryAxis();
        NumberAxis Yaxis = new NumberAxis();
        BarChart<String,Number> chart = new BarChart<String,Number>(Xaxis,Yaxis);
        XYChart.Series<String,Number> serie = new XYChart.Series<>();
        int Anzahlprodukt =0;
        for (Produkt produkt: (List<Produkt>)maprodukt.get("produkt")) {
            for (String id: (List<String>)maprodukt.get("id")) {
                if (produkt.getIdProdukt().equals(id)){
                    Anzahlprodukt++;

                }
            }
            serie.getData().add(new XYChart.Data<String,Number>(produkt.getName(),Anzahlprodukt));
            Anzahlprodukt=0;
        }
        serie.setName(statistik_datenpicker_verkaufe.getValue().getMonth().name()+" "+String.valueOf(statistik_datenpicker_verkaufe.getValue().getYear()));
        chart.setBarGap(20);
        chart.getData().add(serie);

        statistik_pane1.getChildren().add(chart);



    }

    @FXML
    void statistik_scatterchart(ActionEvent event){
        DAO dao = new DAO();
        maprodukt = dao.statistik_anzeigen(statistik_datenpicker_verkaufe.getValue().getMonth().name(),String.valueOf(statistik_datenpicker_verkaufe.getValue().getYear()));
        CategoryAxis Xaxis = new CategoryAxis();
        NumberAxis Yaxis = new NumberAxis();
        ScatterChart<String,Number> chart = new ScatterChart<>(Xaxis,Yaxis);
        XYChart.Series<String,Number> serie = new XYChart.Series<>();
        int Anzahlprodukt =0;
        for (Produkt produkt: (List<Produkt>)maprodukt.get("produkt")) {
            for (String id: (List<String>)maprodukt.get("id")) {
                if (produkt.getIdProdukt().equals(id)){
                    Anzahlprodukt++;

                }
            }
            serie.getData().add(new XYChart.Data<String,Number>(produkt.getName(),Anzahlprodukt));
            Anzahlprodukt=0;
        }
        serie.setName(statistik_datenpicker_verkaufe.getValue().getMonth().name()+" "+String.valueOf(statistik_datenpicker_verkaufe.getValue().getYear()));
        chart.getData().add(serie);

        statistik_pane1.getChildren().add(chart);

    }
    @FXML
    void statistik_linechart(ActionEvent event){
        DAO dao = new DAO();
        maprodukt = dao.statistik_anzeigen(statistik_datenpicker_verkaufe.getValue().getMonth().name(),String.valueOf(statistik_datenpicker_verkaufe.getValue().getYear()));
        CategoryAxis Xaxis = new CategoryAxis();
        NumberAxis Yaxis = new NumberAxis();
        LineChart<String,Number> chart = new LineChart<>(Xaxis,Yaxis);
        XYChart.Series<String,Number> serie = new XYChart.Series<>();
        int Anzahlprodukt =0;
        for (Produkt produkt: (List<Produkt>)maprodukt.get("produkt")) {
            for (String id: (List<String>)maprodukt.get("id")) {
                if (produkt.getIdProdukt().equals(id)){
                    Anzahlprodukt++;

                }
            }
            serie.getData().add(new XYChart.Data<String,Number>(produkt.getName(),Anzahlprodukt));
            Anzahlprodukt=0;
        }
        serie.setName(statistik_datenpicker_verkaufe.getValue().getMonth().name()+" "+String.valueOf(statistik_datenpicker_verkaufe.getValue().getYear()));
        chart.getData().add(serie);

        statistik_pane1.getChildren().add(chart);
    }

    @FXML
    void statistik_areachart(ActionEvent event){
        DAO dao = new DAO();
        maprodukt = dao.statistik_anzeigen(statistik_datenpicker_verkaufe.getValue().getMonth().name(),String.valueOf(statistik_datenpicker_verkaufe.getValue().getYear()));
        CategoryAxis Xaxis = new CategoryAxis();
        NumberAxis Yaxis = new NumberAxis();
        AreaChart<String,Number> chart = new AreaChart<>(Xaxis,Yaxis);
        XYChart.Series<String,Number> serie = new XYChart.Series<>();
        int Anzahlprodukt =0;
        for (Produkt produkt: (List<Produkt>)maprodukt.get("produkt")) {
            for (String id: (List<String>)maprodukt.get("id")) {
                if (produkt.getIdProdukt().equals(id)){
                    Anzahlprodukt++;

                }
            }
            serie.getData().add(new XYChart.Data<String,Number>(produkt.getName(),Anzahlprodukt));
            Anzahlprodukt=0;
        }
        serie.setName(statistik_datenpicker_verkaufe.getValue().getMonth().name()+" "+String.valueOf(statistik_datenpicker_verkaufe.getValue().getYear()));
        chart.getData().add(serie);

        statistik_pane1.getChildren().add(chart);
    }

    @FXML
    void statistik_zur_Pverwaltung_function(ActionEvent event){
        produkt_verwaltung_stackpane.toFront();
    }

    @FXML
    void produktverwaltung_zur_statistik_function(ActionEvent event){
        statistik_stackpane.toFront();
    }

}
