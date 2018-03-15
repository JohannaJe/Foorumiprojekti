package foorumi.foorumi.Viesti;

import foorumi.foorumi.Kayttaja.Kayttaja;

import javax.persistence.*;

@Entity
public class Viesti {

    public String teksti;
    @Id
    @GeneratedValue
    public Integer id;
    public String alue;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "kayttaja")
//    public Kayttaja kayttaja;

    public String kayttaja;

    public Viesti(){
    }

    public String getTeksti() {
        return teksti;
    }

    public void setTeksti(String teksti) {
        this.teksti = teksti;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlue() {
        return alue;
    }

    public void setAlue(String alue) {
        this.alue = alue;
    }

    public String getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(String kayttaja) {
        this.kayttaja = kayttaja;
    }

}



