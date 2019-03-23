package com.skylark.core;

import com.skylark.exception.InvalidBoardPositionException;


public class Board {
    public static final int MAXROW = 7;
    public static final int MAXCOL = 6;
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

    public int[] getHeight() {
        return height;
    }

    public void insert(int col, char sprite) throws InvalidBoardPositionException {
        if (col < MAXCOL && height[col] < MAXROW) {
            height[col] += 1;
            setBoard(MAXROW - height[col], col, sprite);
        } else
            throw new InvalidBoardPositionException("Invalid Column Entered");
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

    public void setBoard(int row, int column, char value) throws InvalidBoardPositionException {
        if (row < MAXROW && column < MAXCOL) {
            boardMatrix[row][column] = value;
        } else throw new InvalidBoardPositionException("Cant fit the ball there");
    }


    @Override
    public String toString() {
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

    public int checkWinner() {
        return 0;
    }

    private int checkDraw() {
        int boxFull = 0;
        for (int col = 0; col < MAXCOL; col++) {
            boxFull += height[col];
        }
        if (boxFull == MAXCOL * MAXROW) {
            System.out.println("================Game Draw!!================");
            return 1;
        }
        return 0;
    }

    public int checkResult() {
        int result = 0;
        result += checkDraw();
        result += checkWinner();
        return result;
    }
}
