
import card_game.Player;
import card_game.collections.Deck;
import card_game.collections.FrenchDeck;
import war.Battle;

public class Driver
{
	public static void main (final String[] args)
	{
		Deck.dealCards(new FrenchDeck(), Player.values());
		
		for (int i = 1; true; i++)
		{
			System.out.println("Round Number:\t" + i);
			final Battle battle = new Battle(Player.PLAYER_1, Player.PLAYER_2).run();
			
			if (battle.isGameOver())
			{
				System.out.println(battle.getLoserOfGame().getName() + " loses due to running out of cards.\nggez");
				System.exit(0);
			}
			System.out.println();
		}
	}
}
