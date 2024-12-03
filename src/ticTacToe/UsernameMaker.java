package ticTacToe;

import java.util.Scanner;

public class UsernameMaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		String[] username = new String[2];
		
		for (int i = 0; i < 2; i++) 
		{
			username[i] = s.nextLine();
			
			if(username[i].length() >= 15) 
			{
				System.out.println("Sorry, your username is too long");
				i--;
			}
		}
		
		for(String name : username) 
		{
			System.out.println(name);
		}

	}

}
