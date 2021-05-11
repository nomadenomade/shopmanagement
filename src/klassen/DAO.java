package klassen;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class DAO {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;
    private Statement statement_query;
    public DAO(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){

        }
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_desktop","nomade","nomadeguewou");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public String Userspeicher(Person person){
        String request ="INSERT INTO person(Nachname,Vorname,Email,Telephone,Passwort,Datum) VALUES(?,?,?,?,?,?)";
        String rueckgabe =null;
        try {
            statement = connection.prepareStatement(request);
            statement.setString(1,person.getNachname());
            statement.setString(2, person.getVorname());
            statement.setString(3, person.getEmail());
            statement.setString(4, person.getTelephone());
            statement.setString(5,person.getPasswort());
            statement.setString(6, person.getDatum());
            int status =statement.executeUpdate();
            if(status==0){
                System.out.println("Insert fehlgeschlagen");
                rueckgabe= "Insert fehlgeschlagen";
            }else{
                System.out.println("Insert erfolgreich");
                rueckgabe = "Insert erfolgreich";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement !=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
        return rueckgabe;
    }
    public String Mitarbeiter_registrieren(Person a,String funktion){
        String request1 ="SELECT * FROM person ";
        String request2 ="INSERT INTO mitarbeiter(idPerson,Funktion) VALUES(?,?)";
        String rueckgabe="";

        try {
            statement_query = connection.createStatement();
            result = statement_query.executeQuery(request1);
            while (result.next()){
                if (result.getString("Nachname").equals(a.getNachname())&& result.getString("Email").equals(a.getEmail())){
                    statement = connection.prepareStatement(request2);
                    statement.setString(1,result.getString("idPerson"));
                    statement.setString(2,funktion);
                    int status= statement.executeUpdate();
                    if(status==0){
                        rueckgabe="Registrierung fehlgeschlagen";
                        System.out.println("Registrierung fehlgeschlagen");
                    }else{
                        rueckgabe="Registrierung erfolgreich";
                        System.out.println("Registrierung erfolgreich");
                    }


                    break;
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement !=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return rueckgabe;
    }

    public String Produktregistrierung(Person person,Produkt produkt,Bild bild){
        String rueckgabe=null;
        String request1 = "INSERT INTO produkte(Name,Marke,Preis,Menge,Beschreibung,Categories,Gewicht,idMitarbeiter,Datum)" +
                "VALUES(?,?,?,?,?,?,?,?,?)";
        String request2 = "SELECT * FROM mitarbeiter ";
        String request3 = "INSERT INTO bild(link,idProdukte) VALUES(?,?)";
        String request4 ="SELECT * FROM produkte";
        ResultSet result;
        try {
            //holen wir die idMitarbeiter mit hilfe idPerson
            statement_query = connection.createStatement();
            result = statement_query.executeQuery(request2);
            String idMitarbeiter=null;
            while (result.next()){
                if (result.getString("idPerson").equals(person.getIdPerson())){
                    idMitarbeiter= result.getString("idMitarbeiter");
                    break;
                }
            }

            //Speichern wir das neue Produkt
            statement = connection.prepareStatement(request1);
            statement.setString(1,produkt.getName());
            statement.setString(2,produkt.getMarke());
            statement.setString(3,produkt.getPreis());
            statement.setString(4,produkt.getMenge());
            statement.setString(5,produkt.getBeschreibung());
            statement.setString(6,produkt.getCategories());
            statement.setString(7,produkt.getGewicht());
            statement.setString(8,idMitarbeiter);
            statement.setString(9,String.valueOf(new Date()));
            int status = statement.executeUpdate();
            if(status==0){
                rueckgabe="Produktregistrierung fehlgeschlagen";
                System.out.println("Produktregistrierung fehlgeschlagen");
            }else{
                rueckgabe="Producktregistrierung erfolgreich";
                System.out.println("Producktregistrierung erfolgreich");
            }

            //holen wir uns idProdukt für die Tabelle bild
            statement_query = connection.createStatement();
            result = statement_query.executeQuery(request4);
            String idProdukt=null;
            while(result.next()){
                if (result.getString("Name").equals(produkt.getName())&&result.getString("idMitarbeiter").equals(idMitarbeiter)){
                    idProdukt=result.getString("idProdukte");
                }
            }



            //Speichern wir das Bild für dieses Produkt
            statement = connection.prepareStatement(request3);
            statement.setString(1,bild.getLink());
            statement.setString(2,idProdukt);
            int status1 = statement.executeUpdate();
            if (status==0){
                System.out.println("Bildspeicherung fehlgeschlagen");
            }else{
                System.out.println("Bildspeicherung ok");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


        return rueckgabe;
    }

    public List<Produkt> Produkt_suche(String suchbegriff,String type){
        String request1 = "SELECT * FROM produkte WHERE Name LIKE ? OR Marke LIKE ? OR Preis LIKE ? OR Beschreibung LIKE ?";
        String request2 ="SELECT * FROM produkte";
        String request3 = "SELECT * FROM produkte WHERE Menge='0'";
        String request4 = "SELECT * FROM bild WHERE idProdukte =?";
        List<Produkt> list_produkte = new ArrayList<>();

        try {
            if(type.equals("allgemeinesuche")){
                statement = connection.prepareStatement(request1);
                statement.setString(1,"%"+suchbegriff+"%");
                statement.setString(2,"%"+suchbegriff+"%");
                statement.setString(3,"%"+suchbegriff+"%");
                statement.setString(4,"%"+suchbegriff+"%");
                result = statement.executeQuery();
            }else if(type.equals("alleprodukte")){
                statement_query = connection.createStatement();
                result = statement_query.executeQuery(request2);
            }else if (type.equals("leerebestaende")){
                statement_query = connection.createStatement();
                result = statement_query.executeQuery(request3);
            }
            String link=null;
            while(result.next()){
                Produkt produkt = new Produkt();
                produkt.setIdProdukt(result.getString("idProdukte"));
                produkt.setName(result.getString("Name"));
                produkt.setMarke(result.getString("Marke"));
                produkt.setPreis(result.getString("Preis"));
                produkt.setBeschreibung(result.getString("Beschreibung"));
                produkt.setCategories(result.getString("Categories"));
                produkt.setGewicht(result.getString("Gewicht"));
                produkt.setMenge(result.getString("Menge"));
                produkt.setDatum(result.getString("Datum"));

                //Produktbild finden
                PreparedStatement statement2 = connection.prepareStatement(request4);
                statement2.setString(1,result.getString("idProdukte"));
                ResultSet result1 = statement2.executeQuery();
                while(result1.next()){
                    link = result1.getString("link");
                }
                produkt.setLink(link);

                        //einfügung des neuen gefundenen Produkt in der zurückzugebenden Liste
                list_produkte.add(produkt);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return list_produkte;
    }
    public List<Produkt> such_produkt_fuer_bestand_änderung(Map<String ,String> suchbegriffe){
        List<Produkt> list_produkte = new ArrayList<>();
        String request1 = "SELECT * FROM produkte WHERE Name LIKE ? AND Preis Like ? AND Marke LIKE ?";
        String request4 = "SELECT * FROM bild WHERE idProdukte =?";

        try {
            statement = connection.prepareStatement(request1);
            statement.setString(1,"%"+suchbegriffe.get("name")+"%");
            statement.setString(2,"%"+suchbegriffe.get("preis")+"%");
            statement.setString(3,"%"+suchbegriffe.get("marke")+"%");
            result = statement.executeQuery();
            String link=null;
            while(result.next()){
                Produkt produkt = new Produkt();
                produkt.setIdProdukt(result.getString("idProdukte"));
                produkt.setName(result.getString("Name"));
                produkt.setMarke(result.getString("Marke"));
                produkt.setPreis(result.getString("Preis"));
                produkt.setBeschreibung(result.getString("Beschreibung"));
                produkt.setCategories(result.getString("Categories"));
                produkt.setGewicht(result.getString("Gewicht"));
                produkt.setMenge(result.getString("Menge"));
                produkt.setDatum(result.getString("Datum"));

                //Produktbild finden
                PreparedStatement statement2 = connection.prepareStatement(request4);
                statement2.setString(1,result.getString("idProdukte"));
                ResultSet result1 = statement2.executeQuery();
                while(result1.next()){
                    link = result1.getString("link");
                }
                produkt.setLink(link);
                //einfügung des neuen gefundenen Produkt in der zurückzugebenden Liste
                list_produkte.add(produkt);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


        return list_produkte;
    }

    public String bestand_ändern (String idProdukt,String neuMenge){
        String request = "UPDATE produkte SET Menge=? WHERE idProdukte =?";
        String rueckgabe = null;
        try {
            statement = connection.prepareStatement(request);
            statement.setString(1,neuMenge);
            statement.setString(2,idProdukt);
            int status = statement.executeUpdate();
            if(status==0){
                rueckgabe= "Änderung fehlgeschlagen";
                System.out.println("fehgeschlagen");
            }else {
                rueckgabe= "Änderung erfolgreich";
                System.out.println("erfolgreich");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return rueckgabe;
    }

    //Produkte löschen
    public String Produkte_löschen(List<Produkt> list_produkt){
        String request = "DELETE FROM produkte WHERE idProdukte = ?";
        String request2 ="DELETE FROM bild WHERE idProdukte = ?";
        String rueckgabe=null;
        try {
            statement = connection.prepareStatement(request);
            PreparedStatement statement1 = connection.prepareStatement(request2);
            for (Produkt p:list_produkt) {
                statement1.setString(1,p.getIdProdukt());
                int status1 = statement1.executeUpdate();
                if (status1!=0){
                    System.out.println("Bild des Produkts gelöscht");
                }


                statement.setString(1, p.getIdProdukt());
                int status =statement.executeUpdate();
                if (status==0){
                    rueckgabe ="Löschoperation fehlgeschlagen";
                    System.out.println("löschoperation fehlgeschllagen");
                }else{
                    rueckgabe ="löschoperation erfolgreich";
                    System.out.println("löschoperation erfolgreich");
                }


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return rueckgabe;
    }


    public String Rechnungerstellung (Rechnung_erstellung rechnung_erstellung,Mitarbeiter mitarbeiter){
        String request1 = "INSERT INTO warenkob(Rechnungsnummer,Menge,Gesamtpreis,Datum,idMitarbeiter) VALUES(?,?,?,?,?)";
        String request = "SELECT * FROM warenkob";
        String request2 = "INSERT INTO inhaltwarenkob(idWarenkob,idProdukte) VALUES(?,?)";
        String request3 = "UPDATE produkte SET Menge=? WHERE idProdukte =?";
        String request4 = "SELECT * FROM produkte WHERE idProdukte=?";
        String rueckgabe= null;
        Rechnung rechnung = rechnung_erstellung.getRechnung();
        try {
            Date date = new Date();
            int status1=0 ;
            String idWarenkob=null;

            statement = connection.prepareStatement(request1);
            statement.setString(1,rechnung.getRechnungsnummer());
            statement.setString(2,rechnung.getGesamtmenge());
            statement.setString(3,rechnung.getGesamtpreis());
            statement.setString(4,date.toString());
            statement.setString(5,mitarbeiter.getIdMitarbeiter());
            rechnung.setDate(date.toString());
            statement.executeUpdate();


            statement_query = connection.createStatement();
            result = statement_query.executeQuery(request);
            while (result.next()){
                if(result.getString("Rechnungsnummer").equals(rechnung.getRechnungsnummer())&&result.getString("Datum").equals(date.toString())){
                    idWarenkob = result.getString("idWarenkob");
                    System.out.println(idWarenkob);

                }
            }



            for (Produkt produkt: rechnung_erstellung.getList_produkt()) {
                statement = connection.prepareStatement(request2);
                statement.setString(1,idWarenkob);
                statement.setString(2,produkt.getIdProdukt());
                status1 = statement.executeUpdate();

                statement = connection.prepareStatement(request4);
                statement.setString(1, produkt.getIdProdukt());
                result = statement.executeQuery();
                int menge =0;
                while (result.next()){
                    menge = Integer.valueOf(result.getString("Menge").trim());
                }
                statement = connection.prepareStatement(request3);
                statement.setString(1,String.valueOf(menge - Integer.valueOf(produkt.getMenge().trim())));
                statement.setString(2, produkt.getIdProdukt());
                statement.executeUpdate();



            }
            if (status1==0){
                rueckgabe="Rechnung erfolgreich erstellt";
                System.out.println("Rechnung erfolgreich erstellt");
            }else{
                System.out.println("Rechnungerstellung erfolgreich");
                rueckgabe="Rechnung erfolgreich erstellt";

            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement !=null){

            }
        }
        return rueckgabe;
    }

    public Mitarbeiter Mitarbeiter_suchen(String Email,String Passwort,String type){
        String request1 = null;
        String request2 = "SELECT * FROM mitarbeiter WHERE idPerson =?";
        Person person = new Person();
        Mitarbeiter mitarbeiter = null;
        if (type.equals("simple")){
            request1 = "SELECT * FROM person WHERE Email=? AND Passwort = ?";
            try {
                statement = connection.prepareStatement(request1);
                statement.setString(1,Email);
                statement.setString(2,Passwort);
                result = statement.executeQuery();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else if (type.equals("admin")){
            request1 = "SELECT * FROM person WHERE Passwort =?";
            try {
                statement = connection.prepareStatement(request1);
                statement.setString(1,Passwort);
                result = statement.executeQuery();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {


            while (result.next()){
                person.setIdPerson(result.getString("idPerson"));
                person.setNachname(result.getString("Nachname"));
                person.setVorname(result.getString("Vorname"));
                person.setDatum(result.getString("Datum"));
                person.setPasswort(result.getString("Passwort"));
                person.setTelephone(result.getString("Telephone"));
                person.setEmail(result.getString("Email"));
            }
            if (person.getIdPerson()!=null){
                statement = connection.prepareStatement(request2);
                statement.setString(1, person.getIdPerson());
                result = statement.executeQuery();
                mitarbeiter = new Mitarbeiter();
                while (result.next()){
                    mitarbeiter.setIdMitarbeiter(result.getString("idMitarbeiter"));
                    mitarbeiter.setFunktion(result.getString("Funktion"));
                    mitarbeiter.setPerson_daten(person);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mitarbeiter;
    }

    public Map<String,Object> statistik_anzeigen(String Monat ,String Jahr){
        String request ="SELECT * FROM warenkob";
        String request1 ="SELECT * FROM inhaltwarenkob ";
        String request2 ="SELECT * FROM produkte WHERE idProdukte=?";
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        Set<String> list3 = new HashSet<>();
        List<Produkt>produktList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        Produkt produkt = null;
        try {
            statement_query = connection.createStatement();
            result = statement_query.executeQuery(request);
            while (result.next()){
                String werte = result.getString("Datum");
                if(werte.split(" ")[1].toUpperCase(Locale.ROOT).equals(Monat.substring(0,3))&& werte.split(" ")[5].equals(Jahr)){
                    list.add(result.getString("idWarenkob"));

                }

            }
            statement_query = connection.createStatement();
            result =statement_query.executeQuery(request1);
            for (String idwarenkob: list) {
                while (result.next()){
                    if (result.getString("idWarenkob").equals(idwarenkob)){
                        list2.add(result.getString("idProdukte"));
                        list3.add(result.getString("idProdukte"));
                    }
                }
                result = statement_query.executeQuery(request1);
            }
            map.put("id",list2);
            statement = connection.prepareStatement(request2);
            for (String idprodukt: list3) {
                statement.setString(1,idprodukt);
                result = statement.executeQuery();
                while (result.next()){
                    produkt = new Produkt();
                    produkt.setIdProdukt(result.getString("idProdukte"));
                    produkt.setName(result.getString("Name"));
                    produkt.setMarke(result.getString("Marke"));
                    produkt.setPreis((result.getString("Preis")));
                    produkt.setMenge(result.getString("Menge"));
                    produkt.setBeschreibung("Beschreibung");
                    produkt.setCategories("Categories");
                    produkt.setGewicht("Gewicht");
                    produkt.setDatum("Datum");
                    produktList.add(produkt);
                }
            }
            map.put("produkt",produktList);





        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return map;
    }
}
