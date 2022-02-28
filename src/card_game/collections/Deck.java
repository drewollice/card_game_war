package card_game.collections;

import card_game.Player;


public class Deck extends CardCollection
{
	private static final long serialVersionUID = 8117253323776284937L;
	
	public Deck ()
	{
		super( null );
	}
	
	public Deck ( final Player owner )
	{
		super( owner );
	}
	
	public void dealCards ( final Player... players )
	{
		while ( ! this.isEmpty() )
		{
			for ( final Player player : players )
			{
				if ( this.peek() != null )
				{
					player.getDeck()
						  .push( this.pop() );
				}
			}
		}
	}
	
}
