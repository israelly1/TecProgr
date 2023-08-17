package com.example.damas.business;

import com.example.damas.model.Board;
import com.example.damas.model.PieceColor;
import com.example.damas.model.Piece;
import com.example.damas.view.BoardView;

public class GameEngine {
    private final BoardView boardView;

    private final Board board = new Board(new Piece[8][8]);

    public GameEngine(BoardView boardView) {
        this.boardView = boardView;
    }

    public void startGame() {
        // Creating white pieces
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 8; j++) {
                if (i == 0 || i == 2) {
                    if (j % 2 == 0) board.boardGrid()[i][j] = new Piece(PieceColor.WHITE);
                } else {
                    if (j % 2 == 1) board.boardGrid()[i][j] = new Piece(PieceColor.WHITE);
                }
            }
        }

        boardView.displayBoard(board);
    }
}
