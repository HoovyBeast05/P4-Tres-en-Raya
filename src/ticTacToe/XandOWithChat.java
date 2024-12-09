//I put my entire code into chatGPT to look for errors and then it revealed a fixed version, as I don't understand functions I didn't go for chat's route

package ticTacToe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class XandOWithChat {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        
        System.out.println("Please input your usernames.");
        
        String[] username = new String[2]; 
        
        for (int i = 0; i < 2; i++) {
            System.out.print("Player" + (i+1) + " name: ");
            username[i] = s.nextLine();
            
            if(username[i].length() >= 15) {
                System.err.println("Sorry, your username is too long. Please input a username shorter than 15 characters.");
                i--;
            }
        }
        
        int chosenToFlip = r.nextInt(username.length) + 1;
        int theChosen = r.nextInt(2) + 1;
        String firstPlayer = "", secondPlayer = "";
        
        System.out.println(username[chosenToFlip - 1] + " will flip the coin.");
        
        boolean flipping = true;
        
        while(flipping) {
            System.out.println();
            int need = 0;
            
            try {
                System.out.println("Select 1 for heads, 2 for tails.");
                need = s.nextInt();
                s.nextLine();
            } catch(InputMismatchException e) {
                System.err.println(e.toString());
                System.err.println("PLEASE SELECT A NUMBER FROM 1 TO 2.");
                s.nextLine();
            }
            
            switch(need) {
                case 1:
                    switch(theChosen) {
                        case 1:
                            System.out.println("You got heads! " + username[chosenToFlip - 1] + " shall start.");
                            firstPlayer = username[chosenToFlip - 1];
                            secondPlayer = username[chosenToFlip % 2];
                            flipping = false;
                            break;
                        
                        case 2:
                            System.out.println("Oof! You got tails, the opposing player shall start.");
                            secondPlayer = username[chosenToFlip - 1];
                            firstPlayer = username[chosenToFlip % 2];
                            flipping = false;
                            break;
                    }
                    break;
                    
                case 2:
                    switch(theChosen) {
                        case 1:
                            System.out.println("Oof! You got heads, the opposing player shall start.");
                            secondPlayer = username[chosenToFlip - 1];
                            firstPlayer = username[chosenToFlip % 2];
                            flipping = false;
                            break;
                        
                        case 2:
                            System.out.println("You got tails! " + username[chosenToFlip - 1] + " shall start.");
                            firstPlayer = username[chosenToFlip - 1];
                            secondPlayer = username[chosenToFlip % 2];
                            flipping = false;
                            break;
                    }
                    break;
                    
                default:
                    System.err.println("PLEASE SELECT A NUMBER FROM 1 TO 2.");
                    continue;
            }
        }
        
        boolean theGame = true;
        char[][] table = {
            {'·', '·', '·'},
            {'·', '·', '·'},
            {'·', '·', '·'}
        };
        
        
        while(theGame) {
            // Display the board
            printBoard(table);
            
            // Check for winner or draw after each move
            if (checkWinner(table, 'X')) {
                System.out.println("Player 1 (X) wins!");
                theGame = false;
                break;
            } else if (checkWinner(table, 'O')) {
                System.out.println("Player 2 (O) wins!");
                theGame = false;
                break;
            } else if (isDraw(table)) {
                System.out.println("It's a draw!");
                theGame = false;
                break;
            }
            
            // Player 1's turn
            System.out.println(firstPlayer + "'s turn");
            // (player 1's move logic goes here)
            
            // After player 1's move, check for winner or draw

            // Player 2's turn
            System.out.println(secondPlayer + "'s turn");
            // (player 2's move logic goes here)
            
            // After player 2's move, check for winner or draw
        }
    }

    // Method to check for a winner ('X' or 'O')
    private static boolean checkWinner(char[][] table, char player) {
        // Check rows and columns for the same character
        for (int i = 0; i < 3; i++) {
            if ((table[i][0] == player && table[i][1] == player && table[i][2] == player) || 
                (table[0][i] == player && table[1][i] == player && table[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals for the same character
        if ((table[0][0] == player && table[1][1] == player && table[2][2] == player) || 
            (table[0][2] == player && table[1][1] == player && table[2][0] == player)) {
            return true;
        }

        return false;
    }

    // Method to check if the game is a draw
    private static boolean isDraw(char[][] table) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == '·') {
                    return false; // Found an empty spot, so it's not a draw yet
                }
            }
        }
        return true; // All spots are filled and no winner found
    }

    // Helper method to print the current board
    private static void printBoard(char[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
