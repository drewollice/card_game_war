package card_game.collections;

import card_game.Player;
import card_game.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class CardCollection extends Stack< Card >
{
	private static final long serialVersionUID = - 6077104032431556622L;
	
	final private Player owner;
	
	public CardCollection ( final Player owner )
	{
		super();
		
		this.owner = owner;
	}
	
	public void shuffleCards ()
	{
		final List< Object > shuffledList = new ArrayList<>( new HashSet<>( this ) );
		Collections.shuffle( shuffledList );
		
		this.setSize( 0 );
		this.setSize( shuffledList.size() );
		
		this.elementData = shuffledList.toArray();
	}
	
	public int countCards ()
	{
		return this.size();
	}
	
	@Override
	public Card push ( final Card card )
	{
		card.setOwner( this.owner );
		card.setCardCollection( this );
		
		this.addElement( card );
		
		return card;
	}
	
	@Override
	public Card pop ()
	{
		final Card card = peek();
		removeElementAt( this.size() - 1 );
		card.setOwner( null );
		card.setCardCollection( null );
		return card;
	}
	
	public void removeCard ( final Card card )
	{
		card.setOwner( null );
		card.setCardCollection( null );
		this.remove( card );
	}
	
	public void removeCard ( final int index )
	{
		this.removeCard( this.get( index ) );
	}
	
	public Card revealCard ( final int index )
	{
		return countCards() != 0 && countCards() >= index
			   ? this.get( index )
			   : null;
	}
	
	public boolean containsCard ( final Card card )
	{
		return this.contains( card );
	}
}
