package main;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TesteHashMap {
    public static void main(String[] args) {
    	
    	//DESCRICAO DO PROBLEMA
    	//Dado o seguinte HashMap, devera exibir:
    	//I- A soma total por esporte
    	//II- A media de cada esporte
    	//III- O nome do esporte com a maior media
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

        // 1. Criar um mapa para armazenar a soma das pontuações por esporte 
        //e outro para a contagem de atletas por esporte
        Map<String, Integer> somaPorEsporte = new HashMap<>();
        Map<String, Integer> contagemPorEsporte = new HashMap();

        //2. separando as partes do value de cada mapAtletas
        mapAtletas.forEach((nome, info) -> {
        	//2.1 fazendo o split com o caracter padrao de separacao
            String[] partes = info.split(",");
            //2.2 testando se ha duas partes dentro da String value -> info
            if (partes.length == 2) {
            	
            	//2.3 havendo entao 2 partes dentro de value, separadas por virgula, 
            	//a posicao 0 seria o nome do esporte e a posicao 1 seria o valor
                String esporte = partes[0];
              //2.4 ha a necessidade de conversao da segunda posicao pois esta em formato String
                int pontuacao = Integer.parseInt(partes[1]);

                // 3. atualizar a soma das pontuações por esporte
                somaPorEsporte.put(esporte, somaPorEsporte.getOrDefault(esporte, 0) + pontuacao);

                // 4. Atualizar a contagem de frequencia de cada esporte
                contagemPorEsporte.put(esporte, contagemPorEsporte.getOrDefault(esporte, 0) + 1);
            }
        });
        
        //I- Exibir a soma total por esporte
        System.out.println("Soma total de pontuações por esporte:");
        for (Map.Entry<String, Integer> entry : somaPorEsporte.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        

        //5. Calcular a média de pontuações por esporte
        Map<String, Double> mediaPorEsporte = new HashMap<>();
        for (String esporte : somaPorEsporte.keySet()) {
            int soma = somaPorEsporte.get(esporte);
            int contagem = contagemPorEsporte.get(esporte);
            double media = (double) soma / contagem;
            mediaPorEsporte.put(esporte, media);
        }

        //6.  Encontrar o esporte com a maior média
        String esporteMaiorMedia = mediaPorEsporte.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum esporte encontrado");
        
        //II- Exibir a média por esporte
        System.out.println("Média por esporte:");
        for (Map.Entry<String, Double> entry : mediaPorEsporte.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //III- Exibir o esporte com a maior média
        System.out.println("Esporte com a maior média: " + esporteMaiorMedia);
    }
}
