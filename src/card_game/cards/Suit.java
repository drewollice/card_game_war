package card_game.cards;

public enum Suit
{
	CLUBS( "♣" ),
	DIAMONDS( "♦" ),
	HEARTS( "♥" ),
	SPADES( "♠" );
	
	private final String text;
	
	Suit ( final String text )
	{
		this.text = text;
	}
	
	public String getText ()
	{
		return text;
	}
}