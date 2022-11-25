package card_game.cards;

import card_game.Player;
import card_game.collections.CardCollection;

public class Card implements Comparable< Card >
{
	private final Rank rank;
	private final Suit suit;
	private final Color color;
	
	private boolean faceUp;
	
	private Player owner;
	private CardCollection cardCollection;
	
	public Card ( final Rank rank,
				  final Suit suit,
				  final Color color )
	{
		this.rank = rank;
		this.suit = suit;
		this.color = color;
		this.faceUp = false;
	}
	
	@Override
	public String toString ()
	{
		return this.faceUp
			   ? this.color + this.suit.getText() + " " + this.rank.getText() + "\u001B[0m"
			   : "FACE-DOWN";
	}
	
	public Rank getRank ()
	{
		return this.rank;
	}
	
	public Suit getSuit ()
	{
		return this.suit;
	}
	
	public Color getColor ()
	{
		return this.color;
	}
	
	public Player getOwner ()
	{
		return this.owner;
	}
	
	public void setOwner ( final Player owner )
	{
		this.owner = owner;
	}
	
	public CardCollection getCardCollection ()
	{
		return this.cardCollection;
	}
	
	public void setCardCollection ( final CardCollection cardCollection )
	{
		this.cardCollection = cardCollection;
	}
	
	public boolean isFaceUp ()
	{
		return this.faceUp;
	}
	
	public void setFaceUp ( final boolean faceUp )
	{
		this.faceUp = faceUp;
	}
	
	@Override
	public int compareTo ( final Card card )
	{
		return this.getRank()
				   .compareTo( card.getRank() );
	}
}
