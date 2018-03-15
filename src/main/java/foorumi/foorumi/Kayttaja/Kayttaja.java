package foorumi.foorumi.Kayttaja;

import foorumi.foorumi.Viesti.Viesti;

import javax.persistence.OneToMany;
import java.util.List;

public class Kayttaja {

    public String nimimerkki;
    public String salasana;

    @OneToMany(mappedBy = "kayttaja")
    public List<Viesti> viesti;

    public Kayttaja() {
    }

    public String getNimimerkki() {
        return nimimerkki;
    }

    public void setNimimerkki(String nimimerkki) {
        this.nimimerkki = nimimerkki;
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }
}
