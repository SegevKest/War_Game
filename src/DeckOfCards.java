import java.security.SecureRandom;
import java.util.ArrayList;




public class DeckOfCards {

	private static final SecureRandom randomNumber = new SecureRandom();
	private static final int NO_OF_CARDS = 52;
	private static final int NO_OF_FACES = 13;
	
	private static final int HEAD_OF_DECK = 0;
	
	private ArrayList<Card> deckOfCards;
	private int headOfDeck ;	
	
	
	public DeckOfCards() {
		
		deckOfCards = new ArrayList<Card>();
		this.headOfDeck = HEAD_OF_DECK;
	}
	
	
	// Deal the next Card from head of deck and increase head of deck
	public Card dealNextCard() {
		
		if (this.headOfDeck < this.deckOfCards.size()) 
			 return this.deckOfCards.remove(this.headOfDeck);
		
		else
			return null;
	}
	
	// Insert new card to the end of the deck
	public void insertNewCardToDeck(Card newCard) {
		
		if(newCard instanceof Card)	
			this.deckOfCards.add(newCard);
		
		else
			System.out.println("Not Valid Card Entered");
	}
	
	
	public void loadAndShuffle() {
		
		String[] faces = {"Ace","Deuce","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
		String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
	
	
		for( int count =0; count < NO_OF_CARDS; count++) 
			this.insertNewCardToDeck(new Card(faces[count % NO_OF_FACES],suits[count / NO_OF_FACES]));
		
		shuffleDeck();
	
	}
	
	
	//Public getSize method to print size of deck
	public int getSizeOfDeck() {
		return this.deckOfCards.size();
	}
	
	
	//Public toString method to print the Deck
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
	public boolean lostInGame() {
		
		return this.deckOfCards.size() == 0;
	}
	
}
