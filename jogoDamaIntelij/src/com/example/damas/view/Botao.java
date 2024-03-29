package com.example.damas.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botao implements ActionListener {

    private ImageIcon icon;
    private BoardView boardView;
    private JButton botao;

    public Botao(JButton botao, BoardView boardView) {
        this.botao = botao;
        this.boardView = boardView;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public BoardView getTabuleiro() {
        return boardView;
    }

    public void setTabuleiro(BoardView boardView) {
        this.boardView = boardView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
