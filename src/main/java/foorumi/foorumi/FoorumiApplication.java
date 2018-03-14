package foorumi.foorumi;

import foorumi.foorumi.Golf.Golf;
import foorumi.foorumi.Golf.GolfRepo;
import foorumi.foorumi.Kayttaja.Kayttaja;
import foorumi.foorumi.Kayttaja.KayttajaRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoorumiApplication {

	public static void main(String[] args)	 {
		SpringApplication.run(FoorumiApplication.class, args);}


	@Bean
	CommandLineRunner (GolfRepo golfry, KayttajaRepo kayttajary) {
		return (args) -> {
			golfry.deleteAll();
			kayttajary.deleteAll();

//			luontiJoukolla(golfry);
		};
	}

	protected void luontiYksittäin(GolfRepo golfry, KayttajaRepo kayttajary) {
		Golf o = new Golf(1, "LentäväLammas", "kisa", "maaa maa mammaamaa");
		Kayttaja k = new Kayttaja ("Lentävälammas", "lammas", "maaa maa ");
		k = kayttajary.save(k);
		o.setKayttaja(k);
		golfry.save(o);
		o = new Golf(2, "PutoavaPossu", "kisa", "Lallaaa lllaaaa");
		o.setKayttaja(o);
		golfry.save(o);
	}

//	private void luontiJoukolla(GolfRepo golfRepo) {
//		List<Golf> golffareita = new ArrayList<>();
//		Golf o = new Golf(3,"TutisevaTamma", "kisa", "TikTakTikTak");
//		Kayttaja k = new Kayttaja("Lentävätassu", "tassu", "blaa blaa");
//		o.setKayttaja(k);
//		golffareita.add(o);
//		o = new Golf(4,"KostunutKana", "klubi", "dududuu");
//		o.setKayttaja(k);
//		golffareita.add(o);
//		o = new Golf(5, "KuivunutKettu", "klubi", "kaa kaa kaa");
//		o.setKayttaja(new Kayttaja("Murtunutmonni", "monni", "muu muu"));
//		golffareita.add(o);
//
//		GolfRepo.saveAll(golffareita);
//	}

}