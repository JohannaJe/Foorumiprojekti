package foorumi.foorumi.Viesti;

import foorumi.foorumi.Viesti.Viesti;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class Viestit {

    private List<Viesti> viestit;

    public Viestit(){};

    public Viestit(List<Viesti> viestit) {
        this.viestit = viestit;
    }

    public List palautaLista(){
        return viestit;
    }

   /* public void lisaa(Viesti viesti) {
        viesti.setId(viesti.getId());
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
        return viestit.parallelStream().filter(viesti->viesti.getId()==id).findFirst().orElse(null);
    }

    public void muokkaa(Viesti viesti) {
        Viesti vanha =  etsi(viesti.getId());
        vanha.setTeksti(viesti.getTeksti());
    }*/

    @Override
    public String toString() {
        return "viestit";
    }

    public List<Viesti> getViestit() {
        return viestit;
    }

    public void setViestit(List<Viesti> viestit) {
        this.viestit = viestit;
    }
}

