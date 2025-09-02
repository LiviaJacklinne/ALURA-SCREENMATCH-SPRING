package br.com.alura.screenmatch.service;

public interface IConverteDados {
   
    // o "Class" é para dizer qual classe eu quero converter o JSON
    <T> T obterDados (String json, Class <T> classe);
}
