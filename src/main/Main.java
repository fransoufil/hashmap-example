package main;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> mapAtletas = new HashMap<>();

        mapAtletas.put("Lionel Messi", "Futebol,130");
        mapAtletas.put("Lebron James", "Basquete,130");
        mapAtletas.put("Cristiano Ronaldo", "Futebol,115");
        mapAtletas.put("Neymar", "Futebol,95");
        mapAtletas.put("Stephen Curry", "Basquete,92");
        mapAtletas.put("Canelo Alvarez", "Boxe,90");
        mapAtletas.put("Igoudala", "Basquete,80");
        mapAtletas.put("Cassius Kley", "Boxe,110");
        mapAtletas.put("Jaqueline", "Volei,97");

        // Criar um mapa para armazenar a soma das pontuações por esporte e a contagem de atletas por esporte
        Map<String, Integer> somaPorEsporte = new HashMap<>();
        Map<String, Integer> contagemPorEsporte = new HashMap();

        //separando os valores de value em cada mapAtletas
        mapAtletas.forEach((nome, info) -> {
        	//fazendo o split com o caracter padrao de separacao
            String[] partes = info.split(",");
            if (partes.length == 2) {
            	
            	//havendo entao 2 partes dentro de value, separadas por virgula, a posicao 0 seria o nome do esporte e a posicao 1 seria o valor
                String esporte = partes[0];
                int pontuacao = Integer.parseInt(partes[1]);//ha a necessidade de conversao pois esta em formato String

                // Atualizar a soma das pontuações por esporte
                somaPorEsporte.put(esporte, somaPorEsporte.getOrDefault(esporte, 0) + pontuacao);

                // Atualizar a contagem de atletas por esporte
                contagemPorEsporte.put(esporte, contagemPorEsporte.getOrDefault(esporte, 0) + 1);
            }
        });
        
        // Exibir a soma total por esporte
        System.out.println("Soma total de pontuações por esporte:");
        for (Map.Entry<String, Integer> entry : somaPorEsporte.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        

        // Calcular a média de pontuações por esporte
        Map<String, Double> mediaPorEsporte = new HashMap<>();
        for (String esporte : somaPorEsporte.keySet()) {
            int soma = somaPorEsporte.get(esporte);
            int contagem = contagemPorEsporte.get(esporte);
            double media = (double) soma / contagem;
            mediaPorEsporte.put(esporte, media);
        }

        // Encontrar o esporte com a maior média
        String esporteMaiorMedia = mediaPorEsporte.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum esporte encontrado");
        
        // Exibir a média por esporte
        System.out.println("Média por esporte:");
        for (Map.Entry<String, Double> entry : mediaPorEsporte.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Exibir o esporte com a maior média
        System.out.println("Esporte com a maior média: " + esporteMaiorMedia);
    }
}
