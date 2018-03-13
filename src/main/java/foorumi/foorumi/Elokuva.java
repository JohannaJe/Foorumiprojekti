package foorumi.foorumi;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity

public class Elokuva {
    @Id @GeneratedValue
    private int id;
    private String kayttaja;
    private String aihe;
    private String kommentti;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(String kayttaja) {
        this.kayttaja = kayttaja;
    }

    public String getAihe() {
        return aihe;
    }

    public void setAihe(String aihe) {
        this.aihe = aihe;
    }

    public String getKommentti() {
        return kommentti;
    }

    public void setKommentti(String kommentti) {
        this.kommentti = kommentti;
    }

    public Elokuva(String kayttaja, String aihe, String kommentti) {
        this.kayttaja = kayttaja;
        this.aihe = aihe;
        this.kommentti = kommentti;

    }

    public Elokuva() {
    }
}

