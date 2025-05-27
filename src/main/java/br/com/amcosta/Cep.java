package br.com.amcosta;

public class Cep {
    String cep;

    public Cep(String cep) {
        cep = cep.replaceAll("\\D", "");
        if (cep.length() != 8) {
            throw new IllegalArgumentException("O CEP informando não é válido");
        }

        this.cep = cep;
    }

    @Override
    public String toString() {
        return this.cep;
    }
}
