package card_game;


import card_game.cards.Card;
import card_game.collections.CardCollection;
import card_game.collections.Deck;

import java.util.Collection;
import java.util.Stack;

public enum Player
{
	PLAYER_1("Drew"),
	PLAYER_2("Sam"),
	;
	
	private final String name;
	private final Deck deck;
	private final CardCollection discard;
	
	Player (final String name)
	{
		this.name = name;
		this.deck = new Deck(this);
		this.discard = new CardCollection(this);
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	public Deck getDeck ()
	{
		return this.deck;
	}
	
	public CardCollection getDiscard ()
	{
		return this.discard;
	}
	
	public Card drawCard (final boolean revealCard)
	{
		// If no deck and no discard, and return null.
		if (this.getDeck().isEmpty() && this.getDiscard().isEmpty())
		{
			System.out.println(this.getName() + " cannot draw.");
			return null;
		}
		// If no deck but discard remains, recycle before drawing again.
		else if (this.getDeck().isEmpty())
		{
			recycle();
		}
		
		final Card drawnCard = this.getDeck().pop();
		drawnCard.setFaceUp(revealCard);
		System.out.println(this.getName() + " draws:\t" + drawnCard);
		return drawnCard;
	}
	
	public Collection<Card> drawCards (final int count, final boolean revealCards)
	{
		final Collection<Card> cards = new Stack<>();
		
		for (int i = 0; i < count; i++)
		{
			cards.add(this.drawCard(revealCards));
		}
		
		return cards;
	}
	
	public void recycle ()
	{
		System.out.println(this.getName() + "'s discard recycled into deck.");
		
		while (! this.getDiscard().isEmpty())
		{
			this.getDeck().push(this.getDiscard().pop());
		}
	}
	
	public static void printDecks ()
	{
		final StringBuilder sb = new StringBuilder(125);
		
		for (final Player player : Player.values())
		{
			sb.setLength(0);
			sb.append(player.getName()).append(" Deck:\t{ ");
			for (final Card card : player.getDeck())
			{
				sb.append(card).append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
			sb.append(" }");
			System.out.println(sb);
		}
	}
}
