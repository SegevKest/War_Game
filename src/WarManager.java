import javax.swing.JOptionPane;



public class WarManager {

	private static final int MAX_WAR_SEQUENCE = 3;
	
	private DeckOfCards dealerDeck;
	private DeckOfCards playerOneDeck;
	private DeckOfCards playerTwoDeck;
	
	private boolean playersTurn; 		 // True = player 1, False = Player 2
	private boolean atWar;				// Flag indicates if we are at war
	
	private int currentWarStrike; 		// Counter indicates the current strike of war games
	
	public WarManager() {
		
		this.dealerDeck = new DeckOfCards();
		this.dealerDeck.loadAndShuffle();
		
		this.playersTurn = true;
		this.atWar = false;
		this.currentWarStrike = 0;
	}
	
	
	public void dealerSplitsToPlayers() {
		
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
	
	
	private boolean someOneLostTheGame() {
	
		return	(! this.playerOneDeck.lostInGame() && this.playerTwoDeck.lostInGame()) ||
				(this.playerOneDeck.lostInGame() && ! this.playerTwoDeck.lostInGame());
				
	}
	
	
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
			
			playerOneCard = this.playerOneDeck.dealNextCard();
			playerTwoCard = this.playerTwoDeck.dealNextCard();

			playerOneCardVal = playerOneCard.getFaceNumber();
			playerTwoCardVal = playerTwoCard.getFaceNumber();
			
			// insert the new cards to the main Deck
			this.dealerDeck.insertNewCardToDeck(playerOneCard);	
			this.dealerDeck.insertNewCardToDeck(playerTwoCard);
			
			// War logic
			if ( ! this.atWar)	{
				if (playerOneCardVal == playerTwoCardVal)	{
					this.atWar = true;
					this.currentWarStrike = 0;
				}
				else if( playerOneCardVal > playerTwoCardVal)	{ 
					//Player 1 won the Round
					
					// Add the output Here
					this.dealerDeck.emptyDeckToWinnerDeck(this.playerOneDeck);
				}
				else	{
					//Player 2 won the Round
					
					// Add the output Here
					this.dealerDeck.emptyDeckToWinnerDeck(this.playerTwoDeck);
				}
			}
			else	{
				if ( this.currentWarStrike < MAX_WAR_SEQUENCE)
					this.currentWarStrike++;
				
				else if( this.currentWarStrike == MAX_WAR_SEQUENCE)	{
					
					if (playerOneCardVal == playerTwoCardVal)
						// Continue with war but counter return to 0 for more 3 iterations
						this.currentWarStrike = 0;
					
					else {
						if( playerOneCardVal > playerTwoCardVal)	{ 
							//Player 1 won the Round
							
							// Add the output Here
							this.dealerDeck.emptyDeckToWinnerDeck(this.playerOneDeck);
						}
						else	{
							//Player 2 won the Round
							
							// Add the output Here
							this.dealerDeck.emptyDeckToWinnerDeck(this.playerTwoDeck);
						}
						
						this.atWar = false;
						this.currentWarStrike = 0;
					}
				}
			}
				
		}
		
		whoLostTheGame();
	}
	
	
	public static void main(String[] args) {
		
		
		
		
	}
	
}
