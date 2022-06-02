public class Player {
	
	// Fields
//	private String playerName;
	private String playerLetter;
	
	// Constructors
	public Player(String l) {
		playerLetter = l;
	}
	
	public String getPlayerLetter() {
		return playerLetter;
	}
	
	// Methods
	public String toString() {
		return "Player letter: " + playerLetter;
	}
}
