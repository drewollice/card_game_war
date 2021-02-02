package card_game.cards;

public enum Color
{
	RED("\u001B[31m"),
	BLACK("\u001B[30m"),
	GREEN("\u001B[32m"),
	BLUE("\u001B[34m");
	
	private final String text;
	
	Color (final String text)
	{
		this.text = text;
	}
	
	public String getText ()
	{
		return text;
	}
	
	@Override
	public String toString ()
	{
		return text;
	}
}
