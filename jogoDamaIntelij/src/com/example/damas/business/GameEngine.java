package com.example.damas.business;

import com.example.damas.model.Board;
import com.example.damas.model.Piece;
import com.example.damas.view.BoardView;

public class GameEngine {
    private BoardView boardView;

    private Board board = new Board(new Piece[8][8]);

    public GameEngine(BoardView boardView) {
        this.boardView = boardView;
    }

    public void startGame() {
        // Montar o tabuleiro em GameEngine
        // boardView.montarTabuleiro();

        // Depois de montar o tabuleiro
        boardView.displayBoard(board);
    }
}
