

//  Class represents a Card in the Deck 
// Each card contains two String attributes of Face (Value to compare) and Suit (Type of card)
// In Addition, I created a method that calculate the numeric value of each face - for comparison in the war

public class Card {
	
	private final String cardFace;		// Face of cards - {1- Ace, 2- Deuce, 3- Three, 4- Four... 11- Jack, 12- Queen, 13- King}
	private final String cardSuit;	// Suit of cards - {"Hearts", "Diamonds", "Clubs", "Spades"}
	
	private final int DEFAULT_ACE_VALUE = 15;		// Higher Ace Value than all others
	
	
	// The consturctor of the Card - with its toTitleCase Method that validate the Case
	public Card	(String cardFace, String cardSuit) {
		
		this.cardFace = toTitleCase(cardFace);
		this.cardSuit = toTitleCase(cardSuit);
	}
	
	
	public String getCardSuit() {
		return this.cardSuit;
	}
	
	public String getCardFace () {
		return this.cardFace;
	}
	
	// Return the FaceName numeric value of the current card 
	public int getFaceNumber() {
		
		int noOfFaceToReturn = 0;
		
		switch (this.cardFace) {
		case "Ace":		
			noOfFaceToReturn = DEFAULT_ACE_VALUE;
			break;
		case "Deuce":
			noOfFaceToReturn = 2;
			break;
		case "Three":
			noOfFaceToReturn = 3;
			break;
		case "Four":
			noOfFaceToReturn = 4;
			break;
		case "Five":
			noOfFaceToReturn = 5;
			break;
		case "Six":
			noOfFaceToReturn = 6;
			break;
		case "Seven":
			noOfFaceToReturn = 7;
			break;
		case "Eight":
			noOfFaceToReturn = 8;
			break;
		case "Nine":
			noOfFaceToReturn = 9;
			break;
		case "Ten":
			noOfFaceToReturn = 10;
			break;
		case "Jack":
			noOfFaceToReturn = 11;
			break;
		case "Queen":
			noOfFaceToReturn = 12 ;
			break;
		case "King":
			noOfFaceToReturn = 13;
			break;
		default:
			
			break;
		}
		
		return noOfFaceToReturn;
	}
		
	// toString method to print the Current card in a understandable way 
	public String toString() {
		return this.cardFace + " of " + this.cardSuit; 
	}
	
	//Private method to set the correct values of the card - to titleCase - to avoid faces and suits that are not in the correct Case.
	private String toTitleCase(String property) {	
		
		if(property.length() == 0)
			return property;
		
		return property.substring(0, 1).toUpperCase().concat(property.substring(1).toLowerCase());	
	}
	

}
