import javax.swing.JOptionPane;


// The main War Class - that will represnt the Dealer stand point
// This class contains 3 Decks - The Dealer and for each player.
// It will handle all the logic for the game

public class WarManager {

	private static final int MAX_WAR_SEQUENCE = 3;
	private static final int MIN_WAR_SEQUENCE = 1;
	
	private DeckOfCards dealerDeck;
	private DeckOfCards playerOneDeck;
	private DeckOfCards playerTwoDeck;
	
	private boolean playersTurn; 		 // True = player 1, False = Player 2
	private boolean atWar;				// Flag indicates if we are at war
	
	private int currentWarStrike; 		// Counter indicates the current strike of war games
	
	
	// Initiate the Dealer's Deck
	public WarManager() {
		
		this.dealerDeck = new DeckOfCards();
		this.dealerDeck.loadAndShuffle();
		
		this.playersTurn = true;
		this.atWar = false;
		this.currentWarStrike = 0;
		
	}
	
	// The dealer splits its Deck to the Players equally- by its turn
	public void dealerSplitsToPlayers() {
		
		this.playerOneDeck = new DeckOfCards();
		this.playerTwoDeck = new DeckOfCards();
		
		Card cardToDeal = this.dealerDeck.dealNextCard();
		
		while (cardToDeal != null)
		{
			
			if( playersTurn )
				this.playerOneDeck.insertNewCardToDeck(cardToDeal);
			else
				this.playerTwoDeck.insertNewCardToDeck(cardToDeal);

			playersTurn = !playersTurn;
			cardToDeal = this.dealerDeck.dealNextCard();
			
		}	
	}
	
	// Private method to check if a player lost
	private boolean someOneLostTheGame() {
	
		return	(! this.playerOneDeck.lostInGame() && this.playerTwoDeck.lostInGame()) ||
				(this.playerOneDeck.lostInGame() && ! this.playerTwoDeck.lostInGame());		
	}
	
	// Private method for the final step - after someone lost
	private String whoLostTheGame() {
		
		if ((! this.playerOneDeck.lostInGame() && this.playerTwoDeck.lostInGame()))
			return "Player 1 Won the GAME";
		else
			return "Player 2 Won the GAME";
	}
	
	
	
	// All the war logic inside this method
	public void letsPlayWar() {
		
		int playerOneCardVal = 0, playerTwoCardVal = 0;
		Card playerOneCard, playerTwoCard ;
		
		while ( ! someOneLostTheGame() ) {
			
			// Get the 2 next cards
			playerOneCard = this.playerOneDeck.dealNextCard();
			playerTwoCard = this.playerTwoDeck.dealNextCard();

			// Get the numeric value of each card
			playerOneCardVal = playerOneCard.getFaceNumber();
			playerTwoCardVal = playerTwoCard.getFaceNumber();
			
			JOptionPane.showMessageDialog(null, " Player 1 Card: "+playerOneCard);
			JOptionPane.showMessageDialog(null, " Player 2 Card: "+playerTwoCard);
			
			// insert the new cards to the main Deck
			this.dealerDeck.insertNewCardToDeck(playerOneCard);	
			this.dealerDeck.insertNewCardToDeck(playerTwoCard);
			
			// War logic
			if ( ! this.atWar)	{
				if (playerOneCardVal == playerTwoCardVal)	{
					this.atWar = true;
					this.currentWarStrike = MIN_WAR_SEQUENCE;
				}
				else if( playerOneCardVal > playerTwoCardVal)	{ 
					//Player 1 won the Round
					this.dealerDeck.emptyDeckToWinnerDeck(this.playerOneDeck);
					JOptionPane.showMessageDialog(null, " Player 1 Won Round and get cards! ");
				}
				else	{
					//Player 2 won the Round
					this.dealerDeck.emptyDeckToWinnerDeck(this.playerTwoDeck);
					JOptionPane.showMessageDialog(null, " Player 2 Won Round and get cards! ");
				}
			}
			else	{
				if ( this.currentWarStrike < MAX_WAR_SEQUENCE)
					this.currentWarStrike++;
				
				else if( this.currentWarStrike == MAX_WAR_SEQUENCE)	{
					
					if (playerOneCardVal == playerTwoCardVal)
						// Continue with war but counter return to 0 for more 3 iterations
						this.currentWarStrike = MIN_WAR_SEQUENCE;
					
					else {
						if( playerOneCardVal > playerTwoCardVal)	{ 
							//Player 1 won the Round
							this.dealerDeck.emptyDeckToWinnerDeck(this.playerOneDeck);
							JOptionPane.showMessageDialog(null, " Player 1 Won Round and get cards! ");

						}
						else	{
							//Player 2 won the Round
							this.dealerDeck.emptyDeckToWinnerDeck(this.playerTwoDeck);
							JOptionPane.showMessageDialog(null, " Player 2 Won Round and get cards! ");
						}
						
						this.atWar = false;
						this.currentWarStrike = MIN_WAR_SEQUENCE;
					}
				}
			}
				
		}
		
		JOptionPane.showMessageDialog(null, whoLostTheGame());
	}
	
	
	// The game  
	public static void main(String[] args) {
		
		WarManager warGame = new WarManager();
		
		warGame.dealerSplitsToPlayers();
		
		warGame.letsPlayWar();
	
	}
	
}
