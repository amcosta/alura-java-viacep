package br.com.amcosta;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class ViaCepProvider implements CepProvider {
    private final HttpClient client;

    public ViaCepProvider() {
        this.client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(20))
            .build();
    }
    
    @Override
    public Address searchAddress(Cep cep) throws RuntimeException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(String.format("https://viacep.com.br/ws/%s/json/", cep)))
            .header("Accept", "application/json")
            .GET()
            .build();

        try {
            HttpResponse<String> response = this.client.send(request, BodyHandlers.ofString());
            return Address.fromJson(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao fazer a requisição: " + e.getMessage(), e);
        }
    }
}
