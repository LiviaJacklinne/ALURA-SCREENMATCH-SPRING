package br.com.alura.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmatch.main.Main;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n");

		Main main = new Main();
		main.exibeMenu();



		// ConsumoApi consumoApi = new ConsumoApi();
		// String json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=ff118bc7");
		// ConverteDados conversor = new ConverteDados();
		// DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
		// System.out.println(dadosSerie);


		
		System.out.println("\n");

	}
}
