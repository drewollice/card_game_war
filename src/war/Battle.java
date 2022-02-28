package war;

import card_game.Player;
import card_game.cards.Card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Battle
{
	protected final Collection< Card > spoilsOfWar;
	protected final Player player1;
	protected final Player player2;
	protected Card card1;
	protected Card card2;
	protected Player winner;
	
	protected boolean gameOver;
	protected Player loserOfGame;
	
	
	public Battle ( final Player player1,
					final Player player2 )
	{
		this.spoilsOfWar = new ArrayList<>( 2 );
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public Battle ( final Collection< Card > spoilsOfWar,
					final Player player1,
					final Player player2 )
	{
		this.spoilsOfWar = spoilsOfWar;
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public static Battle doBattle ( final Player p1,
									final Player p2 )
	{
		return new Battle( p1,
						   p2 ).run();
	}
	
	public Battle run ()
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
	
	
	protected void promptUser ()
	{
		final int total = this.player1.getDeck()
									  .size() + this.player1.getDiscard()
															.size() + this.player2.getDeck()
																				  .size() + this.player2.getDiscard()
																										.size();
		System.out.println( "Total cards in game:\t" + total );
		
		System.out.println( this.player1.getName() + " Deck:\t" + this.player1.getDeck()
																			  .size() + "\tDiscard:\t" + this.player1.getDiscard()
																													 .size() );
		System.out.println( this.player2.getName() + " Deck:\t" + this.player2.getDeck()
																			  .size() + "\tDiscard:\t" + this.player2.getDiscard()
																													 .size() );
		
		new Scanner( System.in ).nextLine();// Toggle comment for testing.
		
		
	}
	
	private void drawCards ()
	{
		// Player 1 attempts to draw. If unable, he loses.
		this.card1 = this.player1.drawCard( true );
		if ( null == this.card1 )
		{
			this.loserOfGame = this.player1;
			this.gameOver = true;
		}
		// Player 2 attempts to draw. If unable, he loses.
		this.card2 = this.player2.drawCard( true );
		if ( null == this.card2 )
		{
			this.loserOfGame = this.player2;
			this.gameOver = true;
		}
		// Add both cards to the prize pool.
		this.spoilsOfWar.add( this.card1 );
		this.spoilsOfWar.add( this.card2 );
	}
	
	protected boolean determineRoundWinner ()
	{
		if ( 0 < this.card1.compareTo( this.card2 ) )
		{
			this.winner = this.player1;
		}
		else if ( 0 > this.card1.compareTo( this.card2 ) )
		{
			this.winner = this.player2;
		}
		
		if ( 0 == this.card1.compareTo( this.card2 ) )
		{
			System.out.println( "A TIE!" );
			return false;
		}
		else
		{
			System.out.println( "Winner is:\t" + this.winner.getName() + "!" );
			return true;
		}
	}
	
	protected void toTheVictorGoTheSpoils ()
	{
		this.spoilsOfWar.forEach( card -> this.winner.getDiscard()
													 .push( card ) );
	}
	
	
	public boolean isGameOver ()
	{
		return this.gameOver;
	}
	
	public Player getLoserOfGame ()
	{
		return this.loserOfGame;
	}
}
