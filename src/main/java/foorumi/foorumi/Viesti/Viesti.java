package foorumi.foorumi.Viesti;

import foorumi.foorumi.Aihe.Aihe;

import javax.persistence.*;

public class Viesti {

    private String teksti;
    private String kayttaja;
    @Id
    @GeneratedValue
    static int id = 1;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aihe")
    public Aihe aihe;

    public Viesti(){
        id++;
    }


    public Viesti(String teksti, String kayttaja) {
        this.teksti = teksti;
        this.kayttaja = kayttaja;
        id++;
    }

    public String getTeksti() {
        return teksti;
    }

    public void setTeksti(String teksti) {
        this.teksti = teksti;
    }

    public String getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(String kayttaja) {
        this.kayttaja = kayttaja;
    }

    public int getId() {
        return id++;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return teksti + ", " + kayttaja + ".";
    }


}



