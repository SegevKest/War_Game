
public class Card {
	
	private final String cardFace;		// Face of cards - {1- Ace, 2- Deuce, 3- Three, 4- Four... 11- Jack, 12- Queen, 13- King}
	private final String cardSuit;	// Suit of cards - {"Hearts", "Diamonds", "Clubs", "Spades"}
	
	public Card	(String cardFace, String cardSuit) {
		this.cardFace = cardFace;
		this.cardSuit = cardSuit;
	}
	
	
	public String getCardSuit() {
		return this.cardSuit;
	}
	
	public String getCardFace () {
		return this.cardFace;
	}
	
	// Return the FaceName of the current card - by its value
	public int getFaceNumber() {
		
		int noOfFaceToReturn = 0;
		
		switch (this.cardFace) {
		case "Ace":
			noOfFaceToReturn = 1;
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
	
	
	public String toString() {
		return this.cardFace + " of " + this.cardSuit; 
	}
	
	
	public static void main(String[] args) { 
		
		Card c1 = new Card("three", "Hearts");
		System.out.println(c1);
		System.out.println(c1.getFaceNumber());
	} 

}
