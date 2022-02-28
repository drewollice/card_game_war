package war;

import card_game.Player;
import card_game.cards.Card;

import java.util.Collection;

public class War extends Battle
{
	public War ( final Collection< Card > spoilsOfWar,
				 final Player player1,
				 final Player player2 )
	{
		super( spoilsOfWar,
			   player1,
			   player2 );
	}
	
	
	@Override
	public War run ()
	{
		this.promptUser();
		
		this.drawCards();
		
		if ( this.spoilsOfWar.contains( null ) )
		{
			return this;
		}
		else if ( this.determineRoundWinner() )
		{
			this.toTheVictorGoTheSpoils();
		}
		else
		{
			return new War( this.spoilsOfWar,
							this.player1,
							this.player2 ).run();
		}
		
		return this;
	}
	
	
	@Override
	protected void promptUser ()
	{
		System.out.println( "TIME FOR WAR!" );
	}
	
	private void drawCards ()
	{
		// Player 1 attempts to draw. If unable, he loses.
		this.spoilsOfWar.addAll( this.player1.drawCards( 3,
														 false ) );
		this.card1 = this.player1.drawCard( true );
		if ( null == this.card1 || this.spoilsOfWar.contains( null ) )
		{
			this.loserOfGame = this.player1;
			this.gameOver = true;
		}
		// Player 2 attempts to draw. If unable, he loses.
		this.spoilsOfWar.addAll( this.player2.drawCards( 3,
														 false ) );
		this.card2 = this.player2.drawCard( true );
		if ( null == this.card2 || this.spoilsOfWar.contains( null ) )
		{
			this.loserOfGame = this.player2;
			this.gameOver = true;
		}
		// Add both cards to the prize pool.
		this.spoilsOfWar.add( this.card1 );
		this.spoilsOfWar.add( this.card2 );
	}
}
