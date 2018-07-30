/**
 * 
 */
package com.training.objectOrientedProgramming;

import java.util.Queue;

import com.training.sampleClassTypes.Player;
import com.training.utility.InputScanner;

/**
 * @author bridgelabz
 *
 */
public class DeckOfCards {
	
	private static int[][] cards;
	private static String[] playerCards;
	
	public DeckOfCards(){
		cards = new int[5][15];
	}
	
	public static String[] getPlayerCards(){
		return playerCards;
	}
	
	public static String distributeCard(){
		int suit;
		int rank;
		do{
			suit = InputScanner.findRandomWithRange(1,4);
			rank = InputScanner.findRandomWithRange(2, 14);
		}while( cards[ suit ][ rank ] == 1);
		cards[suit][rank] = 1;
		return suit + "-" + rank;
	}
	
	
	public static void viewPlayerCards(int eachPlayer){
			
		playerCards = new String[eachPlayer];
	
		for(int i=0;i<eachPlayer;i++){
			String cardReceived = distributeCard();
//			playerCards[i] = 	suit[Integer.valueOf(cardReceived.substring(0,1))].substring(0,1) + rank[Integer.valueOf(cardReceived.substring(2,cardReceived.length()))];
			playerCards[i] = cardReceived;
		}
	}
	
	public void playCards(){
		System.out.println("Enter total players, and cards you want to distribute to each player!");
		InputScanner inSc = new InputScanner();
		int totalPlayers;
		int eachPlayer;
		do{
			totalPlayers = inSc.inputInteger();
			eachPlayer = inSc.inputInteger();
		}while(totalPlayers * eachPlayer > 108);
		
		String displayArray[][] = new String[totalPlayers][eachPlayer];
		
		for(int i = 1; i <= totalPlayers; i++ ){
			viewPlayerCards(eachPlayer);
			for(int j = 1; j <= eachPlayer ; j++){
				displayArray[i-1][j-1] = playerCards[j];  
			}
		}
		
		InputScanner.displayArray(displayArray, totalPlayers, eachPlayer);
		
	}
	
	public void playGame(){
		System.out.println("Enter total players, and cards you want to distribute to each player!");
		InputScanner inSc = new InputScanner();
		int totalPlayers;
		int eachPlayer;
		do{
			totalPlayers = inSc.inputInteger();
			eachPlayer = inSc.inputInteger();
		}while(totalPlayers * eachPlayer > 108);
		
		Queue<Player> playerList = null ;
		
		
		for(int i=0;i<totalPlayers;i++){
			Player player = new Player();
			System.out.println("Enter your name !");
			player.setFirstName(inSc.inputString());
			playerList.add(player);
		}
		
		for(int i=0;i<totalPlayers;i++){
				Player currentPlayer = new Player();
				currentPlayer = playerList.peek();
				playerList.remove();
				viewPlayerCards(eachPlayer);
				currentPlayer.setPersonalCards(this.playerCards);
				currentPlayer.setCardQueue();
				playerList.add(currentPlayer);
		}
		
	while(!playerList.isEmpty()){
		Player currentPlayer = new Player();
		System.out.println("Hi  " + currentPlayer.getFirstName());
		System.out.println("Your deck of Cards is ----");
		while(!currentPlayer.getCardQueue().isEmpty()){
			
		}
		
	}
		
	}
}