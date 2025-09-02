package br.com.alura.screenmatch.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

public class Main {

    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=ff118bc7";

    public void exibeMenu() {

        System.out.print("Digite o nome da série que deseja buscar: ");
        String nomeSerie = sc.nextLine().replace(" ", "+"); // substitui espaços por '+'
        var json = consumoApi.obterDados(ENDERECO + nomeSerie + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumoApi.obterDados(ENDERECO + nomeSerie + "&season=" + i + API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		
		// printa as temporadas
        /*
         * o método abaixo é uma função lambda equivalente a 'temporadas.forEach(t -> System.out.println(t));'
         * e o 't' é como se fosse o 'for' que percorre cada elemento da lista temporadas,
         * nesse caso estamos usando o t e printando o t (um único elemento), então podemos usar ::
         */
		temporadas.forEach(System.out::println);

        // uma outra forma de fazer o forEach printando dois elementos, como se fosse "linha x coluna"
        /*
         * nesse caso estamos acessando as temporadas, e para cada temporada (t) estamos acessando os episódios
         * e dentro de cada episódio (e) estamos acessando o título
         * o que seria equivalente a:
         * 
         * for(int i = 0; i < dados.totalTemporadas; i++) {
         *   List<DadosEpisodio> episodios = temporadas.get(i).episodios();
         *   for(int j = 0; j < episodios.size(); j++) {
         *     String titulo = episodios.get(j).titulo();
         *   }
         * }
         */
        temporadas.forEach(t -> t.episodios().forEach(e -> e.titulo()));
    }
    
}
