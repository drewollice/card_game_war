import card_game.Player;
import card_game.collections.FrenchDeck;
import war.Battle;

public class Driver
{
	public static void main ( final String[] args )
	{
		// Create a new Deck and deal cards to all players.
		new FrenchDeck().dealCards( Player.values() );
		
		boolean anotherRound = true;
		
		for ( int i = 1; anotherRound; i++ )
		{
			System.out.println( "Round Number:\t" + i );
			
			final Battle battle = Battle.doBattle( Player.PLAYER_1,
												   Player.PLAYER_2 );
			
			anotherRound = ! battle.isGameOver();
			
			if ( battle.isGameOver() )
			{
				System.out.println( battle.getLoserOfGame()
										  .getName() + " loses due to running out of cards.\nggez" );
			}
			
			System.out.println();
		}
	}
}
