public class ComputerPlayer extends Player{
	
	public ComputerPlayer() {
		
	}
	
	protected String getChoice() {

		int rand = (int) (Math.random() * 3);
		
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

	protected void winsRound() {  // I add one win whenever the user wins a round.
		super.winsRound();
	}

	@Override
	String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
