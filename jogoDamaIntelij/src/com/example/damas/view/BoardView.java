package com.example.damas.view;

import com.example.damas.model.Board;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardView extends JPanel {

    private ImageIcon icon;

    public BoardView() {
        this.setLayout(new GridLayout(8, 8));
    }

    public void montarTabuleiro() {
        boolean preta = true;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                JButton botao = new JButton();

                botao.addActionListener(new Botao(botao, this));

                if (preta) {
                    botao.setBackground(Color.black);
                    preta = false;
                    if (i == 0 || i == 1) {
                        icon = new ImageIcon("images/pretas.png");
                        botao.setIcon(icon);
                    } else {
                        if (i == 5 || i == 6) {
                            icon = new ImageIcon("images/brancas.png");
                            botao.setIcon(icon);
                        }
                    }
                    this.add(botao);
                } else {
                    botao.setBackground(Color.white);
                    preta = true;
                    this.add(botao);
                }
            }
        }
    }

    public void displayBoard(Board board) {
        // Mostrar board na tela
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

}
