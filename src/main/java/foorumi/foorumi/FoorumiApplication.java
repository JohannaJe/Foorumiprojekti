package foorumi.foorumi;


import foorumi.foorumi.Kayttaja.Kayttaja;
import foorumi.foorumi.Kayttaja.Kayttajarepo;
import foorumi.foorumi.Viesti.Viesti;
import foorumi.foorumi.Viesti.Viestirepo;
import foorumi.foorumi.Viesti.Viestit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FoorumiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoorumiApplication.class, args);
    }

	@Bean //Alustaa tietokannan
	CommandLineRunner luoViestit (Viestirepo vr) {
		return (args) -> {
			List<Viesti> lista = new ArrayList<>();
			Viesti v = new Viesti("Kalajutut", "Turo", "Sain ison hauen");
			lista.add(v);
            Viesti v2 = new Viesti("Kalajutut", "Make", "Mun haukeni on taatusti isompi kuin sun haukesi");
            lista.add(v2);
            Viesti v3 = new Viesti("Leffalopinat", "Siru", "Hieno taustakuva");
            lista.add(v3);
			Viesti v4 = new Viesti("Leffalopinat", "Tanja", "Niin on! Valkoiset ruusut on hienoin suomalainen elokuva. Helena Kara voisi olla kansainvälinen tähti.");
			lista.add(v4);
			Viesti v5 = new Viesti("Leffalopinat", "Siru", "Niin voisi!!!");
			lista.add(v5);
			Viesti v6 = new Viesti("Golfjuorut", "Otso", "Mitähän ajattelevat syksyllä ne osakkeenomistajat jotka syksyllä sitoutuivat 800e pelikausimaksuun,kun UUNO antaa rajoittamattoman pelioikeuden 700e-10%");
			lista.add(v6);
			Viesti v7 = new Viesti("Golfjuorut", "Putti-possu", "Golfari ei jää pohtimaan menneitä. Pätee pelaamiseen, mutta myös näihin maksuihin.");
			lista.add(v7);
			Viesti v8 = new Viesti("Golfjuorut", "Putti-possu", "Sitä paitsi ei tässä ole mitään elämälle vierasta – ostit eilen kahvipaketin 4 eurolla ja tänään saisi tarjouksesta 2 pkt 5€:lla. Harva meistä jää suremaan edellispäivän kahvipaketin hintaa.");
			lista.add(v8);
			Viesti v9 = new Viesti("Kalajutut", "Marjatta", "Mulla on varmasti isoin!");
			lista.add(v9);
			Viesti v10 = new Viesti("Autohullut", "Salama", "Onko kukaan ostellut autoon philipsin blue vision ym merkkisiä polttimoita? Kumpi olisi parempi sinistä valoa hohtavat vai valkoista?");
			lista.add(v10);
			Viesti v11 = new Viesti( "Autohullut", "Uuno", "Mulla on hiace 4x4 veto. Nyt olis tarvis irrottaa jarrurumpu, mutta ei lähde ruuvaamalla reijistä pultilla kun kierteet korkanneet. Lähteekö jarrurumpu irti, jos ottaa keskimutterin irti? Ettei laakeri hajoa?" );
			lista.add(v11);
			Viesti v12 = new Viesti("Autohullut", "Helka", "Joskus jarrurumpu voi vaatia rajuakin väkivaltaa, eli isoa vasaraa ja nitkuttelua rummun jokapuolelle.");
			lista.add(v12);
			Viesti v13 = new Viesti ("Autohullut", "XXX", "Salama: Itse laitoin viime talvena Philipsin H4 55/105 wattiset. Ne on ainakin kirkkaat eikä häikäise vastaantulijoita. Laittomathan ne on mutta.....");
			lista.add(v13);

			vr.saveAll(lista);
		};
	}

    @Bean //Alustaa tietokannan
    CommandLineRunner luoKayttajat (Kayttajarepo kr) {
        return (args) -> {
            List<Kayttaja> lista = new ArrayList<>();
            Kayttaja v = new Kayttaja("Koodari", "Salasana");
            lista.add(v);
            Kayttaja v2 = new Kayttaja("Java", "Koodari");
            lista.add(v2);
            kr.saveAll(lista);
        };
    }
	}