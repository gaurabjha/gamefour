package com.skylark.console;

import com.skylark.core.Board;
import com.skylark.core.Player;

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
                Player player_one = null;
                Player player_two = null;
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        System.out.println("Choice 1");
                        System.out.println("Enter Player 1 Name :");
                        player_one = new Player(scanner.nextLine(), 'x', false);
                        System.out.println("Enter Player 2 Name :");
                        player_two = new Player(scanner.nextLine(), 'o', false);
                        break;
                    case 2:
                        System.out.println("Choice 2");
                        System.out.println("Enter Player Name :");
                        player_one = new Player(scanner.nextLine(), 'x', false);
                        player_two = new Player("Computer", '0', true);
                        break;
                    case 3:
                        System.out.println("Thanks for playing Game4\n" + "Developed by Skylark");
                        System.exit(0);
                    default:
                        System.err.println("Invalid Choice, Try again!!!\n");
                }

                board = new Board();

                int result = 0;

                while (result == 0) {
                    board.setBoard(player_one.play(board).getBoard());
                    board.setBoard(player_two.play(board).getBoard());
                    result = board.checkResult();
                }

            } catch (NumberFormatException nfe) {
                System.err.println("\nInvalid Input!!\n");
            }

        }

    }

}
