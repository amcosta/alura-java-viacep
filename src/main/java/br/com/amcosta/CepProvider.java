package br.com.amcosta;

public interface CepProvider {
    public Address searchAddress(Cep cep) throws RuntimeException;
}
