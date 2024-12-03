package ticTacToe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("Please input your usernames.");
		
		String[] username = new String[2]; 
		
		for (int i = 0; i < 2; i++) 
		{
			System.out.print("Player" + (i+1) + " name: ");
			
			username[i] = s.nextLine();
			
			if(username[i].length() >= 15) 
			{
				System.err.println("Sorry, your username is too long. Please input a username shorter than 15 characters.");
				i--;
			}
		}
		
		int chosenToFlip = r.nextInt(username.length)+1;
		int theChosen = r.nextInt(2)+1;
		String firstPlayer = "", secondPlayer = "";
		
		if(chosenToFlip == 1) 
		{
			firstPlayer = username[0];
			secondPlayer = username[1];
		}
		else if(chosenToFlip == 2) 
		{
			firstPlayer = username[1];
			secondPlayer = username[0];
		}
		
		System.out.println(username[chosenToFlip] + " will flip the coin.");
		
		boolean flipping = true;
		
		while(flipping) 
		{
			System.out.println();
			
			int need = 0;
			
			try 
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
			
			switch(need) 
			{
				case 1:
					switch(theChosen) 
					{
					case 1:
						System.out.println("You got heads! " + username[chosenToFlip] + " shall start.");
						flipping = false;
						break;
					
					case 2:
						System.out.println("Oof! You got tails, the opposing player shall start.");
						flipping = false;
						break;
					}
					break;
					
				case 2:
					switch(theChosen) 
					{
					case 1:
						System.out.println("Oof! You got heads, the opposing player shall start.");
						flipping = false;
						break;
					
					case 2:
						System.out.println("You got tails! " + username[chosenToFlip] + " shall start.");
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
		
		while(theGame) 
		{
			char[][] table = 
				{
						{'·', '·', '·'},
						{'·', '·', '·'},
						{'·', '·', '·'}
				};
			int file = 0, column = 0;
			boolean tryCatching = true;
			
			System.out.println();
			
			for(int i = 0; i < table.length; i++) //Double for (And what the teacher wanted)
			{
				for(int j = 0; j < table[i].length; j++) 
				{
					System.out.print(table[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.println(firstPlayer + "'s turn");
			
			while(tryCatching) 
			{
				try 
				{
					System.out.print("Choose a value from 0 to 2 for the file:");
					file = s.nextInt();
					s.nextLine();
					
					if(file <= 2) 
					{
						tryCatching = false;
					}
					else 
					{
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

		}
		
	}
}