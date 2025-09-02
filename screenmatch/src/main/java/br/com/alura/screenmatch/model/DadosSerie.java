package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie (@JsonAlias("Title") String titulo, 
                        @JsonAlias("totalSeasons")Integer totalTemporadas,
                        @JsonAlias("imdbRating") String avaliacao) {
    
    /*
    * JsonAlias serve apenas para mapear o dado da API;
    * JsonProperty além de mapear o dado da API, ele também altera o nome do atributo na classe;
    */
    
}
