package foorumi.foorumi.Golf;

import foorumi.foorumi.Kayttaja.Kayttaja;

import javax.persistence.*;

@Entity
public class Golf {

    @Id
    @GeneratedValue
    private int id;
    private String kayttajatunnus;
    private String aihe;
    private String kommentti;
//    private Kayttaja kayttaja;
//    @ManyToOne(cascade = {CascadeType.PERSIST/*, CascadeType.MERGE, CascadeType.REMOVE*/})
//    @JoinColumn
//    private Kayttaja kayttaja;


    public Golf() {
    }

    public Golf(String kayttajatunnus, String aihe, String kommentti) {
        this.kayttajatunnus = kayttajatunnus;
        this.aihe = aihe;
        this.kommentti = kommentti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKayttajatunnus() {
        return kayttajatunnus;
    }

    public void setKayttajatunnus(String kayttajatunnus) {
        this.kayttajatunnus = kayttajatunnus;
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
}


