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
	
	
		for( int count =0; count < NO_OF_CARDS; count++) 
			insertNewCardToDeck(new Card(faces[count % NO_OF_FACES],suits[count / NO_OF_FACES]));
		
		shuffleDeck();
	
	}
	
	
	public String toString() {
		
		return this.deckOfCards.toString();
	}
	
	// Private method to shuffle the deck
	private void shuffleDeck() {
		
		int second;
		
		for( int first = 0; first < NO_OF_CARDS; first++)	{
			
			second = randomNumber.nextInt(NO_OF_CARDS);
			
			Card temp  = this.deckOfCards.get(first);
			this.deckOfCards.set(first, this.deckOfCards.get(second));
			this.deckOfCards.set(second, temp);
		}
		
	}
	
	// Method to empty the dealers deck and move all cards to the winner's deck
	public void emptyDeckToWinnerDeck(DeckOfCards winnerDeck){
		
		Card removedCard = this.dealNextCard();
		
		while(removedCard != null)	{
			
			winnerDeck.insertNewCardToDeck(removedCard);
			removedCard = this.dealNextCard();
		}
	}
	
	
	// Check if the current player lost in the war?
	public boolean lostInWar() {
		
		return this.deckOfCards.size() == 0;
	}
	
	
	public static void main(String[] args ) {
		
		DeckOfCards d1 = new DeckOfCards();
		d1.loadAndShuffle();
		System.out.println(d1);
		
	}
}
