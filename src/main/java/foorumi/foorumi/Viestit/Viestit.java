package foorumi.foorumi.Viestit;

import foorumi.foorumi.Viesti.Viesti;
import java.util.List;

public class Viestit {

    private List<Viesti> viestit;

    public Viestit(List<Viesti> viestit) {
        this.viestit = viestit;
    }

    public List palautaLista(){
        return viestit;
    }

    public void lisaaListalle(Viesti viesti){
        viestit.add(viesti);
    }

    public void poistaListalta(int indeksi){
        viestit.remove(indeksi);
    }

    public void muutaListalta(int indeksi){
        Viesti uusi = new Viesti("JOKU MUU ON KUNINGAS", "KAIKKI");
        viestit.set(indeksi, uusi);
    }

    @Override
    public String toString() {
        return "Sanonnat{" +
                "sanonnat=" + viestit +
                '}';
    }

    public List<Viesti> getViestit() {
        return viestit;
    }

    public void setViestit(List<Viesti> viestit) {
        this.viestit = viestit;
    }
}

