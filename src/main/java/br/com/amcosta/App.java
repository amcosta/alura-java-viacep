package br.com.amcosta;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.print( "Informe o CEP que deseja pesquisar: " );
        CepProvider provider = new ViaCepProvider();
        
        try {
            Cep cep = new Cep(input.nextLine());
            Address address = provider.searchAddress(cep);
            System.out.println(address);
        } catch (IllegalArgumentException e) {
            System.out.println("CEP inválido: " + e.getMessage());
            return;
        } finally {
            input.close();
        }

        System.out.println("programa finalizado com sucesso!");
    }
}
