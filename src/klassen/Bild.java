package klassen;

public class Bild {
    private String idBild;
    private String link;
    private Produkt produkt;

    public Bild(Produkt produkt,String link){
        this.link = link;
        this.produkt = produkt;
    }
    public String getIdBild(){
        return idBild;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public String getLink() {
        return link;
    }

    public void setIdBild(String idBild) {
        this.idBild = idBild;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }
}
