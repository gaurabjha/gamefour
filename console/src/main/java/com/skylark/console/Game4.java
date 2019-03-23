package com.skylark.console;

import com.skylark.model.Board;

import java.util.Scanner;

public class Game4 {
    private static Scanner scanner = null;

    public static void main(String[] args) {
        try {
            scanner = new Scanner(System.in);

            System.out.println("======================================");
            System.out.println("\t\tWelcome to Game4\t\t");
            System.out.println("======================================\n");
            printMainMenu();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                scanner.close();
            } finally {
            }
        }
    }

    public static void printMainMenu() {

        while (true) {
            try {
                System.out.println("===============Game4================");

                System.out.println("1. Double Player");
                System.out.println("2. Single Player - Play with Computer");
                System.out.println("3. Exit Game");
                System.out.println();
                System.out.print("Enter Your Choice : ");
                Board board;
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        System.out.println("Choice 1");
                        break;
                    case 2:
                        System.out.println("Choice 2");
                        break;
                    case 3:
                        System.out.println("Thanks for playing Game4\n" + "Developed by Skylark");
                        System.exit(0);
                    default:
                        System.err.println("Invalid Choice, Try again!!!\n");
                }

                board = new Board();

                int result= 0;
                while (result == 0) {
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
                        board.insert(Integer.parseInt(scanner.nextLine()), 'c');
                    } catch (NumberFormatException nfe) {
                        System.err.println("\nInvalid Input!!\n");
                    }

                    result = board.checkResult();

                }

            } catch (NumberFormatException nfe) {
                System.err.println("\nInvalid Input!!\n");
            }

        }

    }

}
