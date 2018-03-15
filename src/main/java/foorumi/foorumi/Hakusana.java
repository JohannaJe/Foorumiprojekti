package foorumi.foorumi;

import org.springframework.stereotype.Component;

public class Hakusana {

    private String hakusana;


    public Hakusana() {
    }

    public Hakusana(String hakusana) {

        this.hakusana = hakusana;
    }

    public String getHakusana() {
        return hakusana;
    }

    public void setHakusana(String hakusana) {
        this.hakusana = hakusana;
    }
    @Override
    public String toString() {
        return hakusana;
    }
}


