package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display {

    private JFrame jFrame;
    private Canvas canvas;

    public Display(String title, int width, int height){
        canvas = new Canvas();
        //Tamanho preferível da nossa janela.
        canvas.setPreferredSize(new Dimension(width, height));
        //Bloqueia o tamanho máximo do canva.
        canvas.setMaximumSize(new Dimension(width, height));
        //Tamanho mínimo
        canvas.setMinimumSize(new Dimension(width, height));

        //define o título da tela
        jFrame = new JFrame(title);
        jFrame.add(canvas);
        jFrame.pack();

        //torna ela visível, que por padrão está invisível
        jFrame.setVisible(true);
        //Define a condição para parar a aplicação, neste caso, ao fechar
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Define localização relativa, com base em alguma janela de referência.
        jFrame.setLocationRelativeTo(null);
        //Define a impossibilidade do usuário redimencionar a janela.
        jFrame.setResizable(false);
    };

    public BufferStrategy getBufferStrategy(){
        return canvas.getBufferStrategy();
    };

    public void createBufferStrategy(){
        canvas.createBufferStrategy(3);
    }

    // Métodos para obter dimensões do Canvas
    public int getCanvasWidth() {
        return canvas.getWidth();
    }

    public int getCanvasHeight() {
        return canvas.getHeight();
    }
}
