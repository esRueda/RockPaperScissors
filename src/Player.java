abstract class Player {
	
	
	protected int wins = 0;
	protected String name = "Unknown";
	
	public Player() {
		
	}
	abstract String getChoice();
	
	abstract void printWinMessage(); //Function with the win message.

	static public Player createPlayer(String input) {
		
		if(input.equals("human")) {	
			HumanPlayer p = new HumanPlayer();
			return p;
			
		}
		else if(input.equals("computer")){
			return new ComputerPlayer();
		}
		
		
		return null;
		
	}
	
	public String getName() {
		return name;
	}
	
	abstract void createName(int playerNumber);
	
	public void winsRound() {  // I add one win whenever the user wins a round.
		this.wins++;
	}
	
	public int getWins() {
		return wins;
	}
}
