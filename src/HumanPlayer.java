import java.util.Scanner;

public class HumanPlayer extends Player{
	
	protected String name;
	
	public HumanPlayer() {

	
	}
	
	protected String getName() {
		Scanner playerName = new Scanner(System.in); // User input for the name.
		System.out.print("What is your name?: ");
		name = playerName.nextLine();
		
		return name;
	}
	
	protected String getChoice() {
		
		Scanner playerChoice = new Scanner(System.in);
		System.out.println(name  + ", enter your choice ('rock', 'paper' or 'scissors'): ");
		choice = playerChoice.nextLine();
		
		if(!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissors")) { // The input of the user has to be between 0 and 2.
			System.out.println("Invalid input.");
			
		}
		
		return choice;
	}
	
	protected void winsRound() {  // I add one win whenever the user wins a round.
		super.winsRound();
	}

}
