

public class Player {
	
	protected String name;
	protected int lives = 3;
	protected int wins = 0;
	
	protected void reduceLives() { // When the user loses a round, he loses one life.
		this.lives--;
	}
	
	protected void winsRound() {  // I add one win whenever the user wins a round.
		this.wins++;
	}
}
