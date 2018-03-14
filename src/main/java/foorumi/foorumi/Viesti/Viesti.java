package foorumi.foorumi.Viesti;

import foorumi.foorumi.Aihe.Aihe;

import javax.persistence.*;

@Entity
public class Viesti {

    private String teksti;
    private String kayttaja;
    @Id
    @GeneratedValue
    public int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aihe")
    public Aihe aihe;

    public Viesti(){
    }


    public Viesti(String teksti, String kayttaja) {
        this.teksti = teksti;
        this.kayttaja = kayttaja;
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

    public Aihe getAihe() {
        return aihe;
    }

    public void setAihe(Aihe aihe) {
        this.aihe = aihe;
    }
}



