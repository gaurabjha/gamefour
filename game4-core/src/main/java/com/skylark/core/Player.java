package com.skylark.core;

import com.skylark.exception.InvalidBoardPositionException;

import java.util.Scanner;

public class Player {
    private final char sprite;
    private final String name;
    private final boolean isBot;

    public Player(String name, char sprite, boolean isBot) {
        this.sprite = sprite;
        this.name = name;
        this.isBot = isBot;
    }

    public Board play(Board board) {
        if (isBot) {
            //AI.play();
        } else {
            System.out.println(name + " Its your turn ");
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Where do you want to put your ball ?");
                for (int cols = 0; cols < Board.MAXCOL; cols++) {
                    if (board.getHeight()[cols] < Board.MAXROW)
                        System.out.print(" " + cols);
                    else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
                System.out.println(board);
                try {
                    board.insert(Integer.parseInt(sc.nextLine()), sprite);
                } catch (NumberFormatException nfe) {
                    System.err.println("\nInvalid Input!! - " + nfe.getMessage() + "\n");
                    continue;
                } catch (InvalidBoardPositionException ibpe) {
                    System.err.println("\nInvalid Position - " + ibpe.getMessage() + "\n");
                }
                break;
            }
        }
        return board;
    }


}
