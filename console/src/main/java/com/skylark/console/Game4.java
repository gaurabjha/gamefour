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
					// doublePlayer();
					board = new Board();
					System.out.println(board);
					break;
				case 2:
					System.out.println("Choice 2");
					// singlePlayer();
					board = new Board();
					System.out.println(board);
					break;
				case 3:
					System.out.println("Thanks for playing Game4\n" + "Developed by Skylark");
					System.exit(0);
				default:
					System.out.println("Invalid Choice, Try again!!!\n");
				}

			} catch (NumberFormatException nfe) {
				System.out.println("\nInvalid Input!!\n");
			}

		}

	}

}
