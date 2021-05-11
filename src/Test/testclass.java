package Test;

import klassen.*;

import java.util.*;

public class testclass {
    public static void main(String[] arg){
        Map<String,String>map = new HashMap<>();
        map.put("name","milch");
        map.put("preis","1,2");
        List<Produkt> list = new ArrayList<>();


        /*
        Person p = new Person();
        p.setNachname("Guewou");
        p.setVorname("Blaise");
        p.setEmail("blaise@gmail.com");
        p.setTelephone("12344566");
        p.setPasswort("nomadeguewou");
        p.setDatum(String.valueOf(new Date()));
        p.setIdPerson("1");

         */
        DAO dao = new DAO();
        //dao.Produkt_suche("fett","allgemeinesuche");
        //dao.such_produkt_fuer_bestand_änderung(map);
        //Person registrieren
        //dao.Userspeicher(p);

        //Test auf registrierung
        //dao.Mitarbeiter_registrieren(p);


        //Test auf Produktregiestrierung
        /*
        Produkt produkt = new Produkt();
        produkt.setName("Reis");
        produkt.setMenge("genug");
        produkt.setPreis("2 euro/kg");
        produkt.setBeschreibung("Gute Qualität:wird immer gut gegarrt");
        produkt.setDatum(String.valueOf(new Date()));
        dao.Produktregistrierung(p,produkt,new Bild(produkt,"C:\\Users\\guewo\\Downloads\\bild1.jpeg"));

         */
        //bestandänderungstest
        //dao.bestand_ändern("4","120");

        //Test auf Löschen von Produkte
       /* Produkt produkt = new Produkt();
        produkt.setIdProdukt("1");
        list.add(produkt);
        dao.Produkte_löschen(list);
        */

        /*einloggen Test
        Mitarbeiter mitarbeiter = dao.Mitarbeiter_suchen("geese@gmail.com","geese","simple");
        System.out.println(mitarbeiter.getIdMitarbeiter());

         */
        Map<String,Object> map1 = dao.statistik_anzeigen("APRIL","2021");
        for (Produkt produkt: (List<Produkt>)map1.get("produkt")) {
            System.out.println(produkt.getName());
        }
    }
}
