package com.example.damas;

import com.example.damas.business.GameEngine;
import com.example.damas.view.BoardView;
import com.example.damas.view.GameWindow;

public class Main {
    public static void main(String[] args) {
        BoardView boardView = new BoardView();

        GameWindow gameWindow = new GameWindow("Jogo de Damas", boardView);
        GameEngine gameEngine = new GameEngine(boardView);

        gameEngine.startGame();

        gameWindow.setVisible(true);
    }
}
