import java.util.Scanner;

public class HumanPlayer extends Player{

	public HumanPlayer() {


	}

	@Override
	public String getChoice() { 
		// This function gets the input from the user to obtain the move of the player.
		String choice = null;
		Scanner playerChoice = new Scanner(System.in);
		while(choice == null) {
			System.out.println(name  + ", enter your choice ('rock', 'paper' or 'scissors'): ");
			choice = playerChoice.nextLine();

			if(!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissors")) { // The input of the user has to be between 0 and 2.
				System.out.println("Invalid input.");
				choice = null;
			}
		}

		return choice;
	}

	@Override
	void printWinMessage() {
		System.out.println(name + " HAS WON!");
	}

	@Override
	void createName(int playerNumber) {
		// This function gets the input from the user to obtain the name of the player.
		Scanner playerName = new Scanner(System.in); // User input for the name.
		System.out.print("What is your name?: ");
		this.name = playerName.nextLine();
	}

}
