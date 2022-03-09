import java.security.SecureRandom;
import java.util.ArrayList;




public class DeckOfCards {

	private static final SecureRandom randomNumber = new SecureRandom();
	private static final int NO_OF_CARDS = 52;
	private static final int NO_OF_FACES = 13;
	
	private ArrayList<Card> deckOfCards;
	private int headOfDeck ;
	private int tailOfDeck ;
	
	
	
	public DeckOfCards() {
		
		deckOfCards = new ArrayList<Card>();
		this.headOfDeck = 0;
		this.tailOfDeck = 0;
	}
	
	
	// Deal the next Card from head of deck and increase head of deck
	public Card dealNextCard() {
		
		if (this.headOfDeck < this.tailOfDeck)
			return this.deckOfCards.remove(headOfDeck++);
		else
			return null;
	}
	
	// Insert new card to the end of the deck
	public void insertNewCardToDeck(Card newCard) {
		
		if(newCard instanceof Card)	{
			this.deckOfCards.add(newCard);
			this.tailOfDeck++;
		}
		else
			System.out.println("Not Valid Card Entered");
	}
	
	
	public void loadAndShuffle() {
		
		String[] faces = {"Ace","Deuce","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
		String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
	
	
		for( int count =0; count < NO_OF_CARDS; count++) {
			
			insertNewCardToDeck(new Card(faces[count % NO_OF_FACES],suits[count / NO_OF_FACES]));
		}
	
	}
	
	
	public String toString() {
		
		return this.deckOfCards.toString();
	}
	
	
	public static void main(String[] args ) {
		
		DeckOfCards d1 = new DeckOfCards();
		d1.loadAndShuffle();
		System.out.println(d1);
		
	
	}
	
}
