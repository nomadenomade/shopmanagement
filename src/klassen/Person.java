package klassen;

public class Person {
    private String idPerson;
    private String Nachname;
    private String Vorname;
    private String Email;
    private String Telephone;
    private String Passwort;
    private String Datum;
    public Person(){

    }
    public String getIdPerson(){
        return idPerson;
    }

    public String getNachname() {
        return Nachname;
    }

    public String getVorname() {
        return Vorname;
    }

    public String getEmail() {
        return Email;
    }

    public String getTelephone() {
        return Telephone;
    }

    public String getPasswort() {
        return Passwort;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public void setPasswort(String passwort) {
        Passwort = passwort;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }
}
