package foorumi.foorumi.Aihe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import foorumi.foorumi.Viesti.Viesti;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Aihe {

    private String otsikko;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int koodi;

    @OneToMany(mappedBy = "aihe")
    @JsonIgnore
    public List<Viesti> viestit;

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
}
