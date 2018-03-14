package foorumi.foorumi.Viesti;

import foorumi.foorumi.Viestit.Viestit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Viesti {

    private String teksti;
    private String kayttaja;
    private int id = 1;

    public Viesti(){
        id++;
    }

    private List<Viestit> viestit = new ArrayList<>();

    public Viesti(String teksti, String kayttaja) {
        this.teksti = teksti;
        this.kayttaja = kayttaja;
        id++;
    }

    public void lisaa(Viesti viesti) {
        viesti.setId(id++);
        viestit.add(viesti);
    }

    public boolean poista( int id) {
        Iterator<Viesti> it = viestit.iterator();
        while (it.hasNext()) {
            Viesti v = it.next();
            if (v.getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Viesti etsi(final int id) {
        return viestit.parallelStream().filter(s->s.id==id).findFirst().orElse(null);
    }

    public void muokkaa(Viesti viesti) {
        Viesti vanha =  etsi(viesti.id);
        vanha.setTeksti(viesti.getTeksti());
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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return teksti + ", " + kayttaja + ".";
    }
}



