package card_game.collections;

import card_game.Player;
import card_game.cards.Card;
import card_game.cards.Color;
import card_game.cards.Rank;
import card_game.cards.Suit;


public class FrenchDeck extends Deck
{
	private static final long serialVersionUID = - 8022321187795010922L;
	
	public FrenchDeck ()
	{
		super();
		
		Card card = null;
		
		for (final Suit suit : Suit.values())
		{
			for (final Rank rank : Rank.values())
			{
				if (suit.equals(Suit.CLUBS) || suit.equals(Suit.SPADES))
				{
					card = new Card(rank, suit, Color.BLACK);
				}
				else if (suit.equals(Suit.DIAMONDS) || suit.equals(Suit.HEARTS))
				{
					card = new Card(rank, suit, Color.RED);
				}
				
				this.push(card);
			}
		}
		shuffleCards();
//		this.sort(Card::compareTo);
	}
	
	public FrenchDeck (final Player owner)
	{
		super(owner);
		
		Card card = null;
		
		for (final Suit suit : Suit.values())
		{
			for (final Rank rank : Rank.values())
			{
				if (suit.equals(Suit.CLUBS) || suit.equals(Suit.SPADES))
				{
					card = new Card(rank, suit, Color.BLACK);
				}
				else if (suit.equals(Suit.DIAMONDS) || suit.equals(Suit.HEARTS))
				{
					card = new Card(rank, suit, Color.RED);
				}
				
				this.push(card);
			}
		}
		shuffleCards();
	}
}
