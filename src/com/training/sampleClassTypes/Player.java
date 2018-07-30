/**
 * 
 */
package com.training.sampleClassTypes;

import java.util.Queue;

import com.training.utility.CommonAlgorithms;
import com.training.utility.InputScanner;
import com.training.utility.QueueCustom;

/**
 * @author bridgelabz
 *
 */
public class Player {
	private String firstName;
	private String lastName;
	private String[] personalCards;
	private QueueCustom<String> myQueue;

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
	 * @return the myQueue
	 */
	public QueueCustom<String> getMyQueue() {
		return this.myQueue;
	}
	/**
	 * @param myQueue the myQueue to set
	 */
	public void setMyQueue() {
		this.myQueue = new QueueCustom<String>();
		String suit[] = InputScanner.initializeSuit();
		String rank[] = InputScanner.initializeRank();
		for(int i=0;i<this.personalCards.length;i++){
			String element = suit[Integer.valueOf(this.personalCards[i].substring(0, 1))];
			element = element + " " + rank[Integer.valueOf(this.personalCards[i].substring(2, this.personalCards[i].length()))];
			this.myQueue.enQueueCustom(element);
		}
	}
}
