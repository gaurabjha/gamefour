package com.skylark.model;

import javax.sound.midi.Soundbank;

public class Board {
    private final int MAXROW = 7;
    private final int MAXCOL = 6;
    private char boardMatrix[][];

    private int[] height = new int[MAXCOL];

    public Board() {
        boardMatrix = new char[MAXROW][MAXCOL];

        /*for (int row = 0; row < MAXROW; row++) {
            for (int column = 0; column < MAXCOL; column++) {
                setBoard(row, column, 'c');
            }
        }*/
    }

    public void insert(int col, char sprite) {
        if (col < MAXCOL) {
            setBoard(height[col], col, sprite);
        }
    }

    public char[][] getBoard() {
        return boardMatrix;
    }

    public Board setBoard(char[][] boardMatrix) {
        this.boardMatrix = boardMatrix;
        return this;
    }

    public char getBoard(int row, int column) {
        return boardMatrix[row][column];
    }

    public void setBoard(int row, int column, char value) {
        if (row < MAXROW && column < MAXCOL) {
            boardMatrix[row][column] = value;
        }else throw InvalidBoardPositionException("Cant fit the fall there");
    }


    @Override
    public String toString() {
    	insert(10, 'x');
        String board = "";

        for (int row = 0; row < MAXROW; row++) {
            for (int column = 0; column < MAXCOL; column++) {
                board += "|";
                if (boardMatrix[row][column] != 0) {
                    board += boardMatrix[row][column];
                } else {
                    board += " ";
                }
            }
            board += "|\n\r";
        }
        return board;
    }
}
