package com.example.damas.view;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

    public GameWindow(
        String title,
        BoardView boardView
    ) {
        this.add(boardView);

        this.setTitle(title);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);
    }

}
