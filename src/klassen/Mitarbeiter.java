package klassen;

public class Mitarbeiter {
    private String idMitarbeiter;
    private String funktion;
    private Person person_daten;

    public Mitarbeiter(String idMitarbeiter,String funktion,Person person_daten){
        this.idMitarbeiter = idMitarbeiter;
        this.person_daten= person_daten;
        this.funktion = funktion;
    }

    public Mitarbeiter(){

    }

    public Person getPerson_daten() {
        return person_daten;
    }

    public String getFunktion() {
        return funktion;
    }

    public String getIdMitarbeiter() {
        return idMitarbeiter;
    }

    public void setIdMitarbeiter(String idMitarbeiter) {
        this.idMitarbeiter = idMitarbeiter;
    }

    public void setFunktion(String funktion) {
        this.funktion = funktion;
    }

    public void setPerson_daten(Person person_daten) {
        this.person_daten = person_daten;
    }
}
