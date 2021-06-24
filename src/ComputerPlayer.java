public class ComputerPlayer extends Player{
	
	public ComputerPlayer() {
		
	}
	
	@Override
	public String getChoice() {

		int rand = (int) (Math.random() * 3);
		String choice = null;
		switch(rand) { // Assign the computer move depending on the randomly generated number.
		case 0:
			choice = "rock";
			break;			
		case 1:
			choice = "paper";
			break;		

		case 2:
			choice = "scissors";
			break;		
		}

		return choice;
	}

	@Override
	void printWinMessage() {
		System.out.println(name + " HAS WON!");
	}

	@Override
	void createName(int playerNumber) {
		this.name = "Computer " + playerNumber;
		
	}
}
