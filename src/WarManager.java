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
		this.currentWarStrike = 1;
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
	
	private boolean someOneLost() {
	
		return	(! this.playerOneDeck.lostInWar() && this.playerTwoDeck.lostInWar()) ||
				(this.playerOneDeck.lostInWar() && ! this.playerTwoDeck.lostInWar());
				
	}
	
	private String whoLost() {
		
		if ((! this.playerOneDeck.lostInWar() && this.playerTwoDeck.lostInWar()))
			return "Player 1 Won the WAR";
		else
			return "Player 2 Won the WAR";
	}
	
	public void letsPlayWar() {
		
		Card playerOneCard, playerTwoCard ;
		
		while ( ! someOneLost() ) {
			
			playerOneCard = this.playerOneDeck.dealNextCard();
			playerTwoCard = this.playerTwoDeck.dealNextCard();

			
			// War logic
			if (this.atWar && this.currentWarStrike < MAX_WAR_SEQUENCE)	{
				
				// insert the new cards to the main Deck
				this.dealerDeck.insertNewCardToDeck(playerOneCard);	
				this.dealerDeck.insertNewCardToDeck(playerTwoCard);
				
				this.currentWarStrike++;
			}
			else if ( this.atWar && this.currentWarStrike == MAX_WAR_SEQUENCE)	{ 		// Reached final iteration of war
			
				if( playerOneCard.getFaceNumber() == playerTwoCard.getFaceNumber())	{
					// New war - Init the counter of war for next war run
					this.currentWarStrike = 0;		
				}
				else if(playerOneCard.getFaceNumber() > playerTwoCard.getFaceNumber() )
				{
					
				}
			}
				
				
		}
	}
	
}
