package foorumi.foorumi;


import foorumi.foorumi.Viesti.Viesti;
import foorumi.foorumi.Viesti.Viestirepo;
import foorumi.foorumi.Viesti.Viestit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoorumiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoorumiApplication.class, args);
    }

//    private Viestirepo vr;
//
//    @Bean
//    public CommandLineRunner alustaKeskustelut() {
//        return (args) -> {
//        Viesti uusi = new Viesti("Tämä on minun mielipiteeni", "Jaakko", "Autohullut");
//        vr.save(uusi);
//        Viesti uusi1 = new Viesti("Tämä on minun mielipiteeni", "Jaakko", "Golfjuorut");
//        vr.save(uusi1);
//        Viesti uusi2 = new Viesti("Tämä on minun mielipiteeni", "Jaakko", "Kalajutut");
//        vr.save(uusi2);
//        Viesti uusi3 = new Viesti("Tämä on minun mielipiteeni", "Jaakko", "Leffalopinat");
//        vr.save(uusi3);
//        Viesti uusi4 = new Viesti("Tämä on minun mielipiteeni", "Jaakko", "Autohullut");
//        vr.save(uusi4);
//        Viesti uusi5 = new Viesti("Tämä on minun mielipiteeni", "Jaakko", "Golfjuorut");
//        vr.save(uusi5);
//        Viesti uusi6 = new Viesti("Tämä on minun mielipiteeni", "Jaakko", "Kalajutut");
//        vr.save(uusi6);
//        Viesti uusi7 = new Viesti("Tämä on minun mielipiteeni", "Jaakko", "Leffalopinat");
//        vr.save(uusi7);
//        };
//    }

}

//	@Bean
//	CommandLineRunner sd (GolfRepo golfry, KayttajaRepo kayttajary) {
//		return (args) -> {
//			golfry.deleteAll();
//			kayttajary.deleteAll();
//		};
//	}

//	protected void luontiYksittäin(GolfRepo golfry, KayttajaRepo kayttajary) {
//		Golf o = new Golf("LentäväLammas", "kisa", "maaa maa mammaamaa");
//		Kayttaja k = new Kayttaja ("Lentävälammas", "lammas", "maaa maa ");
//		k = kayttajary.save(k);
//		o.setKayttaja(k);
//		golfry.save(o);
//		o = new Golf( "PutoavaPossu", "kisa", "Lallaaa lllaaaa");
//		o.setKayttaja(k);
//		golfry.save(o);
//	}
//}