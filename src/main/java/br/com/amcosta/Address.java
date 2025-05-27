package br.com.amcosta;

import com.google.gson.Gson;

public record Address(
    String cep,
    String logradouro,
    String complemento,
    String unidade,
    String bairro,
    String localidade,
    String uf,
    String estado,
    String regiao,
    String ibge,
    String gia,
    String ddd,
    String siafi
) {

    public static Address fromJson(String json) {
        return (new Gson()).fromJson(json, Address.class);
    } 

    @Override
    public String toString() {
        return String.format("""
            Endereço:
            -----------
            CEP: %s
            Rua: %s
            Bairro: %s
            Cidade: %s
            Estado: %s
            """, cep, logradouro, bairro, localidade, estado);
    }
}
