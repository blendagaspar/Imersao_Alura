import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class GeradorDeFigurinhas {

   public void criar (InputStream inputStream, String nomeArquivo) throws IOException {

       // leitura da imagem
       // InputStream inputStream = new FileInputStream((new File("imagens/filmes.jpg")));
       //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
       //                       .openStream();
       BufferedImage imagemOriginal = ImageIO.read(inputStream);

     //cria nova imagem em memória com transparencia e com tamanho novo
     int largura = imagemOriginal.getWidth();
     int altura = imagemOriginal.getHeight();
     int novaAltura = altura + 200;
     BufferedImage novaImagem =  new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
     //copiar a imagem original para nova imagem

     Graphics graphics = (Graphics2D) novaImagem.getGraphics();
     graphics.drawImage(imagemOriginal,0, 0,null);

     //configurar a fonte
     graphics.setColor(Color.green);
     var fonte = new Font(Font.SERIF, Font.BOLD, 32);
     graphics.setFont(fonte);

     //Escrever uma frase na nova imagem
     graphics.drawString("TOPZERA", 0 , novaAltura-100);

     //escrever a nova imagem em um arquivo
     ImageIO.write(novaImagem, "png", new File(nomeArquivo));

   }

}
