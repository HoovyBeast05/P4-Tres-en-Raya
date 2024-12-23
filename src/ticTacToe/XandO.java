package ticTacToe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class XandO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("Please input your usernames.");
		
		//I create a string array that with a max value of 2, this is for the the player's usernames
		String[] username = new String[2]; 
		
		for (int i = 0; i < 2; i++) 
		{
			System.out.print("Player" + (i+1) + " name: ");
			
			username[i] = s.nextLine();
			
			if(username[i].length() >= 15) //I put a limit on 15 characters
			{
				System.err.println("Sorry, your username is too long. Please input a username shorter than 15 characters.");
				i--;
			}
		}
		
		int chosenToFlip = r.nextInt(username.length)+1;//I create two random integer generators that select from 1 to 2
		int theChosen = r.nextInt(2)+1;
		String firstPlayer = "", secondPlayer = "";//Here I initialise 2 strings, one string being player1, and the other being player2
		
		System.out.println(username[chosenToFlip - 1] + " will flip the coin.");//Here the player selected by the random integer generator will flip a coin
		
		boolean flipping = true;
		
		while(flipping) 
		{
			System.out.println();
			
			int need = 0;//This integer is for the result of the heads or tails
			
			try //Here i implement a try catch to catch value that isn't integers
			{
				System.out.println("Select 1 for heads, 2 for tails.");
				need = s.nextInt();
				s.nextLine();
			}
			catch(InputMismatchException e)
			{
				System.err.println(e.toString());
				System.err.println("PLEASE SELECT A NUMBER FROM 1 TO 2.");
				s.nextLine();
			}
			
			switch(need) //This switch case is rather simple, it takes the value of the coin bet, and compares it to the randomly generated integer of the coin, being a true 50/50 between 1 and 2. 
			{
				case 1:
					switch(theChosen) 
					{
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
					switch(theChosen) 
					{
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
		
		boolean continu = true; //This boolean will initiate the game
		int choosing = 0, player1win = 0, player2win = 0; //Choosing is for if the player wants to continue or not, and player1Win and player2Win are win counters that increase after every player win.
		
		while(continu) 
		{
			boolean theGame = true;
		
			char[][] table = 
				{
						{'·', '·', '·'},
						{'·', '·', '·'},
						{'·', '·', '·'}
				};
			
			int file = 0, column = 0, theWinner = 0;
			boolean selecting = true;
			boolean tryCatching = true;
			boolean draw = true;
			
			while(theGame) 
			{
				System.out.println();
				
				for(int i = 0; i < table.length; i++)
				{
					for(int j = 0; j < table[i].length; j++) 
					{
						System.out.print(table[i][j] + " ");
					}
					System.out.println();
				}
	
				System.out.println();
				System.out.println(firstPlayer + "'s turn");
				
				while(selecting) 
				{
					while(tryCatching) 
					{
						try 
						{
							System.out.print("Choose a value from 0 to 2 for the file:");
							file = s.nextInt();
							s.nextLine();
							
							if(file <= 2 && file >= 0) 
							{
								break;
							}
							else 
							{
								System.err.println("VALUE OVERLOAD");
								System.out.print("Choose a value from 0 to 2 for the file:");
								file = s.nextInt();
								s.nextLine();
							}
						}
						catch(InputMismatchException e) 
						{
							System.err.println(e.toString());
							s.nextLine();
						}
					}
					
					while(tryCatching) 
					{
						try 
						{
							System.out.print("Choose a value from 0 to 2 for the column:");
							column = s.nextInt();
							s.nextLine();
							
							if(column <= 2 && column >= 0) 
							{
								break;
							}
							else 
							{
								System.err.println("VALUE OVERLOAD");
								System.out.print("Choose a value from 0 to 2 for the file:");
								column = s.nextInt();
								s.nextLine();
							}
						}
						catch(InputMismatchException e) 
						{
							System.err.println(e.toString());
							s.nextLine();
						}
					}
					
					if(table[file][column] == 'X' || table[file][column] == 'O') 
					{
						System.out.println("Sorry, please retry");
					}
					else 
					{
						table[file][column] = 'X';
						break;
					}
				}
				
				System.out.println();
				
				for(int i = 0; i < table.length; i++) //Double for (And what the teacher wanted)
				{
					for(int j = 0; j < table[i].length; j++) 
					{
						System.out.print(table[i][j] + " ");
					}
					System.out.println();
				}
				
				System.out.println();
				
				for(int i = 0; i < table.length; i++) 
				{
					if(table[i][0] == 'X' && table[i][1] == 'X' && table[i][2] == 'X') 
					{
						theGame = false;
						player1win++;
						theWinner = 1;
						break;
					}
					else if(table[0][i] == 'X' && table[1][i] == 'X' && table[2][i] == 'X') 
					{
						theGame = false;
						player1win++;
						theWinner = 1;
						break;
					}
					else if(table[i][0] == 'O' && table[i][1] == 'O' && table[i][2] == 'O') 
					{
						theGame = false;
						player2win++;
						theWinner = 2;
						break;
					}
					else if(table[0][i] == 'O' && table[1][i] == 'O' && table[2][i] == 'O') 
					{
						theGame = false;
						player2win++;
						theWinner = 2;
						break;
					}
				}
				if(!theGame) 
				{
					break;
				}
				
				if(table[0][0] == 'X' && table[1][1] == 'X' && table[2][2] == 'X' || table[2][0] == 'X' && table[1][1] == 'X' && table[0][2] == 'X') 
				{
					theGame = false;
					player1win++;
					theWinner = 1;
				}
				else if(table[0][0] == 'O' && table[1][1] == 'O' && table[2][2] == 'O' || table[2][0] == 'O' && table[1][1] == 'O' && table[0][2] == 'O') 
				{
					theGame = false;
					player2win++;
					theWinner = 2;
				}
				
				draw = true;
				for(int i = 0; i < table.length; i++) 
				{
					for(int j = 0; j < table[i].length; j++) 
					{
						if(table[i][j] == '·') 
						{
							draw = false;
			            }
					}
					if(!draw) 
					{
						break;
					}
				}
                if(draw) 
                {
                    System.out.println("It's a draw!");
                    theGame = false;
                    break;
                }
				
				System.out.println(secondPlayer + "'s turn");
				
				while(selecting) 
				{
					while(tryCatching) 
					{
						try 
						{
							System.out.print("Choose a value from 0 to 2 for the file:");
							file = s.nextInt();
							s.nextLine();
							
							if(file <= 2 && file >= 0) 
							{
								break;
							}
							else 
							{
								System.err.println("VALUE OVERLOAD");
								System.out.print("Choose a value from 0 to 2 for the file:");
								file = s.nextInt();
								s.nextLine();
							}
						}
						catch(InputMismatchException e) 
						{
							System.err.println(e.toString());
							s.nextLine();
						}
					}
					
					while(tryCatching) 
					{
						try 
						{
							System.out.print("Choose a value from 0 to 2 for the column:");
							column = s.nextInt();
							s.nextLine();
							
							if(column <= 2 && column >= 0) 
							{
								break;
							}
							else 
							{
								System.err.println("VALUE OVERLOAD");
								System.out.print("Choose a value from 0 to 2 for the file:");
								column = s.nextInt();
								s.nextLine();
							}
						}
						catch(InputMismatchException e) 
						{
							System.err.println(e.toString());
							s.nextLine();
						}
					}
					
					if(table[file][column] == 'X' || table[file][column] == 'O') 
					{
						System.out.println("Sorry, please retry");
					}
					else 
					{
						table[file][column] = 'O';
						break;
					}
				}
				
				for(int i = 0; i < table.length; i++) 
				{
					if(table[i][0] == 'X' && table[i][1] == 'X' && table[i][2] == 'X') 
					{
						theGame = false;
						player1win++;
						theWinner = 1;
						break;
					}
					else if(table[0][i] == 'X' && table[1][i] == 'X' && table[2][i] == 'X') 
					{
						theGame = false;
						player1win++;
						theWinner = 1;
						break;
					}
					else if(table[i][0] == 'O' && table[i][1] == 'O' && table[i][2] == 'O') 
					{
						theGame = false;
						player2win++;
						theWinner = 2;
						break;
					}
					else if(table[0][i] == 'O' && table[1][i] == 'O' && table[2][i] == 'O') 
					{
						theGame = false;
						player2win++;
						theWinner = 2;
						break;
					}
				}
				if(!theGame) 
				{
					break;
				}
				
				if(table[0][0] == 'X' && table[1][1] == 'X' && table[2][2] == 'X' || table[2][0] == 'X' && table[1][1] == 'X' && table[0][2] == 'X') 
				{
					theGame = false;
					player1win++;
					theWinner = 1;
				}
				else if(table[0][0] == 'O' && table[1][1] == 'O' && table[2][2] == 'O' || table[2][0] == 'O' && table[1][1] == 'O' && table[0][2] == 'O') 
				{
					theGame = false;
					player2win++;
					theWinner = 2;
				}
			}
			
			System.out.println();
			if(theWinner == 1) 
			{
				System.out.println("The winner is " + firstPlayer + "!");
			}
			else if(theWinner == 2) 
			{
				System.out.println("The winner is " + secondPlayer + "!");
			}
			
			System.out.println("Do you wanna play more tictactoe? Type 1 to continue and 2 to end.");
			choosing = s.nextInt();
			
			while(choosing != 1 || choosing != 2) 
			{
				if(choosing == 1) 
				{
					break;
				}
				else if(choosing == 2) 
				{
					break;
				}
				
				System.out.println("Do you wanna play more tictactoe? Type 1 to continue and 2 to end.");
				choosing = s.nextInt();
			}
			if(choosing == 1) 
			{
				continue;
			}
			else if(choosing == 2) 
			{
				System.out.println("Goodnight folks!");
				System.out.println("Player 1 won " + player1win + " times");
				System.out.println("Player 2 won " + player2win + " times");
				break;
			}
		}
	}
}