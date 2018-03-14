package foorumi.foorumi.Aihe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import foorumi.foorumi.Viesti.Viesti;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aihe {

    private String otsikko;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int koodi;
    private String alue;

    @OneToMany(mappedBy = "aihe")
    @JsonIgnore
    public List<Viesti> viestit;

    public Aihe() {
    }

    public Aihe(String alue) {
        this.alue = alue;
    }

    public String getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public int getKoodi() {
        return koodi;
    }

    public void setKoodi(int koodi) {
        this.koodi = koodi;
    }

    public String getAlue() {
        return alue;
    }

    public void setAlue(String alue) {
        this.alue = alue;
    }
}
