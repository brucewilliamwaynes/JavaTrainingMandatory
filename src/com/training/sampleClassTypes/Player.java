/**
 * 
 */
package com.training.sampleClassTypes;

import java.util.Queue;

import com.training.utility.CommonAlgorithms;

/**
 * @author bridgelabz
 *
 */
public class Player {
	private String firstName;
	private String lastName;
	private String[] personalCards;
	private Queue<String> cardQueue;
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the personalCards
	 */
	public String[] getPersonalCards() {
		return this.personalCards;
	}
	/**
	 * @param personalCards the personalCards to set
	 */
	public void setPersonalCards(String[] personalCards) {
		this.personalCards = personalCards;
	}
	
	public void sortCards(){
		this.personalCards = CommonAlgorithms.bubbleSortForString(this.personalCards);
	}
	/**
	 * @return the cardQueue
	 */
	public Queue<String> getCardQueue() {
		return this.cardQueue;
	}
	/**
	 * @param cardQueue the cardQueue to set
	 */
	public void setCardQueue() {
		for(int i=0;i<this.personalCards.length;i++){
			this.cardQueue.add(this.personalCards[i]);
		}
	}
}
