import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    void cria() throws Exception{
        
        //Leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("omg.jpg"));

        // Criar nova imagem em memoria com transparência e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem em memória

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 24);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 0, novaAltura - 100);

        //escrever uma frase na nova imagem

        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
    }
    public static void main(String[] args) throws Exception {
       var geradora = new GeradoraDeFigurinhas();
       geradora.cria();
    }
}

