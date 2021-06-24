

public class Player {
	
	protected String name;
	protected int lives = 3;
	protected int wins = 0;


	public Player() {//String name, int lives
		//this.name = name;
		//this.lives = lives;
		
	}
	
	protected void reduceLives() {		
		this.lives--;
	}
	
	protected void winsRound() {
		this.wins++;
	}
}
