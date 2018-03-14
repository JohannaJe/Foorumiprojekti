package foorumi.foorumi;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoorumiApplication {

	public static void main(String[] args)	 {
		SpringApplication.run(FoorumiApplication.class, args);}}

//	@Bean
//	CommandLineRunner demo ()




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