package foorumi.foorumi;


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
	CommandLineRunner luoOppilaat (Viestirepo vr) {
		return (args) -> {
			List<Viesti> lista = new ArrayList<>();
			Viesti v = new Viesti("Kalajutut", "Turo", "Sain ison hauen");
			lista.add(v);
            Viesti v2 = new Viesti("Kalajutut", "Make", "Mun haukeni on taatusti isompi kuin sun haukesi");
            lista.add(v2);

			vr.saveAll(lista);
		};
	}
	}