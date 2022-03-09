
public class Card {
	
	private final int cardFace;		// Face of cards - {1- Ace, 2- Deuce, 3- Three, 4- Four... 11- Jack, 12- Queen, 13- King}
	private final String cardSuit;	// Suit of cards - {"Hearts", "Diamonds", "Clubs", "Spades"}
	
	
	
	

	public Card	(int cardFace, String cardSuit) {
		this.cardFace = cardFace;
		this.cardSuit = cardSuit;
	}
	
	
	public String getCardSuit() {
		return this.cardSuit;
	}
	
	public int getCardNumber () {
		return this.cardFace;
	}
	
	// Return the FaceName of the current card - by its value
	public String getFaceName() {
		
		String faceToReturn = "";
		
		switch (this.cardFace) {
		case 1:
			faceToReturn = "Ace";
			break;
		case 2:
			faceToReturn = "Deuce";
			break;
		case 3:
			faceToReturn = "Three";
			break;
		case 4:
			faceToReturn = "Four";
			break;
		case 5:
			faceToReturn = "Five";
			break;
		case 6:
			faceToReturn = "Six";
			break;
		case 7:
			faceToReturn = "Seven";
			break;
		case 8:
			faceToReturn = "Eight";
			break;
		case 9:
			faceToReturn = "Nine";
			break;
		case 10:
			faceToReturn = "Ten";
			break;
		case 11:
			faceToReturn = "Jack";
			break;
		case 12:
			faceToReturn = "Queen";
			break;
		case 13:
			faceToReturn = "King";
			break;
		default:
			break;
		}
		
		return faceToReturn;
	}
	
	
	public String toString() {
		return getFaceName() + " of " + this.cardSuit; 
	}
	
	
	public static void main(String[] args) { 
		
	} 

}
