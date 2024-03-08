package tic_tack_toe;

import java.util.Scanner;

public class tictacktoe {

	private players player1, player2;
	private board board;

	public static void main(String args[]){
		tictacktoe t = new tictacktoe();
		t.startGame();
	}

	public void startGame(){
		Scanner s = new Scanner(System.in);
		// Players input
		player1 = takePlayerInput(1);
		player2 = takePlayerInput(2);
		while(player1.getSymbol() == player2.getSymbol()){
			System.out.println("Symbol Already taken !! Pick another symbol !!");
			char symbol = s.next().charAt(0);
			player2.setSymbol(symbol);
		}
		// Create Board
		board = new board(player1.getSymbol(), player2.getSymbol());
		// Conduct the Game
		boolean player1Turn = true;
		int status = board.INCOMPLETE;
		while(status == board.INCOMPLETE || status == board.INVALID){  
			if(player1Turn){
				System.out.println("Player 1 - " + player1.getName() + "'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				 status =  board.move(player1.getSymbol(), x, y);
				if(status != board.INVALID){
					player1Turn = false;
					board.print();
				}else{
					System.out.println("Invalid Move !! Try Again !!");
				}
			}else{
					System.out.println("Player 2 - " + player2.getName() + "'s turn");
					System.out.println("Enter x: ");
					int x = s.nextInt();
					System.out.println("Enter y: ");
					int y = s.nextInt();
					 status =  board.move(player2.getSymbol(), x, y);
					if(status != board.INVALID){
						player1Turn = true;
						board.print();
					}else{
						System.out.println("Invalid Move !! Try Again !!");
					}				
			}
		}
		
		if(status == board.PLAYER_1_WINS){
			System.out.println("Player 1 - " + player1.getName() +" wins !!");
		}else if(status == board.PLAYER_2_WINS){
			System.out.println("Player 2 - " + player2.getName() +" wins !!");
		}else{
			System.out.println("Draw !!");
		}
	}

	private players takePlayerInput(int num){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Player " + num + " name: ");
		String name = s.nextLine();
		System.out.println("Enter Player " + num + " symbol: ");
		char symbol = s.next().charAt(0);
		players p = new players(name, symbol);
		return p;	
	}

}