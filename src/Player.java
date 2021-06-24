abstract class Player {
	
	
	protected int wins = 0;
	protected String playerType;
	protected String choice;
	
	public Player() {
		
	}
	abstract String getChoice();
	
	abstract String getName();
	
	
	
	protected void winsRound() {  // I add one win whenever the user wins a round.
		this.wins++;
	}
}
