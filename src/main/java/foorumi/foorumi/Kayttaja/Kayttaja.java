package foorumi.foorumi.Kayttaja;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kayttaja {

    @Id @GeneratedValue
    private int id;
    private String kayttajatunnus;
    private String salasana;
    private String info;

    public Kayttaja() {
    }

    public Kayttaja(String kayttajatunnus, String salasana, String info) {
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
        this.info = info;
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

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
