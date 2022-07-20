import netscape.javascript.JSObject;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        //Fazer conexão HTTP criar u endpoint Get e buscar os top 250 filmes

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        URI endereco =  URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String>  response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        //Extrair somente os dados que interresam (titulo, poster, cçassificação)

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);



        //Exibir e manipular os dados de forma personalizada
        var geradora = new GeradorDeFigurinhas();
        for (Map<String,String> filme : listaDeFilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            geradora.criar(inputStream, nomeArquivo);

            System.out.println(titulo);
            System.out.println();
        }
    }
}